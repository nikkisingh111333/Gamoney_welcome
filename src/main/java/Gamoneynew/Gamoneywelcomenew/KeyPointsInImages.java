//package Gamoney;
//
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfDMatch;
//import org.opencv.core.MatOfKeyPoint;
//import org.opencv.features2d.FastFeatureDetector;
//import org.opencv.features2d.Features2d;
//import org.opencv.highgui.HighGui;
//import org.opencv.imgcodecs.Imgcodecs;
//
//public class KeyPointsInImages {
//
//	 public static void main(String args[]) throws Exception {
//	      //Loading the OpenCV core library
//	      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
//	      //Reading the source images
//	      String file1 ="C:\\Users\\Nikki singh\\Downloads\\car5.jpg";
//	      Mat src1 = Imgcodecs.imread(file1);
//	      String file2 ="C:\\\\Users\\\\Nikki singh\\\\Downloads\\\\car5.jpg";
//	      Mat src2 = Imgcodecs.imread(file2);
//	      //Creating an empty matrix to store the destination image
//	      Mat dst = new Mat();
//	      FastFeatureDetector detector = FastFeatureDetector.create();
//	      //Detecting the key points in both images
//	      MatOfKeyPoint keyPoints1 = new MatOfKeyPoint();
//	      detector.detect(src1, keyPoints1);
//	      System.out.println(keyPoints1.dump());
//	      MatOfKeyPoint keyPoints2 = new MatOfKeyPoint();
//	      detector.detect(src2, keyPoints2);
//	      MatOfDMatch matof1to2 = new MatOfDMatch();
//	      Features2d.drawMatches(src1, keyPoints1, src2, keyPoints2, matof1to2, dst);
//	      HighGui.imshow("Feature Matching", dst);
//	      HighGui.waitKey();
//	   }
//
//}
