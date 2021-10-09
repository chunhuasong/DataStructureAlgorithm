package datatype;

public class Student extends Person{
    public String school;

    public Student(String name, int age,String school) {
        super(name, age);
        this.school=school;
        //super用于子类构造方法中调用父类的方法
    }

    public String getInfo() {  //覆盖方法
//        return  "Name: "+ name + "\nage: "+ age
//                + "\nschool: "+ school;
        return super.getInfo() +" school: " +school;
    }
    public static void main(String[] args) {
        Student student=new Student("haha",12,"ucl");
        //student.school="ucl";
        System.out.println(student.getInfo());
    }
}
