package Gamoneynew.Gamoneywelcomenew;



import java.awt.Color;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.DMatch;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.features2d.AKAZE;
import org.opencv.features2d.BFMatcher;
import org.opencv.features2d.Feature2D;
import org.opencv.features2d.Features2d;
import org.opencv.features2d.KAZE;
import org.opencv.features2d.ORB;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.video.BackgroundSubtractorMOG2;
import org.opencv.video.Video;
import org.opencv.videoio.VideoCapture;

import com.lowagie.text.pdf.CMYKColor;

public class BGHidder {
    public static void Cutter() {
    	VideoCapture capture = new VideoCapture(0);
		  Mat image1 = new Mat();
		 Mat image2 = new Mat();
		  int index = 0;
		  
		  Imgcodecs imc=new Imgcodecs();
		  //REMOVING BACKGROUND FROM IMAGE
		 BackgroundSubtractorMOG2 mog= Video.createBackgroundSubtractorMOG2(20, 50,false);
		  Integer label=2;
		  int num=1;
		  Boolean it=true;
		 Mat subtractResult = new Mat(image2.rows(), image2.cols(), CvType.CV_8UC1);
	//	System.out.println(capture.isOpened());
		  if (capture.isOpened()) {
			  capture.read(image1);
			  Imgproc.cvtColor(image1, image1, Imgproc.COLOR_BGR2GRAY);
			  Imgproc.GaussianBlur(image1, image1, new Size(5,5), 0.5);
			AKAZE k;
		      while(it) {
		    	
		    	capture.read(image2);
		    	Rect rect=new Rect(200,200,500,500);
//		    
//		    	mask.setTo(new Scalar(230,111,120));
		    	//mog.apply(image2, subtractResult);
		    	Imgproc.medianBlur(image2, image2, 5);
		    
           
				Mat im=Imgcodecs.imread("C:\\Users\\Nikki singh\\Downloads\\Book1.jpg",Imgcodecs.IMREAD_COLOR);
				
				Rect rectangle = new Rect(90, 50, 500, 500);
			    Mat result = new Mat();
			    Mat bgdModel = new Mat();
			    Mat fgdModel = new Mat();
			    List<Mat> mv=new ArrayList<Mat>();
			    Core.split(im, mv);
			    System.out.println(mv.size());
			    Imgproc.grabCut(im, result, rectangle, bgdModel, fgdModel, 18, Imgproc.GC_INIT_WITH_RECT);
			    Mat foreground = new Mat();
			  //WE CAN  USE SCALAR VALUE EITHER 1,2 & 3 ONLY IN SOURCE MAT .1 FOR BLACK , 2 FOR CUTTED OBJECT AND FINALLY 3 FOR MASK
			    Mat source = new Mat(1, 1, CvType.CV_8U, new Scalar(3)); 
			    System.out.println(source);
			    Core.compare(result, source, result,Core.CMP_EQ);
			    im.copyTo(foreground,result);
			    
		    //	Imgproc.cvtColor(image2, image2, Imgproc.COLOR_BGR2GRAY);
		    //	Imgproc.GaussianBlur(image2, image2, new Size(5,5), 0.5);
		    //	Core.absdiff(image1, image2, subtractResult);
		    //	Imgproc.threshold(subtractResult, subtractResult, 25, 255,Imgproc.THRESH_OTSU);
		    	

			    fgdModel.convertTo(fgdModel, CvType.CV_8U);
		    	 // HighGui.imshow("IMAGEEEEEs",subtractResult);
		    //	System.out.println(fg);
		    	//fg.convertTo(fg, CvType.CV_8UC1);
			   
		    	 HighGui.imshow("IMAGEEEEEs",fgdModel);
					index = HighGui.waitKey(1);
			    
		   // }

		      }}}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		//Cutter();
		//LBPHFaceRecognizer lbph;
		Mat im=Imgcodecs.imread("C:\\Users\\Nikki singh\\Downloads\\AIActual_image.png",Imgcodecs.IMREAD_GRAYSCALE);
	//	distanceTransform(im);
		List<Mat> lm=new ArrayList<Mat>();
		//Core.split(im, lm);
		Mat y=new Mat();
		//Core.merge(lm, im); //opposite of split() convert splitted imagw into original
		
//		Imgproc.cornerHarris(im, y, 2, 3,0.04 );
//		
//		y.convertTo(y,CvType.CV_8UC1);
//		System.out.println(y.dump());
//		HighGui.imshow("",im);
//		
//		HighGui.waitKey(1);
//		imageCollector();
		//imageModifier("C:\\\\Users\\\\Nikki singh\\\\Downloads\\\\Negative Images");
	//
        
		
		//		//Mat im2=Imgcodecs.imread("C:\\Users\\Nikki singh\\Downloads\\Book3.jpg");
//		Mat im2=new Mat();
//		VideoCapture capture = new VideoCapture(0);
//		AKAZE k=AKAZE.create();
//	    if(capture.isOpened()==true) {
//	    	while(true) {
//	    		capture.read(im2);
//	    		Imgproc.cvtColor(im2, im2, Imgproc.COLOR_RGB2GRAY);
//	    		
//		MatOfKeyPoint mk1=new MatOfKeyPoint();
	//	MatOfKeyPoint mk2=new MatOfKeyPoint();
//		Mat d1=new Mat();
//		Mat d2=new Mat();
//		Mat mask1=new Mat();
//		Mat mask2=new Mat();
//		k.detectAndCompute(im,mask1, mk1, d1);
//		k.detectAndCompute(im2,mask2, mk2, d2);
//		var bf=BFMatcher.create(BFMatcher.BRUTEFORCE_SL2);
//		 Mat q1=new Mat();
//		 Mat q2=new Mat();
//			List<MatOfDMatch> matof1to2 = new ArrayList<MatOfDMatch>();
//		   
//		 bf.knnMatch(d1,d2,matof1to2,20);
//	     System.out.println("Length of org match:"+matof1to2.toArray().length);
//		Mat dst=new Mat();
//		 
//		 Set<Float> best=new HashSet<Float>();
//		 List<MatOfDMatch> best_dmatch=new ArrayList<MatOfDMatch>();
//		 for(MatOfDMatch drr:matof1to2) {
//			 System.out.println("WTF:"+drr.toArray().length);
//			 for(DMatch frr:drr.toArray()) {
//			//	 System.out.println("Before--Distance:"+frr.distance);
//				 if(frr.distance<75.0) {
//					 System.out.println("Distance:"+frr.distance);
//					 best_dmatch.add(drr);
//				
//					 
//				 };
//			 }
//		 }
//		 try {
//			 System.out.println("Length after filtering:"+best_dmatch);
//		 Features2d.drawMatchesKnn(im, mk1, im2, mk2, best_dmatch,dst);
//		 }
//		 catch(Exception e) {
//			 System.out.println(e.getMessage());
//		 }
//		 System.out.println(best);
//		Imgproc.resize(dst,dst,new Size(1500,1200));
//		
//		Imgproc.cvtColor(im, im, Imgproc.COLOR_RGB2GRAY);
//		Mat blur=new Mat();
//		Imgproc.blur(im, blur, new Size(3,3));
//		Core.addWeighted(im, 0.5,blur , 0.2, 0.3, im);
//	   // im.convertTo(im, CvType.CV_8UC1);
//		Mat n=new Mat();
//		Imgproc.bilateralFilter(im, n, 5, 52, 5);
//		
//		
//    
//		HighGui.imshow("IMAGEEEEEs",im);
//		HighGui.waitKey(1);
//		Mat thres=new Mat();
		
		//Imgproc.threshold(n, thres, 85, 255, Imgproc.THRESH_BINARY_INV);
	//	Imgproc.threshold(thres, thres, 50, 255, Imgproc.THRESH_BINARY);
	
//		Imgproc.Canny(n, thres, 5, 90);

	//	
//		List<MatOfPoint> mp=new ArrayList<MatOfPoint>();
//		List<MatOfPoint> hulllist=new ArrayList<MatOfPoint>();
//		Mat h=new Mat();
	    
	//	Imgproc.findContours(thres, mp, h,Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
	    
//		for(int i=0;i<mp.size();i++) {
//			MatOfInt mi=new MatOfInt();
//			Imgproc.convexHull(mp.get(i),mi );
//			hulllist.add(matOfIntToPoints(mp.get(i), mi));
//		}
//		
//	    
//	    Imgproc.drawContours(n, mp,-1, new Scalar(10,150,11),3);
//	    Imgproc.drawContours(n, hulllist, -1, new Scalar(200,10,20),6);
//	     Imgproc.drawContours(thres, hulllist, -1, new Scalar(200,10,20),4);
//	   Imgproc.cvtColor(im,im,Imgproc.COLOR_GRAY2RGBA);
//	    
//
//	    Imgproc.erode(n, n, Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3,3)));
//		HighGui.imshow("IMAGEEEEEs",n);
//		HighGui.waitKey(2);
//	    	} 
//	   }  
	     		  
	}
	public static MatOfPoint matOfIntToPoints(MatOfPoint contour, MatOfInt indexes) {
	    int[] arrIndex = indexes.toArray();
	    Point[] arrContour = contour.toArray();
	    Point[] arrPoints = new Point[arrIndex.length];

	    for (int i=0;i<arrIndex.length;i++) {
	        arrPoints[i] = arrContour[arrIndex[i]];
	    }

	    MatOfPoint hull = new MatOfPoint(); 
	    hull.fromArray(arrPoints);
	    return hull; 
	}
	public static void imageCollector() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	
		Mat im2=new Mat();
		VideoCapture capture = new VideoCapture(0);
		 if(capture.isOpened()==true) {
			
			 int y=70;
		    	for(int x=1;x<220;x++) {
		    		capture.read(im2);
		    		HighGui.imshow("", im2);
		    		Imgproc.resize(im2,im2,new Size(50,50));
		    		Imgproc.cvtColor(im2, im2, Imgproc.COLOR_RGB2GRAY);
		    		Imgcodecs.imwrite("C:\\Users\\Nikki singh\\Downloads\\Gesture_box\\p\\Gesture_"+y+"#"+x+".jpg", im2);
		    	    
		    	    HighGui.waitKey(1);
		    	}
		 }
	}
	public static void imageModifier(String path) {
        File root = new File(path);
        int y=9;
        int x=1;
        FilenameFilter imgFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                name = name.toLowerCase();
                return name.endsWith(".jpg") || name.endsWith(".pgm") || name.endsWith(".png");
            }
        };
        
        File[] imageFiles = root.listFiles(imgFilter);
        for(File f:imageFiles) {
        	Mat im=Imgcodecs.imread(f.getAbsolutePath(),Imgcodecs.IMREAD_GRAYSCALE);
        	Imgproc.resize(im,im,new Size(50,50));
        	Imgcodecs.imwrite("C:\\Users\\Nikki singh\\Downloads\\New Negative\\Negative_"+y+"#"+x+".png", im);
	    	   y++;
	    	   x++;
        }
	}
	public static void distanceTransform(Mat m) {
		Imgproc.cvtColor(m, m, Imgproc.COLOR_RGB2GRAY);
		Imgproc.threshold(m, m, 50, 255, Imgproc.THRESH_BINARY);
		Imgproc.distanceTransform(m, m, Imgproc.DIST_L1, 3);
		m.convertTo(m, CvType.CV_8UC1);
		
		HighGui.imshow("", m);
		HighGui.waitKey(2);
	}


}
