package datatype;

public class ifpaixu {
    public static void main(String[] args) {
        int num1=10;
        int num2=2;
        int num3=3;
        int min,max;
        int mid = 0;
        int tmp;
        if (num1>num2)
        {
            tmp=num1;
            num1=num2;
            num2=tmp;
        }
        if (num1>num3)
        {
            tmp=num1;
            num1=num3;
            num3=tmp;
        }
        if (num2>num3)
        {
            tmp=num2;
            num2=num3;
            num3=tmp;
        }
      /*  穷举
        if(num1<num2 & num1<num3)
            min=num1;
        else if (num2<num1 & num2<num3)
            min=num2;
        else
            min=num3;
        if (num1>num2 & num1>num3)
            max=num1;
        else if (num2>num1 & num2>num3)
            max=num2;
        else
            max=num3;
        if (max==num2 & min==num3 | max==num3 & min==num2)
            mid=num1;
        if (max==num1 & min==num3 | max==num3 & min==num1)
            mid=num2;
        if (max==num2 & min==num1 | max==num1 & min==num2)
            mid=num3;
        System.out.println(min);
        System.out.println(mid);
        System.out.println(max); */
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }
}
