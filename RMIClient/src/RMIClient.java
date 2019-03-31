import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {
    public static void main(String[] args){
        ICalcObject2 calcObject;
        ResultType result;
        InputType inputObject;

        if(args.length == 0){
            System.out.println("You have to enter RMI object address in the form: //host_address/service_name");
            return;
        }
        String address = args[0];
        try{
            calcObject = (ICalcObject2) Naming.lookup(address);
        }catch(NotBoundException | MalformedURLException | RemoteException e){
            System.out.println("COULD NOT FIND A REFERENCE TO "+address);
            e.printStackTrace();
            return;
        }
        System.out.println("REFERENCE TO "+address+" HAS BEEN DOWNLOADED.");
        try{
            inputObject = new InputType();
            inputObject.x1 = 1.1;
            inputObject.x2 = 2.2;
            inputObject.operation = args[1];

            result = calcObject.calculate(inputObject);
        }catch(RemoteException e){
            System.out.println("REMOTE EXECUTION ERROR");
            e.printStackTrace();
            return;
        }
        System.out.println("Result: "+result.result);
    }
}
