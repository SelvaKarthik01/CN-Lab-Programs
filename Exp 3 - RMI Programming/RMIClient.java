import java.rmi.Naming;
import java.util.Scanner;
public class RMIClient
{
 public static void main(String args[])
 {
  try
  {
   RemoteInterface remoteObj = (RemoteInterface) Naming.lookup("//localhost:2000/RemoteService");
   Scanner input = new Scanner(System.in);
   System.out.println("Enter Your First Number : ");
   int a = input.nextInt();
   System.out.println("Ente the Second Number : ");
   int b = input.nextInt();
   int result = remoteObj.multiply(a,b);
   System.out.println("The Result of Multiplying "+a+" and "+b+" is : "+result);
   input.close();
  }catch(Exception e){e.printStackTrace();}
 }
}
   