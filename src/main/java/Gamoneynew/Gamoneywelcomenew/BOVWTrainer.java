package Gamoneynew.Gamoneywelcomenew;

import static org.bytedeco.opencv.global.opencv_imgcodecs.IMREAD_GRAYSCALE;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.leptonica.PIX;
import org.bytedeco.opencv.global.opencv_core;
import org.bytedeco.opencv.global.opencv_features2d;
import org.bytedeco.opencv.global.opencv_highgui;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.global.opencv_ml;
import org.bytedeco.opencv.opencv_core.CvSize;
import org.bytedeco.opencv.opencv_core.CvTermCriteria;
import org.bytedeco.opencv.opencv_core.KeyPointVector;
//import org.bytedeco.opencv.opencv_core.Mat;
//import org.bytedeco.opencv.opencv_features2d.BOWImgDescriptorExtractor;
//import org.bytedeco.opencv.opencv_features2d.BOWKMeansTrainer;
//import org.bytedeco.opencv.opencv_features2d.DescriptorMatcher;
//import org.bytedeco.opencv.opencv_features2d.Feature2D;
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfFloat;
//import org.opencv.core.MatOfKeyPoint;
//import org.opencv.core.TermCriteria;
//import org.opencv.features2d.BOWImgDescriptorExtractor;
//import org.opencv.features2d.BOWKMeansTrainer;
//import org.opencv.features2d.DescriptorMatcher;
//import org.opencv.features2d.FastFeatureDetector;
//import org.opencv.features2d.FlannBasedMatcher;
//import org.opencv.features2d.ORB;
//import org.opencv.features2d.SIFT;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.xfeatures2d.BriefDescriptorExtractor;
//import org.opencv.xfeatures2d.SURF;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_core.TermCriteria;
import org.bytedeco.opencv.opencv_features2d.BOWImgDescriptorExtractor;
import org.bytedeco.opencv.opencv_features2d.BOWKMeansTrainer;
import org.bytedeco.opencv.opencv_features2d.DescriptorMatcher;
import org.bytedeco.opencv.opencv_features2d.FastFeatureDetector;
import org.bytedeco.opencv.opencv_features2d.Feature2D;
import org.bytedeco.opencv.opencv_features2d.SIFT;
import org.bytedeco.opencv.opencv_ml.SVM;
import org.bytedeco.opencv.opencv_ml.TrainData;
import org.bytedeco.opencv.opencv_xfeatures2d.SURF;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.ml.Ml;
import org.bytedeco.javacpp.*;
//import static org.bytedeco.javacpp.lept.*;
//import static org.bytedeco.javacpp.tesseract.*;



public class BOVWTrainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

         //  System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
          var files= new File("C:\\Users\\Nikki singh\\Downloads\\2 img");
          
          FilenameFilter imgFilter = new FilenameFilter() {
              public boolean accept(File dir, String name) {
                  name = name.toLowerCase();
                  return name.endsWith(".jpg") || name.endsWith(".pgm") || name.endsWith(".png");
              }
          };
          List<Mat> ims=new ArrayList<Mat>();
       //   List<MatOfKeyPoint> mkl=new ArrayList<MatOfKeyPoint>();
          List<Mat> mld=new ArrayList<Mat>();
          File[] imageFiles = files.listFiles(imgFilter);
          
          TermCriteria criteria = new  TermCriteria(TermCriteria.EPS + TermCriteria.MAX_ITER,100,0.001);
          Mat y=imread("C:\\Users\\Nikki singh\\Downloads\\2 img\\1.jpg");
          int dictionarySize = 60;
          BOWKMeansTrainer bow = new BOWKMeansTrainer(dictionarySize, criteria, 1, Core.KMEANS_PP_CENTERS);
          SIFT sift=SIFT.create();
          FastFeatureDetector fd=FastFeatureDetector.create();
          
          KeyPointVector keypoint=new KeyPointVector();
         // sift.detect(y,keypoint);
          opencv_features2d.drawKeypoints(y, keypoint, y);
          Mat mask=new Mat();
          System.out.println(imageFiles.length);
          Mat dis=new Mat();
          for (int i=0;i<12;i++) {
        	  Mat im=imread(imageFiles[i].getAbsolutePath(),IMREAD_GRAYSCALE);
        	  ims.add(im);
        	 
        	  KeyPointVector mk=new KeyPointVector();
        	  
              fd.detect(im , mk);
              sift.detectAndCompute(im,mask, mk, dis);
              dis.convertTo(dis, opencv_core.CV_32FC1);
              
              bow.add(dis);
          }
//          
          System.out.println(bow.descriptorsCount());
          DescriptorMatcher matcher = DescriptorMatcher.create(DescriptorMatcher.FLANNBASED);

          BOWImgDescriptorExtractor de = new BOWImgDescriptorExtractor(sift,matcher);
          
          
          var dictionary_vocabs=bow.cluster();
         // opencv_imgproc.his
          System.out.println(dictionary_vocabs.toString());
          de.setVocabulary(dictionary_vocabs); // i m right TILL here
         System.out.println(de.getVocabulary().toString());
           
        //   ext.det //EXTRACT KEYPOINTS AND DESCRIPTOR

          Mat labels = new Mat(14, 1, opencv_core.CV_32FC1);
       	Mat trainingData =new Mat();
        Mat bowDescriptor1 = new Mat();
        Mat bowDesc1 = new Mat();
        KeyPointVector keypoint1 = new KeyPointVector();
        int j=0;
//		for(int i=12;i<=25;i++){
//            
//            Mat img2 = imread(imageFiles[i].getAbsolutePath(),IMREAD_GRAYSCALE);
//            fd.detect(img2, keypoint1);
//            sift.compute(img2, keypoint1, bowDescriptor1);
//            bowDescriptor1.convertTo(bowDesc1, opencv_core.CV_32FC1);
//            
//            trainingData.push_back_(bowDesc1.reshape(1, 1));
//            trainingData.convertTo(trainingData, opencv_core.CV_32FC1);
//            System.out.println(bowDesc1.toString());
//            labels.push_back_(Mat.zeros(new Size(1,1),CvType.CV_32FC1));   
//            j++;
//        }
		Mat tra=new Mat(trainingData.arrayHeight(),1);
		
		TrainData tr=TrainData.create(trainingData,Ml.ROW_SAMPLE , labels);
		TermCriteria criter = new  TermCriteria(TermCriteria.EPS + TermCriteria.MAX_ITER,100,0.001);
//	        CvSVMParams params = new CvSVMParams();
//	        params.kernel_type();
//	        params.svm_type(CvSVM.C_SVC);
//	        params.gamma(0.50625);
//	        params.C(312.50000000000000);
//	        params.term_crit(criteria);
		System.out.println(trainingData.toString());
	        Mat res=new Mat();
	       SVM svm=SVM.create();
	       svm.setKernel(SVM.LINEAR);
	       svm.setType(svm.C_SVC);
	       svm.setC(312.50000000000000);
	       svm.setTermCriteria(criter);
	       svm.setGamma(0.50625);
	        svm.train(de.getVocabulary(),Ml.ROW_SAMPLE,labels);
	        String svmpath ="C:\\\\Users\\\\Nikki singh\\\\Downloads\\\\dictionary1.yml";
	        svm.save(svmpath);

           //    bowTrainer. //BOWKMEANS TRAINER ITERATE OVER EACH IMAGE DESCRIPTOR

//NOTE:THIS IS BYTEDECO IMPLEMENTATION OF BOW PARAMS ARE NOT WORING WITH OPENCV IMPLEMENTATION
      //    Mat dis=new Mat();
          
          de.compute(y,keypoint,dis);
          
          
          opencv_imgproc.resize(y,y,new Size(300,300));
          opencv_highgui.imshow("", y);
          opencv_highgui.waitKey(1);
          
	}

}
