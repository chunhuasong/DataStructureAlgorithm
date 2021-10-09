package InterfaceDemo;

public class TestInterface {
    public static void main(String[] args) {
        ComparableCircle c1=new ComparableCircle(3);
        ComparableCircle c2=new ComparableCircle(4);
        int compareValue = c1.compareTo(c2);
        if( compareValue > 0) {
            System.out.println("c1对象大");
        }else if(compareValue < 0) {
            System.out.println("c2对象大");
        }else {
            System.out.println("c1与c2一样大");
        }

    }
}
