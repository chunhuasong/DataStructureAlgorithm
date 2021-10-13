package JavaBasic.class1;

/**
 *  方法重载示例
 */
public class Overloading {
    public static void main(String [] args){
        int isum;
        double fsum;
        isum=add(3,5);
        System.out.println(isum);
        isum=add(3,5,6);
        System.out.println(isum);
        fsum=add(3.2,6.5);
        System.out.println(fsum);
        isum=add("1","5");
        System.out.println(isum);
    }
    public static int add(int x,int y){
        return x+y;
    }
    public static int add(int x,int y,int z)   {

        return x+y+z;
    }
    public static double add(double x,double y){

        return x+y;
    }
    public static int add(String x,String y){
        int a  = Integer.parseInt(x);
        int b  = Integer.parseInt(y);
        return a * b ;
    }

}
