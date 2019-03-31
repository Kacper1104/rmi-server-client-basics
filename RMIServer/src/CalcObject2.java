import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcObject2 extends UnicastRemoteObject implements ICalcObject2 {
    public CalcObject2() throws RemoteException{
        super();
    }

    @Override
    public ResultType calculate(InputType inputParam) throws RemoteException {
        double var1, var2;
        ResultType result = new ResultType();

        var1 = inputParam.getx1();
        var2 = inputParam.getx2();
        result.result_description = "Operation "+inputParam.operation;

        switch(inputParam.operation){
            case "add":
                result.result = var1 + var2;
                break;
            case "sub":
                result.result = var1-var2;
                break;
            default:
                result.result = 0;
                result.result_description = "Wrong operation";
                return result;
        }
        return result;
    }
}
