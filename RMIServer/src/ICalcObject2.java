import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalcObject2 extends Remote {
    public ResultType execute(InputType inputParam) throws RemoteException;
}
