package Gamoneynew.Gamoneywelcomenew;

//import org.opencv.core.Core;
//import org.opencv.core.CvType;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfRect;
//import org.opencv.core.Rect;
//import org.opencv.core.Scalar;
//import org.opencv.core.Size;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//import org.opencv.objdetect.CascadeClassifier;
//import org.opencv.objdetect.Objdetect;

public class FaceDetectionOpenCV {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//		Mat mm=new Mat(new Size(4,2),CvType.CV_8U);
//		
//		mm.setTo(new Scalar(7));
//		mm.setTo(new Scalar(17));
//		mm.setTo(new Scalar(1));
//		mm.setTo(new Scalar(3));
//		mm.setTo(new Scalar(-1));
//		mm.setTo(new Scalar(7));
//		mm.setTo(new Scalar(18));
//		mm.setTo(new Scalar(1));
//		mm.setTo(new Scalar(1));
//		mm.setTo(new Scalar(3));
//		
//		System.out.println(mm.dump()+"---"+mm.channels());
//		Mat img=Imgcodecs.imread("C:\\Users\\Nikki singh\\Downloads\\Screenshot (22).png");
//		MatOfRect rect=new MatOfRect();
//		Imgproc.cvtColor(img, img,Imgproc.COLOR_BGR2GRAY);
//		CascadeClassifier cascadeClassifier = new CascadeClassifier(); 
//		int minFaceSize = Math.round(img.rows() * 0.1f); 
//		System.out.println("FACE SIZE:"+Math.round(img.rows() * 0.2f));
//		cascadeClassifier.load("./src/main/resources/haarcascade/pubg_img.xml"); 
//		cascadeClassifier.detectMultiScale(img, 
//		  rect, 
//		  1.2, 
//		  1, 
//		  Objdetect.CASCADE_SCALE_IMAGE, 
//		  new Size(minFaceSize, minFaceSize), 
//		  new Size() 
//		);  //this function 
//		System.out.println("MAt ofRect:"+rect.dump());
//		Rect[] facesArray = rect.toArray(); 
//		for(Rect face : facesArray) { 
//			System.out.println("Faces:"+face.toString());
//			System.out.println(face.tl()+"----"+face.br()+"-----");
//		    Imgproc.rectangle(img, face.tl(), face.br(), new Scalar(180, 11, 215), 3); 
//		} 
//		
//		Imgcodecs.imwrite("C:\\Users\\Nikki singh\\Downloads\\CAR_CASCADE.jpg",img);
//		
//	}

}
