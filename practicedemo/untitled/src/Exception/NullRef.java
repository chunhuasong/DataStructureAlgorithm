package Exception;

public class NullRef{
    int i=1;
    public static void main(String[] args) {
        NullRef t=new NullRef();
        t=null;
        System.out.println(t.i);
    }
}