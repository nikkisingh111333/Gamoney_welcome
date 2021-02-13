package Gamoneynew.Gamoneywelcomenew;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
//
//import org.bytedeco.opencv.global.opencv_dnn;
//import org.bytedeco.opencv.opencv_core.Mat;
//import org.bytedeco.opencv.opencv_core.Size;
//import org.bytedeco.opencv.opencv_dnn.Net;
//import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfRect;
import org.opencv.core.MatOfRect2d;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Rect2d;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.dnn.Dnn;
import org.opencv.dnn.Net;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.utils.Converters;
import org.opencv.videoio.VideoCapture;

public class YOLOExample {

	private static List<String> getOutputNames(Net net) {
		List<String> names = new ArrayList<>();

        List<Integer> outLayers =  net.getUnconnectedOutLayers().toList(); //RETURN LAYERS WITH UNCONNECTED OUTPUT LAYER WE WILL DEFINE OUR OUTPUT
        List<String> layersNames = (List<String>) net.getLayerNames();
      
        outLayers.forEach(new Consumer<Integer>() {

		
			

			@Override
			public void accept(java.lang.Integer item) {
				// TODO Auto-generated method stub
				System.out.println("Kudi:"+item);
				names.add(layersNames.get(item - 1)); //get output layers YoLo use 3 Output Layers for prediction
			}
        	
        }); 
       
        ; //RETURNING ALL LAYERS EXCLUDING OUTPUT LAYER ITEM-1
        System.out.println(names);
        return names;
	}
	//USING PRE-TRAINED YoLo MODEL FOR OBJECT DETECTION
	public static void main(String[] args) throws InterruptedException {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // Load the openCV 4.0 dll //
		 String modelWeights = "C:\\Users\\Nikki singh\\Downloads\\yolov3.weights"; //Download and load only wights for YOLO , this is obtained from official YOLO site//
	        String modelConfiguration = "C:\\Users\\Nikki singh\\Downloads\\yolov3.cfg";//Download and load cfg file for YOLO , can be obtained from official site//
	       // String filePath = "C:\\Users\\Nikki singh\\Downloads\\200605_BLM US Protests_02_4k_038.mp4"; //My video  file to be analysed//
	        VideoCapture cap = new VideoCapture(0);// Load video using the videocapture method//
	         Mat frame = new Mat(); // define a matrix to extract and store pixel info from video//
	        Mat dst = new Mat ();
	         //cap.read(frame);

	        Net net = Dnn.readNetFromDarknet(modelConfiguration, modelWeights); //OpenCV DNN supports models trained from various frameworks like Caffe and TensorFlow. It also supports various networks architectures based on YOLO//
	        //Thread.sleep(5000);
          
	        //Mat image = Imgcodecs.imread("D:\\yolo-object-detection\\yolo-object-detection\\images\\soccer.jpg");
	        Size sz = new Size(288,288);
	        
	        List<Mat> result = new ArrayList<>();
	        List<String> outBlobNames = getOutputNames(net); //RETURNING OUTPUT LAYER NAME
	       
	        while (true) {
	        	
	            if (cap.read(frame)) {
	            	Mat blob = Dnn.blobFromImage(frame, 0.00392, sz, new Scalar(0), true, true); // We feed one frame of video into the network at a time, we have to convert the image to a blob. A blob is a pre-processed image that serves as the input.//
	            	net.setInput(blob);
	            	net.forward(result, outBlobNames); //Feed forward the model to get output //
	     
	   //PREDICTION RESULT IS READY OBJECT DETECTED
	            

	       // outBlobNames.forEach(System.out::println);
	       // result.forEach(System.out::println);

	        float confThreshold = 0.6f; //Insert thresholding beyond which the model will detect objects//
	        List<Integer> clsIds = new ArrayList<>();
	        List<Float> confs = new ArrayList<>();
	        List<Rect> rects = new ArrayList<>();
	     //   System.out.println(result);
	        for (int i = 0; i < result.size(); ++i)
	        {
	            // each row is a candidate detection, the 1st 4 numbers are
	            // [center_x, center_y, width, height], followed by (N-4) class probabilities
	            Mat level = result.get(i);
	            for (int j = 0; j < level.rows(); ++j)
	            {
	                Mat row = level.row(j);
	                Mat scores = row.colRange(5, level.cols());
	                Core.MinMaxLocResult mm = Core.minMaxLoc(scores);
	                float confidence = (float)mm.maxVal;
	                Point classIdPoint = mm.maxLoc;
	                if (confidence > confThreshold)
	                {
	                    int centerX = (int)(row.get(0,0)[0] * frame.cols()); //scaling for drawing the bounding boxes//
	                    int centerY = (int)(row.get(0,1)[0] * frame.rows());
	                    int width   = (int)(row.get(0,2)[0] * frame.cols());
	                    int height  = (int)(row.get(0,3)[0] * frame.rows());
	                    int left    = centerX - width  / 2;
	                    int top     = centerY - height / 2;

	                    clsIds.add((int)classIdPoint.x);
	                    confs.add((float)confidence);
	                   rects.add(new Rect(left, top, width, height));
	                }
	            }
	        }
	        float nmsThresh = 0.6f;
	        MatOfFloat confidences = new MatOfFloat();
	        try {
	         confidences = new MatOfFloat(Converters.vector_float_to_Mat(confs));
	        }
	        catch(Exception e) {
	        	
	        }
	        Rect[] boxesArray = rects.toArray(new Rect[0]);
	        
	        MatOfRect boxes = new MatOfRect(boxesArray);
	        MatOfRect2d rect2d=new MatOfRect2d();
	        List <Rect2d> lrect=new ArrayList();
	        for(int h=0;h<boxes.height();h++) {
	        
	        	Rect2d r2=new Rect2d(boxes.get(h, 0)[0],boxes.get(h, 0)[1],boxes.get(h, 0)[2],boxes.get(h, 0)[3]);
	        	lrect.add(r2);
	        
	        }
	        
	        rect2d.fromList(lrect);
	   //     rect2d.put
	        //System.out.println(rect2d.dump());
	        MatOfInt indices = new MatOfInt();
	        
	        //This will perform Non-Maximum suppression on multiple bounding boxes
	        Dnn.NMSBoxes(rect2d, confidences, confThreshold, nmsThresh, indices); //We draw the bounding boxes for objects here//
	        try {
	        int [] ind = indices.toArray();
	        int j=0;
	        for (int i = 0; i < ind.length; ++i)
	        {
	            int idx = ind[i];
	            Rect box = boxesArray[idx];
	            Imgproc.rectangle(frame, box.tl(), box.br(), new Scalar(0,0,255), 3);
	            //i=j;
	            
	       //     System.out.println(idx);
	        }
	        }
	        catch(Exception ed) {
	        	
	        }
	       // Imgcodecs.imwrite("D://out.png", image);
	        //System.out.println("Image Loaded");
	        HighGui.imshow("YoLo", frame);
	        HighGui.waitKey(1);
	        // System.out.println(j);
	        // System.out.println("Done");
		
	        }
	            
	      }  
	        
	}     
	        
	        
//	}
	private static BufferedImage Mat2bufferedImage(Mat image) {   // The class described here  takes in matrix and renders the video to the frame  //
		MatOfByte bytemat = new MatOfByte();
		Imgcodecs.imencode(".jpg", image, bytemat);
		byte[] bytes = bytemat.toArray();
		InputStream in = new ByteArrayInputStream(bytes);
		BufferedImage img = null;
		try {
			img = ImageIO.read(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}


}
