package Gamoneynew.Gamoneywelcomenew;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.datavec.api.io.converters.DoubleWritableConverter;
import org.datavec.api.io.converters.FloatWritableConverter;
import org.datavec.api.io.filters.BalancedPathFilter;
import org.datavec.api.io.labels.ParentPathLabelGenerator;
import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.api.split.InputSplit;
import org.datavec.api.transform.TransformProcess;
import org.datavec.api.transform.schema.Schema;
import org.datavec.api.util.ClassPathResource;
import org.datavec.image.loader.NativeImageLoader;
import org.datavec.image.recordreader.ImageRecordReader;
import org.datavec.image.transform.FlipImageTransform;
import org.datavec.image.transform.ImageTransform;
import org.datavec.local.transforms.LocalTransformExecutor;
//import org.deeplearning4j.api.storage.StatsStorage;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.datasets.iterator.MultipleEpochsIterator;
//import org.deeplearning4j.datasets.iterator.impl.CifarDataSetIterator;
import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.earlystopping.EarlyStoppingConfiguration;
import org.deeplearning4j.earlystopping.EarlyStoppingResult;
import org.deeplearning4j.earlystopping.saver.LocalFileModelSaver;
import org.deeplearning4j.earlystopping.scorecalc.DataSetLossCalculator;
import org.deeplearning4j.earlystopping.termination.MaxEpochsTerminationCondition;
import org.deeplearning4j.earlystopping.termination.MaxTimeIterationTerminationCondition;
import org.deeplearning4j.earlystopping.trainer.EarlyStoppingTrainer;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.ComputationGraphConfiguration;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.graph.MergeVertex;
import org.deeplearning4j.nn.conf.inputs.InputType;
import org.deeplearning4j.nn.conf.layers.ConvolutionLayer;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.Layer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.conf.layers.SubsamplingLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.api.IterationListener;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.ui.api.UIServer;
import org.deeplearning4j.ui.stats.StatsListener;
import org.deeplearning4j.ui.storage.InMemoryStatsStorage;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.ImagePreProcessingScaler;
import org.nd4j.linalg.dataset.api.preprocessor.NormalizerStandardize;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.learning.config.Sgd;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class Deep4JExamples {
	public static void CNN() throws IOException, InterruptedException {
//		var mnistTrain = new MnistDataSetIterator(32, true,123);
//				var mnistTest = new MnistDataSetIterator(32, false, 123);
//	    System.out.println(mnistTrain.getLabels());
	     ParentPathLabelGenerator labelMaker = new ParentPathLabelGenerator();
	        File mainPath = new File("C:\\Users\\Nikki singh\\Downloads\\CIFAR-10\\train");
	        RecordReader labelrecordReader = new CSVRecordReader(1) ; //skip first row
			
	        labelrecordReader.initialize(new FileSplit(new File("C:\\Users\\Nikki singh\\Downloads\\trainLabels.csv")));
			 //   System.out.println(labelrecordReader.next(50000).size());
			    //SCHEMA BEFORE TRANSFORMING LABELS
			    Schema inputDataSchema = new Schema.Builder()
			    		.addColumnInteger("id")
			    	    .addColumnCategorical("label")
			    	    .build();
			    //Transforming Schema Removing ID column
			    TransformProcess tp = new TransformProcess.Builder(inputDataSchema)
			    	    .removeColumns("id")
			    	    .build();
			    
			 var labels= LocalTransformExecutor.execute(labelrecordReader.next(50000), tp);
			 
			 System.out.println(labels.get(0));
			 NativeImageLoader nil = new NativeImageLoader(32,32, 3);
				INDArray input = Nd4j.create(new int[]{ 50000, 3, 32, 32 });
				INDArray output = Nd4j.create(new int[]{ 50000, 10 });
		
	        FileSplit fileSplit = new FileSplit(mainPath, NativeImageLoader.ALLOWED_FORMATS, new Random(123));
	        int numExamples = Math.toIntExact(fileSplit.length());
	        int numLabels=Math.toIntExact(fileSplit.length());
	        BalancedPathFilter pathFilter = new BalancedPathFilter(new Random(123), labelMaker, numExamples, numLabels,150);
            System.out.println(labelMaker);
	        System.out.println(numLabels+"-----"+numExamples+"----"+pathFilter+"---"+labels.get(0));
	        /**
	         * Split data: 80% training and 20% testing
	         */
	        //RETURN TWO ARRAY OF TRAINING N TESTING DATA
	        InputSplit[] inputSplit = fileSplit.sample(pathFilter, 0.7, 1 - 0.7);
	        InputSplit trainData = inputSplit[0];
	        InputSplit testData = inputSplit[1];
	        System.out.println(trainData);
	        //LIGHT DATA AUGMENETATION 
	        ImageTransform flipTransform1 = new FlipImageTransform(new Random(123));
	        ImageTransform flipTransform2 = new FlipImageTransform(new Random(123));
	        List<ImageTransform> transforms = Arrays.asList(new ImageTransform[]{flipTransform1, flipTransform2});
	        /**
	         * Normalization
	         **/
	        ImagePreProcessingScaler preProcessor = new ImagePreProcessingScaler(0, 1);
	        /**
	         * Define our network architecture:
	          */
	    MultiLayerConfiguration configuration = new NeuralNetConfiguration.Builder()
	    		  .seed(123)
	    		  .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
	    		  .dropOut(0.6)
	    		  .updater(new Adam(0.1, 0.9, 0.999, 0.01))
	    		  .list()
	    		  .layer(0,new ConvolutionLayer.Builder(5, 5)
	                      .stride(1, 1)
	                      .nOut(50)
	                      .activation(Activation.RELU)
	                      .build())
	                  .layer(1,new SubsamplingLayer.Builder(SubsamplingLayer.PoolingType.MAX)
	                      .kernelSize(2, 2)
	                      .stride(2, 2)
	                      .build())
	                  .layer(2,new ConvolutionLayer.Builder(3, 3)
	                      .stride(1, 1) // nIn need not specified in later layers
	                      .nOut(50)
	                      .activation(Activation.RELU)
	                      .build())
	                  .layer(3,new SubsamplingLayer.Builder(SubsamplingLayer.PoolingType.MAX)
	                      .kernelSize(2, 2)
	                      .stride(2, 2)
	                      .build())
	                  .layer(4,new DenseLayer.Builder().activation(Activation.RELU)
	                      .nOut(500)
	                      .build())
	                  .layer(5,new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
	                      .nOut(10)
	                      .activation(Activation.SOFTMAX)
	                      .build())
	                  .setInputType(InputType.convolutionalFlat(32, 32, 3)) // InputType.convolutional for normal image MOST IMP FUNCTION
	                  .build();
	    	var	network = new MultiLayerNetwork(configuration);
	    	network.init();
	    	// Visualizing Network Training
//	        UIServer uiServer = UIServer.getInstance();
//	        StatsStorage statsStorage = new InMemoryStatsStorage();
//	        uiServer.attach(statsStorage);
//	        network.setListeners((IterationListener) new StatsListener( statsStorage),new ScoreIterationListener(1));
	        //RECORD READER FOR IMAGES
	        ImageRecordReader recordReader = new ImageRecordReader(32, 32, 3, labelMaker);
	        DataSetIterator dataIter;
	      
	      //  MultipleEpochsIterator trainIter;
	        //TRAIN WITHOUT TRANSFORMATION
	        recordReader.initialize(trainData, null);//transformation is null
	        dataIter = new RecordReaderDataSetIterator(recordReader, 150, 1, numLabels);
	        preProcessor.fit(dataIter); //NORMALIZE IMAGES
	        dataIter.setPreProcessor(preProcessor); //Set Preprocessor to dataiterator
	        System.out.println(dataIter);
	        network.fit(dataIter);
	        // Train with transformations Number of TrainingImages will be incease
	        for (ImageTransform transform : transforms) {
	            System.out.print("\nTraining on transformation: " + transform.getClass().toString() + "\n\n");
	            recordReader.initialize(trainData, transform); //Flipping images 
	            dataIter = new RecordReaderDataSetIterator(recordReader, 150, 1, numLabels);
	            preProcessor.fit(dataIter);
	            dataIter.setPreProcessor(preProcessor);
	         //   trainIter = new MultipleEpochsIterator(150, dataIter);
	            network.fit(dataIter);
	        }
	        //eVALUATION PART
	        recordReader.initialize(testData);
	        dataIter = new RecordReaderDataSetIterator(recordReader, 150, 1, numLabels);
	        preProcessor.fit(dataIter);
	        dataIter.setPreProcessor(preProcessor);
	        Evaluation eval = network.evaluate(dataIter);
	      
	            ModelSerializer.writeModel(network,  "C:\\Users\\Nikki singh\\Downloads\\Models-DeepLearning", true);
	        
	}
    public static void ComputationGraphs() {
    	//USE IN MAKING COMPLEX NEUREL NETWORK WITH MANY LAYERS AND HYPERPARAM
    	ComputationGraphConfiguration conf = new NeuralNetConfiguration.Builder()
    	        .updater(new Sgd(0.01))
    	    .graphBuilder()
    	    .addInputs("input1", "input2")
    	    .addLayer("L1", new DenseLayer.Builder().nIn(3).nOut(4).build(), "input1")
    	    .addLayer("L2", new DenseLayer.Builder().nIn(3).nOut(4).build(), "input2")
    	    .addVertex("merge", new MergeVertex(), "L1", "L2")
    	    .addLayer("out", new OutputLayer.Builder().nIn(4+4).nOut(3).build(), "merge")
    	    .setOutputs("out")
    	    .build();
    }
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
			CNN();
//			RecordReader recordReader = new CSVRecordReader(1) ; //skip first row
//		
//		    recordReader.initialize(new FileSplit(new File("C:\\Users\\Nikki singh\\Downloads\\MINST_CSV\\mnist_train.csv")));
//		    
//		    RecordReaderDataSetIterator iterator = new RecordReaderDataSetIterator(
//            		  recordReader,12000,0,10);
//           
//           // System.out.println("Labels:"+iterator.getLabels());
//            		DataSet allData = iterator.next();
//            //		allData.shuffle(42);
//            		//System.out.println("Whatt--"+allData.getLabels());
//		    // …
//            	//DATANORMALIZATION BEFORE NEUREL NETWORK
//            		DataNormalization normalizer = new NormalizerStandardize();
//            		normalizer.fit(allData);
//            		normalizer.transform(allData);
//            		SplitTestAndTrain testAndTrain = allData.splitTestAndTrain(0.7);
//            		DataSet trainingData = testAndTrain.getTrain();
//            		System.out.println(trainingData.labelCounts());
//            		DataSet testData = testAndTrain.getTest();
//            	//NEUREL NET CONFIGS
//            		MultiLayerConfiguration config
//            		  = new NeuralNetConfiguration.Builder()
//            		    .iterations(1000)
//            		    .activation(Activation.SIGMOID)
//
//            		    .weightInit(WeightInit.XAVIER)
//            		    .learningRate(0.1)
//            		    .regularization(true).dropOut(0.6)
//            		    
//            		    .list()
//            		    
//            		    .layer(0, new DenseLayer.Builder().nOut(10).build())
//            		//    .layer(1, new DenseLayer.Builder().nOut(10).build())
//            		    .layer(1, new OutputLayer.Builder(
//            		      LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
//            		        .activation(Activation.SOFTMAX)
//            		        .nOut(10).build())
//            		    .backprop(true).pretrain(false)
//            		    .setInputType(InputType.feedForward(784))
//            		    .build();
//		   //EARLY STOPPING TO PREVENT OVERFITTING
//            		var esConf = new EarlyStoppingConfiguration.Builder()
//            		        .epochTerminationConditions(new MaxEpochsTerminationCondition(30))
//            		        .iterationTerminationConditions(new MaxTimeIterationTerminationCondition(20, TimeUnit.MINUTES))
//            		        .scoreCalculator(new DataSetLossCalculator())
//            		        .evaluateEveryNEpochs(1)
//            		        .modelSaver(new LocalFileModelSaver("C:\\Users\\Nikki singh\\Downloads\\Models-DeepLearning"))
//            		        .build();
//
//            		EarlyStoppingTrainer trainer = new EarlyStoppingTrainer(esConf,config,iterator);
//
//            		//Conduct early stopping training:
//            		EarlyStoppingResult result = trainer.fit();
//
//            		//Print out the results:
//            		System.out.println("Termination reason: " + result.getTerminationReason());
//            		System.out.println("Termination details: " + result.getTerminationDetails());
//            		System.out.println("Total epochs: " + result.getTotalEpochs());
//            		System.out.println("Best epoch number: " + result.getBestModelEpoch());
//            		System.out.println("Score at best epoch: " + result.getBestModelScore());
//
//            		//Get the best model:
//            		MultiLayerNetwork model = (MultiLayerNetwork) result.getBestModel();
//            		
//            	//	MultiLayerNetwork model = new MultiLayerNetwork(config);
//            		model.init();
//            		model.fit(trainingData);
//            		INDArray output = model.output(testData.getFeatureMatrix());
//            		Evaluation eval = new Evaluation(10);
//            		eval.eval(testData.getLabels(), output);
//            		System.out.println(eval.confusionToString());
//            		System.out.println(eval);
//            		
	}

}
