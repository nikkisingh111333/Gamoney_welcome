package Gamoneynew.Gamoneywelcomenew;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.opencv.opencv_java;
import org.bytedeco.opencv.global.opencv_highgui;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.global.opencv_objdetect;
import org.bytedeco.opencv.opencv_core.*;
import org.bytedeco.opencv.opencv_face.*;
import org.bytedeco.opencv.opencv_imgproc.CvFont;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;

import static org.bytedeco.opencv.global.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_face.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import java.util.Arrays;
import org.bytedeco.javacpp.IntPointer;
/*
import org.bytedeco.artoolkitplus.*;*/
import org.bytedeco.opencv.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
//import static org.bytedeco.artoolkitplus.global.ARToolKitPlus.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
public class FaceRecognizers {
	static Map<Integer,String> m=new HashMap<Integer,String>();
    public static String trainer() {
    	System.out.println("NUM OF PICS");
    	Integer num_pic=new Scanner(System.in).nextInt();
    	System.out.println("NUM OF Person");
    	Integer num_person=new Scanner(System.in).nextInt();
    	Loader.load();
    	  VideoCapture capture = new VideoCapture(0);
    	  
		  Mat image = new Mat();
		  
		  int index = 0;
		  opencv_imgcodecs imc=new opencv_imgcodecs();
		System.out.println(capture.isOpened());
		  if (capture.isOpened()) {
		  for(int x=0;x<num_person;x++) {
			  System.out.println("Name of person");
			  String name=new Scanner(System.in).next();
		    	Integer labelnum=x;
		    	 m.put(labelnum,name);
		    for(int num=1;num<num_pic;num++) {
				capture.read(image); //THIS FUNCTION WILL OPEN CAMERA AND CAPTURE LIVE IMAGE ADN CREATE MAT FROM THE PIXELS
				//System.out.println(image.dump());
				RectVector rect=new RectVector();
				opencv_imgproc.cvtColor(image, image,opencv_imgproc.COLOR_BGR2GRAY);
				CascadeClassifier cascadeClassifier = new CascadeClassifier(); 
				int minFaceSize = Math.round(image.rows() * 0.1f); 
				System.out.println(image.rows()+"--"+image.rows() * 0.1f);
		//		System.out.println("FACE SIZE:"+Math.round(image.rows() * 0.1f));
				System.out.println("Is empty:"+image.empty());
			   if(image.empty()!=true) {
				cascadeClassifier.load("./src/main/resources/haarcascade/haarcascade_frontalface_alt.xml"); 
				cascadeClassifier.detectMultiScale(image, 
						  rect, 
						  1.2, 
						  2, 
						  opencv_objdetect.CASCADE_DO_CANNY_PRUNING, 
						  new Size(0, 100), 
						  new Size() 
						);
		//		System.out.println("MAt ofRect:"+rect.dump());
				Rect[] facesArray = rect.get(); 
			//	Imgproc.resize(duck, duck, new Size(200,90));
                Mat img2=null;
				opencv_imgproc.cvtColor(image, image,opencv_imgproc.COLOR_GRAY2RGB);
				Mat new_img=null;
				for(Rect face : facesArray) { 
					System.out.println("Faces:"+face.toString()+"--"+face.height());
				//	System.out.println(face.tl()+"----"+face.br()+"-----");

			//		Imgproc.rectangle(image, face.tl(), face.br(), new Scalar(0, 240, 0), 3);
				  //   ByteBuffer mb=image.asByteBuffer();// RETURNING A BYTEBUFFER COVERING THE SIZE OF IMAGE WE WANT IT TO BE AS BUFFER
				  //  		 imc.imencode(".png", image, mb);  //write imgmatrix to write each pixel value into byte object 
				  //   byte[] bytearr=mb.array();
				     Mat myimg=new Mat(image,face);
				     opencv_imgcodecs.imwrite("C:\\Users\\Nikki singh\\Downloads\\nikki's_sample\\"+name+"#"+labelnum+"_"+num+".png",myimg);
		//		     System.out.println(bytearr[0]+"___"+bytearr[1]);
				//     ByteArrayInputStream b=new ByteArrayInputStream(bytearr); //most usefull stream class
//				     ByteBuffer mb2=new  ByteBuffer();//ADDING A IMAGE INTO IMAGE
//		    //		 imc.imencode(".png", duck, mb2);  //write imgmatrix to write each pixel value into byte object 
//		    		 byte[] bytearr2=mb2.toArray();
		 //    System.out.println(bytearr2[0]+"___"+bytearr2[1]);
		   // 		 ByteArrayInputStream b2=new ByteArrayInputStream(bytearr2); //most usefull stream class
		    
				 //    new_img=emoji(face,b,b2); 
				     
					
					
				
		    	}
				try { 
					
					opencv_highgui.imshow("IMAGEEEEEs",new_img);
					index = opencv_highgui.waitKey(1);
			       
			System.out.println("OVER");
			
	//		System.out.println(capture);
					if (index == 27) {
		      
					}
				}
				catch(Exception e) {
				System.out.println("NANANANAN"+e.getMessage());
				}
		  }
		    
		  }
		    
		  }}
          return "C:\\Users\\Nikki singh\\Downloads\\nikki's_sample";
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String datasource=trainer();
		Mat testImage2=new Mat();
		
		// VideoCapture capture = new VideoCapture(0);
	//	opencv_imgproc.cvtColor(testImage2,testImage2,Imgproc.COLOR_GRAY2RGB);
        
       // Mat testImage = imread("C:\\Users\\Nikki singh\\Downloads\\nikki's_sample\\nikki#1_6.png", IMREAD_GRAYSCALE); //THIS S STATIC FUNCTION

        File root = new File(datasource);

        FilenameFilter imgFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                name = name.toLowerCase();
                return name.endsWith(".jpg") || name.endsWith(".pgm") || name.endsWith(".png");
            }
        };

        File[] imageFiles = root.listFiles(imgFilter);

        MatVector images = new MatVector(imageFiles.length);

        Mat labels = new Mat(imageFiles.length, 1, CV_32SC1);
       IntBuffer labelsBuf = labels.createBuffer();
        //System.out.println(labelsBuf.arrayOffset());
        int counter = 0;
        for (File image : imageFiles) {
            Mat img =imread(image.getAbsolutePath(),IMREAD_GRAYSCALE);
           // Imgproc.resize(img, img, new Size(500,500));  //WE WILL SORT IT OUT LATER
            System.out.println(image.getName().replace(".png", ""));
            int label = Integer.parseInt(image.getName().replace(".png", "").split("#")[1].split("_")[0]);

            images.put(counter, img);
            
            labelsBuf.put(counter, label);

            counter++;
        }
     //    System.out.println(labelsBuf.asReadOnlyBuffer().arrayOffset());
       // FaceRecognizer faceRecognizer = FisherFaceRecognizer.create();
        // FaceRecognizer faceRecognizer = EigenFaceRecognizer.create();
         FaceRecognizer faceRecognizer = LBPHFaceRecognizer.create();

        faceRecognizer.train(images, labels);
        test(faceRecognizer);
        
	}
	public static void test(FaceRecognizer fb) {
		  Mat image = new Mat();
		  int index = 0;
		  opencv_imgcodecs imc=new opencv_imgcodecs();
		  Loader.load(opencv_java.class);
		//System.out.println(capture.isOpened());
		  VideoCapture capture = new VideoCapture(0);
			 
		  Mat new_img=null;
		  if (capture.isOpened()) {
			
		    while(true) {
				capture.read(image); //THIS FUNCTION WILL OPEN CAMERA AND CAPTURE LIVE IMAGE ADN CREATE MAT FROM THE PIXELS
				//System.out.println(image.dump());
				RectVector rect=new RectVector();
				opencv_imgproc.cvtColor(image, image,opencv_imgproc.COLOR_BGR2GRAY);
				CascadeClassifier cascadeClassifier = new CascadeClassifier(); 
				int minFaceSize = Math.round(image.rows() * 0.1f); 
				System.out.println(image.rows()+"--"+image.rows() * 0.1f);
		//		System.out.println("FACE SIZE:"+Math.round(image.rows() * 0.1f));
				System.out.println("Is empty:"+image.empty());
			   if(image.empty()!=true) {
				   	cascadeClassifier.load("./src/main/resources/haarcascade/haarcascade_frontalface_alt.xml"); 
				   	cascadeClassifier.detectMultiScale(image, 
						  rect, 
						  1.2, 
						  2, 
						  opencv_objdetect.CASCADE_DO_CANNY_PRUNING, 
						  new Size(0, 100), 
						  new Size());
		//		System.out.println("MAt ofRect:"+rect.dump());
				   	Rect[] facesArray = rect.get(); 
			//	Imgproc.resize(duck, duck, new Size(200,90));
				   	Mat img2=null;
				//opencv_imgproc.cvtColor(image, image,opencv_imgproc.COLOR_GRAY2RGB);
				
				   	Mat testImage=new Mat();
					for(Rect xface : facesArray) { 
					    
					    
						new_img=new Mat(image,xface);
						IntPointer label = new IntPointer(10); //RETURN LABEL 
						DoublePointer confidence = new DoublePointer(10); //will returen confidence percentage of prediction i.e how much confident its prediction
						System.out.println("WELL:"+label);
						System.out.println(testImage);
						fb.predict(new_img, label, confidence);
						System.out.println(label.get()+"==="+confidence.get());
						int predictedLabel = label.get(0);
						String pred_name=m.get(predictedLabel);
						System.out.println("Predicted label: " + pred_name);
						opencv_imgproc.rectangle(image,xface, new Scalar(255.0,130.0,140.0,0.0));
					//CvArr cvmat=new CvArr(image);
					     
						 Point points= new Point(xface.x(),xface.y());
						putText(image, pred_name,points, opencv_imgproc.FONT_HERSHEY_SIMPLEX,1.2,new Scalar(220.0,120.0,130.0,0.0));
					}
			   }
			   try {
				   System.out.println(image.depth());
				   opencv_highgui.imshow("IMAGEEEEEs",image);  
				   index = opencv_highgui.waitKey(1);   //
		       
				   System.out.println("OVER");
		
//		System.out.println(capture);
				   if (index == 27) {
	      
				   }
			   }
			   catch(Exception e) {
				   System.out.println("NANANANAN"+e.getMessage());
			   }
		    }
		  }
		}
	}