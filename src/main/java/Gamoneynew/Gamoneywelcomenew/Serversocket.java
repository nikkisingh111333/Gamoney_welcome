package Gamoneynew.Gamoneywelcomenew;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class Serversocket {
//   public static void main(String[] p) throws IOException, URISyntaxException {
//	  
//	   try
//       { 
//           ServerSocket server = new ServerSocket(6666); 
//           System.out.println("Server started"); 
// 
//           System.out.println("Waiting for a client ..."); 
// 
//           Socket socket = server.accept(); 
//           System.out.println("Client accepted"); 
// 
//           // takes input from the client socket 
//           DataInputStream in = new DataInputStream( 
//               new BufferedInputStream(socket.getInputStream())); 
// 
//           String line = ""; 
// 
//           // reads message from client until "Over" is sent 
//           while (!line.equals("Over")) 
//           { 
//               try
//               { 
//                   line = in.readUTF(); 
//                   System.out.println(line); 
// 
//               } 
//               catch(IOException i) 
//               { 
//                   System.out.println(i); 
//               } 
//           } 
//           System.out.println("Closing connection"); 
// 
//           // close connection 
//          socket.close(); 
//           in.close(); 
//       } 
//       catch(IOException i) 
//       { 
//           System.out.println(i); 
//       } 
//}
}
