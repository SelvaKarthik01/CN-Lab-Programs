import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteImpl extends UnicastRemoteObject implements RemoteInterface
{
 protected RemoteImpl() throws RemoteException
 {
  super();
 }
 public int multiply(int a,int b) throws RemoteException
 {
  return a*b;
 }
}