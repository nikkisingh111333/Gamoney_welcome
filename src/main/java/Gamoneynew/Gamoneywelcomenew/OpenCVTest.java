package Gamoneynew.Gamoneywelcomenew;
//
//import java.awt.Color;
//import java.awt.Rectangle;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Stack;
//
//import javax.imageio.ImageIO;
//import javax.imageio.stream.ImageOutputStreamImpl;
//
//import org.opencv.core.Core;
//import org.opencv.core.Core.MinMaxLocResult;
//import org.opencv.core.CvType;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfByte;
//import org.opencv.core.MatOfPoint;
//import org.opencv.core.Point;
//import org.opencv.core.Rect;
//import org.opencv.core.Scalar;
//import org.opencv.core.Size;
//import org.opencv.highgui.HighGui;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//
//import net.bytebuddy.dynamic.scaffold.MethodGraph.Node;
//import net.sourceforge.lept4j.util.LoadLibs;
//import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.TesseractException;
//import org.opencv.videoio.VideoCapture;
public class OpenCVTest {
//    
//	public static void main(String[] args) throws IOException, TesseractException, URISyntaxException {
////		// TODO Auto-generated method stub
////		
////		Integer i=255;
////             System.out.println(0x4);
////   BASIC OPEN-CV OPERATION LEVEL-1
////		//System.loadLibrary(Core.VERSION);
//      System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
////      //System.out.println(Core.getVersionString());
////         Mat m=new Mat(6,4,CvType.CV_32S, new Scalar(33,23,255)); //create a matrix for image holding 16 bit signed integer values
////             System.out.println(m.cols());//get columns
////             System.out.println(m.depth()+"--");
////             System.out.println(m.rows());
////             System.out.println(m.elemSize1());
////             System.out.println(m.height());
////             System.out.println(m.dot(m));
////            // Mat t=m.row(0);
////        // m.setTo(new Scalar(9));
////    //  System.out.println("----"+m.dump()); //will return string array of image with pointers(pixel values of their respective RGB)
//         Imgcodecs imc=new Imgcodecs();
////         MatOfByte mob=new MatOfByte();
//         byte[] by=Files.readAllBytes(Paths.get("C:\\\\Users\\\\Nikki singh\\\\Downloads\\\\One.png"));
//       //  Mat imgmatrix=imc.imdecode(new MatOfByte(by),imc.IMREAD_COLOR);
//       Mat  imgmatrix=Imgcodecs.imread("C:\\Users\\Nikki singh\\Downloads\\pubg_img_black.png");
//       //return a new mat with new channels
//       System.out.println("LOST:"+imgmatrix.reshape(imgmatrix.channels(), 1).dump());
//       imgmatrix.convertTo(imgmatrix, CvType.CV_8UC1);
//       Imgproc.cvtColor(imgmatrix, imgmatrix, Imgproc.COLOR_RGB2GRAY);
//         Mat dst=new Mat(imgmatrix.cols(),imgmatrix.rows(),CvType.CV_8UC1);
//         Imgproc.equalizeHist(imgmatrix, dst);
//         List<Mat> g=new ArrayList<Mat>();
//         Core.split(imgmatrix,g);
//         System.out.println(g.get(0).dump());
//         HighGui.imshow("equalize", dst);
//         HighGui.waitKey(2);
////         Mat u=new Mat(imgmatrix,new Rect(0,0,150,20));
////       //  System.out.println(imgmatrix.dump());
//// //        Mat imgmatrix_2=mb.clone();
////     //will return Matrix object of image pointers(pixel values of their respective RGB)
////          //preprocess this image to grascale
////         imgmatrix=Imgcodecs.imread("C:\\Users\\Nikki singh\\Downloads\\pubg_img_black.png");
////
////         Mat imgmatrix_2=Imgcodecs.imread("C:\\Users\\Nikki singh\\Downloads\\my dp_crop.jpg");
////         int match=Imgproc.TM_CCOEFF_NORMED;//DONT KNOW ABOUT WHAT IT IS BUT MATTHEMATICALLY WE WILL UNDERSTAND THIS
////         Mat output=new Mat();
//////         Imgproc.matchTemplate(imgmatrix, imgmatrix_2, output, match); //WILL FIND ANY GIVEN TEMPLATE INTO ITS ORIGINAL IMAGE AND SAVE IT INTO OUTPUT
//////         MinMaxLocResult mmr=Core.minMaxLoc(output);
//////         //System.out.println(imgmatrix_2.dump());
//////         System.out.println("Point--"+mmr+"----max-val---"+mmr.maxVal);
//////         Point p=mmr.maxLoc;
//////         System.out.println(p.x+"-----"+p.y);
//////         Imgproc.rectangle(output, p, new Point(p.x + imgmatrix_2.cols(),
//////                 p.y + imgmatrix_2.rows()), new Scalar(25, 155, 135));
////         
//////          System.out.println(imgmatrix_2.dump());
//////          Mat kern = new Mat(imgmatrix.rows(), imgmatrix.cols(), CvType.CV_8S);
//////          int row = 3, col = 3;   
//////          kern.put(row, col, 0, -1, 0, -1, 5, -1, 0, -1, 0);
//////          System.out.println("KERnel:"+kern.dump());
//////          Rect r=new Rect(5,5,imgmatrix.width(),10);
//////          Imgproc.rectangle(imgmatrix,r,new Scalar(100,10,60),50);//Scalar is rgb value representer R,G,B
////                                   
//////          System.out.println("--=-="+imgmatrix.elemSize1());
//////          System.out.println(imgmatrix.dump());
//////        WRITE IMAGE INTO FOLDER WITH EXTENSION
//////         imc.imwrite("C:\\Users\\Nikki singh\\Downloads\\new-image2.png",imgmatrix);
////        
//////          BASIC OPEN-CV OPERATION LEVEL-2
////   //to convert image matrix into our favourite bufferedimage 
////         MatOfByte matOfByte=new MatOfByte(); //conveert image matrix object into imagematrixbyte object
////    //  imc.imencode(".png", imgmatrix, matOfByte);  //write imgmatrix to write each pixel value into byte object 
////     //  byte[] bytearr=matOfByte.toArray();
////   //    System.out.println(bytearr[0]+"___"+bytearr[1]);
////   //    ByteArrayInputStream b=new ByteArrayInputStream(bytearr); //most usefull stream class
////     //  var t=b.readNBytes(5);
////    //   System.out.println(t[0]);
////  //     BufferedImage buff_img=ImageIO.read(b);
//////BASIC OPEN-CV OPERATION LEVEL-3
////  //to convert RGB to Binary_Image 
////      
////         Mat dst=new Mat();
//////       Imgproc.threshold(imgmatrix, dst,300, 300, Imgproc.THRESH_OTSU);
//////       System.out.println(dst.cols()+"------"+dst.elemSize());
//////       
//////       byte[] data1 = new byte[dst.rows() * dst.cols() * (int)(dst.elemSize())];
//////       dst.get(0, 0, data1);
//////
//////       // Creating Buffered image using the data
//////       BufferedImage bufImage = new BufferedImage(dst.cols(),dst.rows(), 
//////          BufferedImage.TYPE_BYTE_GRAY);
////
////       // Setting the data elements to the image
//////       Imgproc.rectangle (
//////    	         imgmatrix,                    //Matrix obj of the image
//////    	         new Point(130, 50),        //p1
//////    	         new Point(300, 280),       //p2
//////    	         new Scalar(100, 160, 205),     //Scalar object for color  BLUE,GREEN,RED respectively
//////    	         5                          //Thickness of the line
//////    	      );
////       
//////ADVANCE OPEN-CV THRESHOLDING
////       Mat dst_2 = new Mat();
//// //     System.out.println(dst_2.channels()+"----"+dst_2.);
////       Mat dst_3=new Mat();
////       Imgproc.cvtColor(imgmatrix, dst_2,Imgproc.COLOR_BGR2GRAY);
////      // Mat ant=new Mat(imgmatrix,new Rect(20,20,imgmatrix_2.cols(),imgmatrix_2.rows()));
////       // Creating kernel matrix
////    //   Mat kernel = Mat.ones(50,260, CvType.CV_32F); //what this do
////      // System.out.println("Before-Thresholding-image:"+imgmatrix.dump());
////       // Applying Blur effect on the Image 
////       //Imgproc.morphologyEx(imgmatrix, dst_2, Imgproc.MORPH_TOPHAT, kernel);//morpho trasformation
////       // Imgproc.Canny(dst_2, dst_2, 20, 20);  //find edges in pixel 
////      
////    // Imgproc.resize(imgmatrix, dst_2,new Size(100,120));
////      
////       
////    //    Imgproc.filter
////     
////     //accept only MORPH_ERODE,MORPH_DILATE,MORPH_CROSS,MORPH_ELLIPSE,MORPH_RECT
////       //Returns kernel matrix with shapes in background in 0s and 1s format
////       //its just a kernel matrix act as a filter for this image
////
////    //   Imgproc.bilateralFilter(im, dst_2, 55, 55, 55);
////     //  Mat y=Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(100,100));
////   //    System.out.println(y.dump());
////     // Imgproc.dilate(imgmatrix, dst_2,y);  //create eclipse where any kind of noise and break point present
////     //  Imgproc.dilate(dst_2, dst_2,y);
////      // Mat sub=dst_2.submat(10,6,50 , 50);
////      //System.out.println("Subimage:"+sub.dump());
////      //Sharpness Of Image
////  //     System.out.println(Imgproc.moments(dst_2).m00);
////   //  Imgproc.GaussianBlur(imgmatrix, dst_2, new Size(9,9), 13);
////     // Imgproc.Laplacian(imgmatrix, dst_2, 1, 4,4);  //values should be positive
////      //calculate the sum of two images pixel and compare original image with filtered image to give better result
////  //   System.out.println(imgmatrix.cols()+"--@@@@@@@--"+imgmatrix_2.cols());
////     
////     //Core.addWeighted(imgmatrix, 1.5, dst_2,-0.5,25, dst_2); //dst_2=src1*alpha + src2*beta + gamma
////     // imgmatrix.convertTo(dst_2,CvType.CV_8UC1 );
////     System.out.println("Properties:"+dst_2.type());
////      
////        Imgproc.threshold(dst_2, dst_2, 254, 255, Imgproc.THRESH_BINARY_INV);
////      //  Imgproc.resize(dst_2, dst_2, new Size(1000,400),0,900,Imgproc.INTER_LANCZOS4);
////      //Imgproc.applyColorMap(dst_2, dst_3,Imgproc.COLORMAP_HOT);
////      // Imgproc.medianBlur(dst_2, dst_3, 7);  //median blur sharpening image
////      //   System.out.println("Thresholding -image:"+dst_2.dump());
////  //    Imgproc.filter2D(imgmatrix, dst_2, imgmatrix.depth(), kern);
////       //imc.imencode(".png", dst_2, matOfByte);
////    //   Imgproc.cvtColor(dst_2, dst_2,7,8);
////         List <MatOfPoint> l=new ArrayList<MatOfPoint>();
////        //imgmatrix.convertTo(dst_2, CvType.CV_8UC3);//should be CV_8UC1 for contour finding if we are using RETR_TREE
//// //     Imgproc.findContours(dst_2,l, dst_2, Imgproc.RETR_TREE,Imgproc.CHAIN_APPROX_SIMPLE);
////    //  System.out.println(l.get(0).dump()+"---"+l.get(1).dump());
////      //System.out.println("New:"+dst_2);
////  //    Mat contourImg = new Mat(dst_3.size(), dst_3.type());
////         Mat cannycolor=new Mat();
////     //    Imgproc.cvtColor(imgmatrix, dst_2,Imgproc.COLOR_RGB2GRAY);
//////      Imgproc.Canny(dst_2,dst_2, 10, 100,3,false); //change the color of image
////    //      Imgproc.drawContours(contourImg, l, 14, new Scalar(255, 255, 250), 4);//if contourldx is -1 then it will create contour on all image
//////      Imgproc.HoughLines(dst_2,dst_3,  1, Math.PI/180,100);
////    //  Core.inRange(dst_2, new Scalar(0,0,50), new Scalar(0,0,130), dst_2);//scalar will hold R,G,B values of the given range And RGB will be converted into HUE of the object Scalar will act as threshold
////         
////      ///     //WILL DO SOME BITWISE METHOD AND TRANSFORM IMAGE
//////         Mat c=new Mat(500,204,CvType.CV_8U,new Scalar(40,50,106));
//////         Mat c2=new Mat(500,203,CvType.CV_8U,new Scalar(111,5,6));
//////         System.out.println(c.dump()+"----"+c2.dump());
//////         //BITWISE AND ,BITWISE_OR are usually use for masking just like clippath in css on two images of same size..image should be in binary for good effect
//////         Core.bitwise_xor(imgmatrix_2, ant, dst_3);   //WILL ADD SECOND IMAGE ON TOP OF 1ST IMAGE ..bitwise_and() will work reverse size of image should be similar
//////      System.out.println("Bitwise-AND:"+dst_3.dump());
////      imc.imwrite("C:\\Users\\Nikki singh\\Downloads\\pubg_img_white.png",dst_2);
////      MatOfByte mm=new MatOfByte();
////      imc.imencode(".png",dst_2, mm);
////      
////    //  byte[] b=mm.toArray();
////    //  InputStream in=new ByteArrayInputStream(b);
////    //  System.out.println(in.available());
//////       Tesseract tess=new Tesseract();
//////       File tessfolder = LoadLibs.extractNativeResources("tessdata");
//////      
//////
//////		tess.setDatapath(tessfolder.getAbsolutePath());
//////		System.out.println(tessfolder.getAbsolutePath());
//////	//    t.setHocr(true);
//////	    tess.setPageSegMode(2);
//////	    
//////		tess.setOcrEngineMode(1);
//////		tess.setLanguage("eng");
//////	    //System.out.println(t.doOCR(new File("C:\\Users\\Nikki singh\\Downloads\\pubg-mobile-statistics-screens-cropped.jpg")));
//////		System.out.println(bm);
//////		Rectangle r=new Rectangle();
//////		r.setBounds(1, 30, 400, 70);
////	//	ImageInfo i=new ImageInfo("C:\\Users\\Nikki singh\\Downloads\\resultCropped.png");
////	 //    MagickImage mm=new MagickImage(i);
////	 //    mm.reduceNoiseImage(20);
////	//  System.out.println( mm.getImageFormat());
////		//System.out.println(tess.doOCR(bm));
////       
// }
//
}
