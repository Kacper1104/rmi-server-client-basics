import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {
    public static void main(String[] args){
        ICalcObject2 calcObject;
        ICalcObject2 calcObject2;
        ICalcObject2 calcObject3;

        ResultType result;
        ResultType result2;
        ResultType result3;


        InputType inputObject;
        InputType inputObject2;
        InputType inputObject3;

        if(args.length == 0){
            System.out.println("You have to enter RMI object address in the form: //host_address/service_name");
            return;
        }
        String address = args[0];
        String address2 = args[1];
        String address3 = args[2];
        try{
            calcObject = (ICalcObject2) Naming.lookup(address);
        }catch(NotBoundException | MalformedURLException | RemoteException e){
            System.out.println("COULD NOT FIND A REFERENCE TO "+address);
            e.printStackTrace();
            return;
        }
        try{
            calcObject2 = (ICalcObject2) Naming.lookup(address2);
        }catch(NotBoundException | MalformedURLException | RemoteException e){
            System.out.println("COULD NOT FIND A REFERENCE TO "+address2);
            e.printStackTrace();
            return;
        }
        try{
            calcObject3 = (ICalcObject2) Naming.lookup(address3);
        }catch(NotBoundException | MalformedURLException | RemoteException e){
            System.out.println("COULD NOT FIND A REFERENCE TO "+address3);
            e.printStackTrace();
            return;
        }
        System.out.println("REFERENCE TO "+address+", "+address2+", "+address3+" HAS BEEN DOWNLOADED.");
        try{
            //Wez Janów z 1 listy
            inputObject = new InputType();
            inputObject.list = new String[]{"Janusz Marciniak", "Jan Kowalski", "Jan Kowal", "Jan Nowak", "Jan Nowakowski, Michal Nowacki"};
            inputObject.filter = "Jan";
            inputObject.list2 = new String[]{};
            inputObject.operation = "filterName";
            result = calcObject.execute(inputObject);
            //System.out.println(result.result.length);

            //Weż ludzi z nazwiskiem na N z drugiej listy
            inputObject2 = new InputType();
            inputObject2.list = new String[]{"Janusz Marciniak", "Jan Kowalski", "Jan Kowal", "Jan Nowak", "Jan Nowakowski", "Michal Nowacki"};
            inputObject2.filter = "N";
            inputObject2.list2 = new String[]{};
            inputObject2.operation = "filterSurname";
            result2 = calcObject2.execute(inputObject2);
            //System.out.println(result2.result.length);

            //Dodaj te listy
            inputObject3 = new InputType();
            inputObject3.list = result.result;
            inputObject3.filter = "";
            inputObject3.list2 = result2.result;
            inputObject3.operation = "merge";
            result3 = calcObject3.execute(inputObject3);


        }catch(RemoteException e){
            System.out.println("REMOTE EXECUTION ERROR");
            e.printStackTrace();
            return;
        }
        //How many people finally?
        System.out.println("Result: "+result3.result.length);
        //for (int i = 0; i < result3.result.length; i++){
        //    System.out.println(result3.result[i]);
        //}
    }
}
