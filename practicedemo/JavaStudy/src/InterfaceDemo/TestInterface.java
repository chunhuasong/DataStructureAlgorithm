package InterfaceDemo;

public class TestInterface {
    public static void main(String[] args) {
        ComparableCircle c1=new ComparableCircle(3);
        ComparableCircle c2=new ComparableCircle(2);
        System.out.println(c2.getRadius());
        System.out.println(c2.getR());
        System.out.println(c1.getRadius());
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
