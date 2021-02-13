package Gamoneynew.Gamoneywelcomenew;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;
import org.opencv.videoio.VideoCapture;

public class FaceDetectOpenCV {
    public static Mat  emoji(Rect r,InputStream is,InputStream emoji) throws IOException {
    	BufferedImage br1=ImageIO.read(is);
    	BufferedImage br2=ImageIO.read(emoji);
    	Graphics g=br1.getGraphics();
    
         for(int h=0;h<br2.getHeight();h++) {
        	 for(int w=0;w<br2.getWidth();w++) {
        		 Integer rgb=br2.getRGB(w,h);
        		 
        //	 System.out.println("RGB:"+rgb);
             int red = new Color(rgb).getRed(); 
             int green = new Color(rgb).getGreen(); 
             int blue = new Color(rgb).getBlue(); 
             int alpha=new Color(rgb).getAlpha();
////             if(rgb==-16777216) {
////            	 //System.out.println("RGB=-1="+red+"---"+green+"---"+blue);
////            	 alpha=255-230;
////            	// System.out.println("alpha-"+alpha+"--rgb--"+rgb);
////                 
////             }
             if(rgb==-1) {
            	 alpha=255-250;
             }
             else {
            	// System.out.println("RGB NOT WHITE="+red+"---"+green+"---"+blue);
             	
             int avg=(red+green+blue)/3;
         //   System.out.println("alpha-"+alpha+"--rgb--"+rgb);
             
              //  System.out.println(red+"----"+green+"----"+blue+"-AVG--"+avg);
             //  System.out.println("Position: X-"+x+"---Y-"+y);
               
             } 
            
             rgb = (alpha<<24) | (red<<16) | (green<<8) | blue;
                br2.setRGB(w, h, rgb);
        	 }
         }
     	g.drawImage(br2, r.x, r.y+30,null);
    	ByteArrayOutputStream out=new ByteArrayOutputStream();
    	ImageIO.write(br1,"png", out);
    
     	Mat final_image=Imgcodecs.imdecode(new MatOfByte(out.toByteArray()),Imgcodecs.IMREAD_COLOR);
    	return final_image;
    	
    }
	public static void main(String[] args) throws IOException {

	    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	    Mat n=new Mat(new Size(3,4),CvType.CV_32F,new Scalar(2,3,4));
	    System.out.println(n.dump());
	    Mat u=new Mat();
	    Mat w=new Mat();
	    Mat vt=new Mat();
	    try {
		  Core.SVDecomp(n, w, u, vt,Core.DECOMP_LU);//decompose this matrix into lower and upper triangular matrix
	//	  System.out.println(u.dump());
	    }
	    catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }
	    
		// TODO Auto-generated method stub
		  String fname="testingImg";
	      String opration="contour";
		  Mat m=Imgcodecs.imread("C:\\Users\\Nikki singh\\Downloads\\"+fname+".jpg");
		  Mat duck=Imgcodecs.imread("C:\\Users\\Nikki singh\\Downloads\\glass.png");
		  Imgproc.cvtColor(duck, duck,Imgproc.COLOR_RGB2BGRA);
		  System.out.println("Channel"+duck.channels());
		//  Imgproc.dilate(duck, duck,Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(10,10)));
		  VideoCapture capture = new VideoCapture(0);
		  Mat image = new Mat();
		  int index = 0;
		  Imgcodecs imc=new Imgcodecs();
	//	System.out.println(capture.isOpened());
		  if (capture.isOpened()) {
		    while(true) {
				capture.read(image); //THIS FUNCTION WILL OPEN CAMERA AND CAPTURE LIVE IMAGE ADN CREATE MAT FROM THE PIXELS
				//System.out.println(image.dump());
				MatOfRect rect=new MatOfRect();
				Imgproc.cvtColor(image, image,Imgproc.COLOR_BGR2GRAY);
				CascadeClassifier cascadeClassifier = new CascadeClassifier(); 
				int minFaceSize = Math.round(image.rows() * 0.1f); 
		//		System.out.println(image.rows()+"--"+image.rows() * 0.1f);
				//System.out.println("FACE SIZE:"+Math.round(image.rows() * 0.1f));
				cascadeClassifier.load("./src/main/resources/haarcascade/geti3.xml"); 
				cascadeClassifier.detectMultiScale(image, 
						  rect, 
						  1.5, 
						  5, 
						  Objdetect.CASCADE_DO_CANNY_PRUNING, 
						  new Size(0, 100), 
						  new Size() 
						);
		//		System.out.println("MAt ofRect:"+rect.dump());
				Rect[] facesArray = rect.toArray(); 
				Imgproc.resize(duck, duck, new Size(200,90));
				Mat img2=null;
				Imgproc.cvtColor(image, image,Imgproc.COLOR_GRAY2RGB);
				Mat new_img=null;
				for(Rect face : facesArray) { 
		//			System.out.println("Faces:"+face.toString()+"--"+face.height);
					System.out.println(face.tl()+"----"+face.br()+"-----");

					 Imgproc.rectangle(image, face.tl(), face.br(), new Scalar(0, 240, 0), 3);
				     MatOfByte mb=new MatOfByte();//ADDING A IMAGE INTO IMAGE
				    		 imc.imencode(".png", image, mb);  //write imgmatrix to write each pixel value into byte object 
				     byte[] bytearr=mb.toArray();
		//		     System.out.println(bytearr[0]+"___"+bytearr[1]);
				     ByteArrayInputStream b=new ByteArrayInputStream(bytearr); //most usefull stream class
				     MatOfByte mb2=new MatOfByte();//ADDING A IMAGE INTO IMAGE
		    		 imc.imencode(".png", duck, mb2);  //write imgmatrix to write each pixel value into byte object 
		    		 byte[] bytearr2=mb2.toArray();
		 //    System.out.println(bytearr2[0]+"___"+bytearr2[1]);
		    		 ByteArrayInputStream b2=new ByteArrayInputStream(bytearr2); //most usefull stream class
		    
				   //  new_img=emoji(face,b,b2); 
				     
					
					
					} 
					try {
						HighGui.imshow("IMAGEEEEEs",image);
						index = HighGui.waitKey(1);
				
		//		System.out.println("OVER");
				
		//		System.out.println(capture);
						if (index == 27) {
			      
						}
					}
					catch(Exception e) {
			//		System.out.println("NANANANAN"+e.getMessage());
					}
		    	}
			}
		
		//capture.retrieve(m);
		
//        VideoCapture v=new VideoCapture(0);
//        Mat m=new Mat();
//        v.retrieve(m);
//        v.open(1);
//	    CascadeClassifier faceDetector = new CascadeClassifier(FaceDetector.class.getResource("haarcascade_mcs_mouth.xml").getPath().substring(1));
//	    Mat image = HighGui.imshow("im", img);
//	            .imread(FaceDetector.class.getResource("sarah.jpg").getPath().substring(1));
//	    MatOfRect faceDetections = new MatOfRect();
//	    faceDetector.detectMultiScale(image, faceDetections);
//
//	    System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));     WE WILL WORK ON IT SOON
//      
       Imgproc.cvtColor(m, m,Imgproc.COLOR_BGR2GRAY);
       Imgproc.Canny(m, m, 0, 0);
       Mat cont_mat=new Mat();
       Mat b=new Mat();
//       List<MatOfPoint> mp=new ArrayList<MatOfPoint>();
//    		   Imgproc.findContours(m,mp,b,Imgproc.RETR_EXTERNAL,Imgproc.CHAIN_APPROX_SIMPLE); //finding contour vector of an image with chain method
//    		   double finalContourArea=0;
//    	        int count =0;
//    	        for(int i=0;i<mp.size();i++) {
//    	            System.out.println(mp.get(0).dump());
//    	            Imgproc.drawContours(m,mp,i,new Scalar(150,25,140,105),2);
//
//    	            double contourArea = Imgproc.contourArea(mp.get(i));
//    	            finalContourArea += contourArea;  
//    	        }
//    	        System.out.println(finalContourArea+"---Counts--"+count);
       Imgcodecs.imwrite("C:\\Users\\Nikki singh\\Downloads\\"+fname+"_"+opration+".jpg",m);
	}
	
}
