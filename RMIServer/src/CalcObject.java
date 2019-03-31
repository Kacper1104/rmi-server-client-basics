import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import static java.lang.Math.round;

public class CalcObject extends UnicastRemoteObject implements ICalcObject{

    public static final long serialVersionUID = 101L;

    protected CalcObject() throws RemoteException {
        super();
    }

    public double calculate(double a, double b) throws RemoteException{
        double result = (a+b)*100;
        result = round(result);
        result = result/100;

        return result;
    }
}
