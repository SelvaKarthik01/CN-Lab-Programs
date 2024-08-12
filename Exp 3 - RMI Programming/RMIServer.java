import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class RMIServer
{
 public static void main(String args[])
 {
  try
  {
  RemoteImpl remoteObj = new RemoteImpl();
  LocateRegistry.createRegistry(2000);
  Naming.rebind("//localhost:2000/RemoteService",remoteObj);
  System.out.println("remote Service is Running ....");
 }catch(Exception e)
 {
  e.printStackTrace();
 }
}
}