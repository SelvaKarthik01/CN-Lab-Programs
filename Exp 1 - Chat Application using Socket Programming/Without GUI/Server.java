//Creating a Chat Application for a Server Socket
import java.io.*;
import java.net.*;
public class Server
{
 private ServerSocket server = null;
 private Socket socket = null;
 private DataInputStream in = null;
 public Server(int port)
 {
  try
  {
   server = new ServerSocket(port);
   System.out.println("Server Socket is been Created !!");
   socket = server.accept();
   System.out.println("Connection is been Established !!");
   in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
   String line = "";
   while(!line.equals("Over"))
   {
    try
    {
     line = in.readUTF();
     System.out.println(line);
    }catch(IOException i){System.out.println(i);}
   }
   socket.close();
   in.close();
  }catch(IOException i){System.out.println(i);}
 }
 public static void main(String args[])
 {
  Server server = new Server(5000);
 }
}
 
    