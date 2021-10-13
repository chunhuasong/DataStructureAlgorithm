package JavaBasic.duotaiDemo;

//编写工资系统，实现不同类型员工(多态)的按月发放工资。如果当月出现某个
//Employee对象的生日，则将该雇员的工资增加100元。
public abstract class Employee {

    //（1）定义一个Employee类，该类包含：
    //private成员变量name,number,birthday，其中birthday 为MyDate类的对象；
    //abstract方法earnings()；
    //toString()方法输出对象的name,number和birthday。

    private String name;
    private int number;
    private MyDate birthday = new MyDate();

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public abstract double earnings();

    public MyDate getBirthday() {
        return birthday;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday.toDateString() +
                '}';
    }
}
