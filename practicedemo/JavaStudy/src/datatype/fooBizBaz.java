package datatype;

public class fooBizBaz {
    public static void main(String[] args) {
        for (int i = 1; i <= 150; i++) {

            if (i % 3 == 0 & i % 5 != 0) {
                System.out.println(i + "foo");
            } else if (i % 3 != 0 & i % 5 == 0) {
                System.out.println(i + "Biz");
            } else if (i % 3 == 0 & i % 5 == 0) {
                System.out.println(i + "foo" + "Biz");
            } else
                System.out.println(i);
        }
    }
}
