package JavaBasic.gaojileitexing;

public class ConstructorDemo {
    public int student_age;
    public String name;

    public ConstructorDemo(){

    }//无参构造


    public ConstructorDemo(String name,int student_age){
        this.name="wuxie";//构造方法内部赋值优先执行内部的值
        this.student_age=student_age;
    }
    //有参构造

    public static void main(String[] args) {
        ConstructorDemo st = new ConstructorDemo();
        System.out.println(st.name+" "+st.student_age);
        ConstructorDemo st_have = new ConstructorDemo("tom",10);
        System.out.println(st_have.name+" "+st_have.student_age);

    }


}
