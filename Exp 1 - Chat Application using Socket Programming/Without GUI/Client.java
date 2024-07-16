// Creating a Client Application using Socket Programming 
import java.io.*;
import java.net.*;
public class Client
{
 private Socket socket = null;
 private DataInputStream in = null;
 private DataOutputStream out = null;
 public Client(String address,int port)
 {
  try
  {
   socket = new Socket(address,port);
   System.out.println("Client Socket is been Created !!");
   in = new DataInputStream(System.in);
   out = new DataOutputStream(socket.getOutputStream());
   String line = "";
   while(!line.equals("Over"))
   {
    try
    {
     line = in.readLine();
     out.writeUTF(line);
    }catch(IOException i){System.out.println(i);}
   }
   socket.close();
   in.close();
   out.close();
  }catch(UnknownHostException i){System.out.println(i);}
  catch(IOException i){System.out.println(i);}
 }
 public static void main(String args[])
 {
  Client client = new Client("127.0.0.1",5000);
 }
}