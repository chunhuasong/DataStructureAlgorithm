package JavaBasic.thisDemo;

public class thisDemo2 {
    public void m(){
      System.out.println("m");
    }
    public void n(){
        System.out.println("n");
        this.m();//this调用当前类方法
    }

    public static void main(String[] args) {
        new thisDemo2().n();
    }
}
