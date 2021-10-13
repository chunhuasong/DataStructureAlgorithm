package JavaBasic.InnerClassDemo;

public class InnerClass {
//创建静态成员内部类和非静态成员内部类的对象
    static class Dog{
    }
    class Bird{
    }
    public static void main(String[] args) {
        //静态成员内部类对象
        InnerClass.Dog dog = new InnerClass.Dog();

        //非静态成员内部类对象
        //先建外部类对象，在引用非静态内部类
        InnerClass p = new InnerClass();
        InnerClass.Bird bird = p.new Bird();


    }


}
