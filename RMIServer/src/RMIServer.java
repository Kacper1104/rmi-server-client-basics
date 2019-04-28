import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public static void main(String [] args){
        //try {
            //Registry reg = LocateRegistry.createRegistry(1099);
        //}catch (RemoteException e){
            //e.printStackTrace();
        //}

        if(args.length == 0){
            System.out.println("You have to enter RMI object address in the form: //host_address/service_name\"");
            return;
        }
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try{
            CalcObject2 calcObject = new CalcObject2();

            Naming.rebind(args[0], calcObject);
            //Naming.rebind(args[1], calcObject);
            System.out.println("Server is registered now");
            System.out.println("Press Ctrl+C to stop...");
        }catch(RemoteException | MalformedURLException e) {
            System.out.println("SERVER CANNOT BE REGISTERED!");
            e.printStackTrace();
            return;
        }
    }
}
