package Gamoneynew.Gamoneywelcomenew;


import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfDouble;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.core.TermCriteria;
import org.opencv.features2d.BFMatcher;
import org.opencv.features2d.Feature2D;
import org.opencv.features2d.Features2d;
import org.opencv.features2d.ORB;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.ml.Ml;
import org.opencv.ml.SVM;
import org.opencv.ml.TrainData;
import org.opencv.objdetect.HOGDescriptor;
import org.opencv.videoio.VideoCapture;

public class HogFeature {
    public static void ORB(Mat y1,Mat y2,Mat mask,MatOfKeyPoint mk,Mat disc) {
      
      //Imgproc.resize(y, y, new Size(128,64));
       //VideoCapture vc=new VideoCapture(0);
    	Mat trainingLabels = new Mat();
    	HOGDescriptor hog = new HOGDescriptor(new Size(68,68),new Size(8,8),new Size(4,4),new Size(4,4),9);
    	  
    	  MatOfFloat temp = new MatOfFloat();
    	  File negativeDir = new File("C:\\Users\\Nikki singh\\Downloads\\neg");
    	  File positiveDir = new File("C:\\\\Users\\\\Nikki singh\\\\Downloads\\\\HogNick");
    	  int i = -1;
    	  float[][] hogdescriptor = new float[negativeDir.listFiles().length][]; //13992 - image count
          int j=0;
    	  Mat mat  = new Mat(negativeDir.listFiles().length+positiveDir.listFiles().length,1,CvType.CV_32FC1);
    	  for(File file:negativeDir.listFiles()){
    	              Mat con = Imgcodecs.imread(file.getAbsolutePath(),Imgcodecs.IMREAD_GRAYSCALE);
    	              Imgproc.resize(con,con,new Size(68,68));
    	              hog.compute(con, temp);
    	              trainingLabels.push_back(Mat.zeros(new Size(1,1),CvType.CV_32S));
    	              mat.put(j,0,temp.toArray());
    	              j++;
    	  }  
    	  for(File file:positiveDir.listFiles()){
    	        Mat con = Imgcodecs.imread(file.getAbsolutePath(),Imgcodecs.IMREAD_GRAYSCALE);
    	        Imgproc.resize(con,con,new Size(68,68));
    	        hog.compute(con, temp);
    	        hogdescriptor[++i] = temp.toArray();
    	        trainingLabels.push_back(Mat.ones(new Size(1,1),CvType.CV_32S));
    	        mat.put(j,0,temp.toArray());
	              j++;
    	    }
    	  


    	    Mat Labels = new Mat();
    	    trainingLabels.copyTo(Labels);
    	    Labels.convertTo(Labels,CvType.CV_32S);
              
    	    
    	   
    	    	//TrainData trainDataHog = TrainData.create(mat,Ml.ROW_SAMPLE,Labels);
                
    	    	SVM svm = SVM.create();
    	    	svm.setType(SVM.EPS_SVR);
    	    	svm.setKernel(SVM.LINEAR);
    	    	svm.setDegree(0.1);
    	    // 1.4 bug fix: old 1.4 ver gamma is 1
    	    	svm.setGamma(0.1);
    	    	svm.setCoef0(0.1);
    	    	svm.setC(1);
    	    	svm.setNu(0.1);
    	    	svm.setP(0.1);
    	    	svm.setTermCriteria(new TermCriteria(1, 20000, 0.0001));
    	    	svm.train(mat,Ml.ROW_SAMPLE,Labels); 
    	    	
    	    	//FEEDING SVM TO HOG
    	    	//HOGDescriptor hog = new HOGDescriptor(new Size(28,28),new Size(8,8),new Size(4,4),new Size(4,4),9);
    	    	 Double rho = svm.getDecisionFunction(0,new Mat(),new Mat());
    	    	 int size = (int)(svm.getSupportVectors().total() + 1) * svm.getSupportVectors().channels();
    	    	 float[] temp1 = new float[size];
    	    	 svm.getSupportVectors().get(0, 0, temp1);
    	    	 temp1[temp1.length - 1] = (float)-rho;
    	    	 MatOfFloat vector = new MatOfFloat(temp1);
    	    	 hog.setSVMDetector(vector);
    	    }
    public static void captureObj(String name) {
    	
        VideoCapture capture = new VideoCapture(0);
   		  Mat image = new Mat();
   		  int index = 0;
   		  Imgcodecs imc=new Imgcodecs();
   		  String objname=name;
   		  Integer label=3;
   		  int num=1;
   		  Boolean it=true;
   	//	System.out.println(capture.isOpened());
   		  if (capture.isOpened()) {
   		    while(it) {
   		    	
   				capture.read(image); //THIS FUNCTION WILL OPEN CAMERA AND CAPTURE LIVE IMAGE ADN CREATE MAT FROM THE PIXELS
   		        if(num==100) {
   				  it=false;
   				
   		        }
   		        else {
   		        	Imgcodecs.imwrite("C:\\\\Users\\\\Nikki singh\\\\Downloads\\\\HogNick\\"+objname+"_"+label+"#"+num+".png", image);
     		          
   		        	num++;
   		        }
   		        HighGui.imshow("IMAGEEEEEs",image);
				index = HighGui.waitKey(1);
   		    }
   		  }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		 String fname2="backtou";
		 Mat labels = new Mat(8, 1, CvType.CV_32SC1);
			labels.put(0, 0, 1);
			labels.put(1, 0, 1);
			labels.put(2, 0, 1);
			labels.put(3, 0, 1);
			labels.put(4, 0, 2);
			labels.put(5, 0, 2);
			labels.put(6, 0, 2);
			labels.put(7, 0, 2);
	
		 Mat z=Mat.zeros(new Size(1,10), CvType.CV_8U);
		 
		 System.out.println(z.reshape(1,1).dump());
		 String fname1="nikki_1#48.png";
		 MatOfKeyPoint mk=new MatOfKeyPoint();
		 Mat disc=new Mat();
		 Mat mask=new Mat();
		 Mat m1=Imgcodecs.imread("C:\\Users\\Nikki singh\\Downloads\\HogNick\\"+fname1,Imgcodecs.IMREAD_GRAYSCALE);
		 Mat m2=Imgcodecs.imread("C:\\Users\\Nikki singh\\Downloads\\jump.jpg");
		 
		Imgproc.cvtColor(m2, m2, Imgproc.COLOR_RGB2BGR);
		m2.convertTo(m2, CvType.CV_32F);
		Mat mnew=m2.reshape(1,1);
	//	 captureObj("negative");
	//ORB(m1,m2,mask,mk,disc);
		 
		 //		// m.convertTo(m, CvType.CV_32F);
//		 double c=2.0;
//		 for(double t=0.0;t<10.0;t++) {
//			 System.out.println(t);
//			 Mat gabor=Imgproc.getGaborKernel(new Size(4,4), t, t, t, t,0,CvType.CV_32F);
//			 Imgproc.filter2D(m, m, -1,gabor);
//			 HighGui.imshow("gabor", m);
//			 HighGui.waitKey(1);
//			 c++;
//		 }
		Mat label=new Mat();
		Mat center=new Mat();
		 Core.kmeans(mnew, 5,label ,new TermCriteria(TermCriteria.EPS+TermCriteria.MAX_ITER,100, 1),1, Core.KMEANS_PP_CENTERS,center);
		 center.convertTo(center,CvType.CV_8UC1, 255.0);
		 center.reshape(3);
		  System.out.println(labels.dump());
		  
		 HighGui.imshow("gabor", center);
		 HighGui.waitKey(1);
		 
	}

}
