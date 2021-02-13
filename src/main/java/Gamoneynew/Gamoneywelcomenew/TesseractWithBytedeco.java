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

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.leptonica.PIX;
import org.bytedeco.tesseract.TessBaseAPI;

import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;

import static org.bytedeco.leptonica.global.lept.*;
import static org.bytedeco.tesseract.global.tesseract.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.IMREAD_GRAYSCALE;
public class TesseractWithBytedeco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mat img=imread("C:\\\\Users\\\\Nikki singh\\\\Downloads\\\\AIActual_image.png",IMREAD_GRAYSCALE);
		//EXPERIMENT WITH DIFFRENT INTERPROTATION TO GET GOOD IMAGE RESIZE FOR DIFFRENT USE CASE
		opencv_imgproc.resize(img, img, new Size(300,300), 1.5, 1.5, Imgproc.INTER_CUBIC);
while(true) {
		  opencv_highgui.imshow("", img);
		  opencv_highgui.waitKey(20);
}
//		 BytePointer outText;
//
//	        TessBaseAPI api = new TessBaseAPI();
//	        api.SetPageSegMode(5);  //EXPREIMENT WITH DIFFRENT ONE AND DONT FORGET TO KEEP TRACK OF IT IT CAN INCREASE ACCURACY
//	        // Initialize tesseract-ocr with English, without specifying tessdata path
//	        if (api.Init("C:\\Users\\Nikki singh\\Downloads\\tessdata", "eng") != 0) {
//	            System.err.println("Could not initialize tesseract.");
//	            System.exit(1);
//	        }
//
//	        // Open input image with leptonica library
//	        PIX image = pixRead("C:\\Users\\Nikki singh\\Downloads\\AsunZenfoneScreenshot.png");
//	        System.out.println(image);
//	        api.SetImage(image);
//	        outText = api.GetUTF8Text();
//	        System.out.println("OCR output:\n" + outText.getString());
//
//	        // Destroy used object and release memory
//	        api.End();
//	        outText.deallocate();
//	        pixDestroy(image);
	}

}
