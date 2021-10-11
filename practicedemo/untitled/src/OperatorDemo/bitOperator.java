package OperatorDemo;

public class bitOperator {
    public static void main(String[] args) {
        int a = 60;
        int b = 13;
        int c = 0;
        c = a & b;

        System.out.println("a="+Integer.toBinaryString(a));
        System.out.println("b="+Integer.toBinaryString(b));
        System.out.println("ab与="+Integer.toBinaryString(c));
        c = a | b;
        System.out.println("ab或="+Integer.toBinaryString(c));
        c = a ^ b;
        System.out.println("ab异或="+Integer.toBinaryString(c));

        c = ~a ;
        System.out.println("非a="+c);
        System.out.println("非a="+Integer.toBinaryString(c));

        c = a << 2;
        System.out.println("a左移2位="+Integer.toBinaryString(c));

        c = a >> 2;
        System.out.println("a右移2位="+Integer.toBinaryString(c));

        c = a >>> 2;
        System.out.println("a右移2位补零="+Integer.toBinaryString(c));

    }
}
