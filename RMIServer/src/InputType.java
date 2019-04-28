import java.io.Serializable;

public class InputType implements Serializable {
    private static final long serializableVersionUID = 101L;
    String operation;
    public String[] list;
    public String filter;
    public String[] list2;

    public String[] getlist1(){
        return list;
    }

    public String[] getlist2(){
        return list2;
    }

    public String getfilter(){
        return filter;
    }
}
