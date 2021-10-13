package JavaBasic.gaojileitexing;


    abstract class A{
        abstract void m1();
        public void m2(){
            System.out.println("A类中定义的m2方法");
        }
    }
    class B extends A{
        void m1(){
            System.out.println("B类中定义的m1方法");
        }
    }
    public class chouxiang{
        public static void main(String[] args) {
            A c=new B();
            //A d=new A(); 报错
            c.m1();
            c.m2();
        }
    }

