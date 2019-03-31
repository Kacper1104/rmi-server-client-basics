import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalcObject{

    public double calculate(double a, double b) throws RemoteException;
}
