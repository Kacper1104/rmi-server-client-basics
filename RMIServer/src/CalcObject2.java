import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CalcObject2 extends UnicastRemoteObject implements ICalcObject2 {
    public CalcObject2() throws RemoteException{
        super();
    }

    @Override
    public ResultType execute(InputType inputParam) throws RemoteException {
        String[] list;
        String filter;
        String[] list2;
        ResultType result = new ResultType();

        list = inputParam.getlist1();
        list2 = inputParam.getlist2();
        filter = inputParam.getfilter();
        result.result_description = "Operation "+inputParam.operation;
        ArrayList<String> tempList = new ArrayList<>();
        String[] resultList;

        switch(inputParam.operation){
            case "filterName":
                for(int i = 0; i < list.length; i++){
                    if(list[i].split("\\s+")[0].equals(filter)){
                        tempList.add(list[i]);
                    }
                }
                resultList = new String[tempList.size()];
                for(int i = 0; i < tempList.size(); i++){
                    resultList[i] = tempList.get(i);
                }
                result.result = resultList;
                break;
            case "filterSurname":
                for(int i = 0; i < list.length; i++){
                    if(list[i].split(" ")[1].startsWith(filter)){
                        tempList.add(list[i]);
                    }
                }
                resultList = new String[tempList.size()];
                for(int i = 0; i < tempList.size(); i++){
                    resultList[i] = tempList.get(i);
                }
                result.result = resultList;
                break;
            case "merge":
                ArrayList<String> tempList2 = new ArrayList<>();
                for(int i = 0; i < list.length; i++){
                    tempList2.add(list[i]);
                }
                for(int i = 0; i <list2.length; i++ ){
                    tempList2.add(list2[i]);
                }
                resultList = new String[tempList2.size()];
                for(int i = 0; i < tempList2.size(); i++){
                    resultList[i] = tempList2.get(i);
                }
                result.result = resultList;
                break;
            default:
                result.result = new String[0];
                result.result_description = "Wrong operation";
                return result;
        }
        System.out.println(result.result[0]);
        return result;
    }
}
