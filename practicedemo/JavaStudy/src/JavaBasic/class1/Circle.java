package JavaBasic.class1;

public class Circle {
    public int r;
    public double S;
    public void setR(int a){
        r=a;
    }
    public double calcuS(){
        S= (Math.PI*r*r);
        return S;
    }

    public static void main(String[] args) {
        Circle yuan=new Circle();
        yuan.setR(1);
        double S=yuan.calcuS();
        System.out.println(S);
    }
}
