package Gamoneynew.Gamoneywelcomenew;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.datavec.api.io.converters.DoubleWritableConverter;
import org.datavec.api.io.converters.FloatWritableConverter;
import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.api.util.ClassPathResource;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.earlystopping.EarlyStoppingConfiguration;
import org.deeplearning4j.earlystopping.EarlyStoppingResult;
import org.deeplearning4j.earlystopping.saver.LocalFileModelSaver;
import org.deeplearning4j.earlystopping.scorecalc.DataSetLossCalculator;
import org.deeplearning4j.earlystopping.termination.MaxEpochsTerminationCondition;
import org.deeplearning4j.earlystopping.termination.MaxTimeIterationTerminationCondition;
import org.deeplearning4j.earlystopping.trainer.EarlyStoppingTrainer;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.conf.ComputationGraphConfiguration;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.graph.MergeVertex;
import org.deeplearning4j.nn.conf.inputs.InputType;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.NormalizerStandardize;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Sgd;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class Deep4JExamples {
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
		
			
			RecordReader recordReader = new CSVRecordReader(1) ; //skip first row
		
		    recordReader.initialize(new FileSplit(new File("C:\\Users\\Nikki singh\\Downloads\\MINST_CSV\\mnist_train.csv")));
		    
		    RecordReaderDataSetIterator iterator = new RecordReaderDataSetIterator(
            		  recordReader,12000,0,10);
           
           // System.out.println("Labels:"+iterator.getLabels());
            		DataSet allData = iterator.next();
            //		allData.shuffle(42);
            		//System.out.println("Whatt--"+allData.getLabels());
		    // …
            	//DATANORMALIZATION BEFORE NEUREL NETWORK
            		DataNormalization normalizer = new NormalizerStandardize();
            		normalizer.fit(allData);
            		normalizer.transform(allData);
            		SplitTestAndTrain testAndTrain = allData.splitTestAndTrain(0.7);
            		DataSet trainingData = testAndTrain.getTrain();
            		System.out.println(trainingData.labelCounts());
            		DataSet testData = testAndTrain.getTest();
            	//NEUREL NET CONFIGS
            		MultiLayerConfiguration config
            		  = new NeuralNetConfiguration.Builder()
            		    .iterations(1000)
            		    .activation(Activation.SIGMOID)

            		    .weightInit(WeightInit.XAVIER)
            		    .learningRate(0.1)
            		    .regularization(true).dropOut(0.6)
            		    
            		    .list()
            		    
            		    .layer(0, new DenseLayer.Builder().nOut(10).build())
            		//    .layer(1, new DenseLayer.Builder().nOut(10).build())
            		    .layer(1, new OutputLayer.Builder(
            		      LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
            		        .activation(Activation.SOFTMAX)
            		        .nOut(10).build())
            		    .backprop(true).pretrain(false)
            		    .setInputType(InputType.feedForward(784))
            		    .build();
		   //EARLY STOPPING TO PREVENT OVERFITTING
            		var esConf = new EarlyStoppingConfiguration.Builder()
            		        .epochTerminationConditions(new MaxEpochsTerminationCondition(30))
            		        .iterationTerminationConditions(new MaxTimeIterationTerminationCondition(20, TimeUnit.MINUTES))
            		        .scoreCalculator(new DataSetLossCalculator())
            		        .evaluateEveryNEpochs(1)
            		        .modelSaver(new LocalFileModelSaver("C:\\Users\\Nikki singh\\Downloads\\Models-DeepLearning"))
            		        .build();

            		EarlyStoppingTrainer trainer = new EarlyStoppingTrainer(esConf,config,iterator);

            		//Conduct early stopping training:
            		EarlyStoppingResult result = trainer.fit();

            		//Print out the results:
            		System.out.println("Termination reason: " + result.getTerminationReason());
            		System.out.println("Termination details: " + result.getTerminationDetails());
            		System.out.println("Total epochs: " + result.getTotalEpochs());
            		System.out.println("Best epoch number: " + result.getBestModelEpoch());
            		System.out.println("Score at best epoch: " + result.getBestModelScore());

            		//Get the best model:
            		MultiLayerNetwork model = (MultiLayerNetwork) result.getBestModel();
            		
            	//	MultiLayerNetwork model = new MultiLayerNetwork(config);
            		model.init();
            		model.fit(trainingData);
            		INDArray output = model.output(testData.getFeatureMatrix());
            		Evaluation eval = new Evaluation(10);
            		eval.eval(testData.getLabels(), output);
            		System.out.println(eval.confusionToString());
            		System.out.println(eval);
            		
	}

}
