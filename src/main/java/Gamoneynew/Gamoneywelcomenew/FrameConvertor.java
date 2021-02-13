package Gamoneynew.Gamoneywelcomenew;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.opencv.global.opencv_highgui;
import org.bytedeco.opencv.opencv_core.Mat;

public class FrameConvertor {

	public static void main(String[] args) throws Exception, org.bytedeco.javacv.FrameRecorder.Exception {
		// TODO Auto-generated method stub
		FrameGrabber grabber = FrameGrabber.createDefault(0); //a kind of video Capture
		 grabber.setFormat("avi");
		 grabber.start();
		
		   
		 OpenCVFrameConverter.ToMat converterToMat = new OpenCVFrameConverter.ToMat();
		   // Grab an image Frame from the video file
		   Frame frame = grabber.grab();
		   // Perform a shallow copy to represent frame as a Mat
		   Mat mat = converterToMat.convert(frame);
		   FrameRecorder recorder = FrameRecorder.createDefault("C:\\Users\\Nikki singh\\Downloads\\output.avi", mat.arrayWidth(), mat.arrayHeight());
	        recorder.start();
	        CanvasFrame fame = new CanvasFrame("Some Title", CanvasFrame.getDefaultGamma()/grabber.getGamma());
	       

	}

}
