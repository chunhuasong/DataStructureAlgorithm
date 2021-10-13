package JavaBasic.duotaiDemo;

public class SalariedEmployee extends Employee {

    //定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处
    //理。该类包括：private成员变量monthlySalary；
    //实现父类的抽象方法earnings(),该方法返回monthlySalary值；toString()方法输
    //出员工类型信息及员工的name，number,birthday。

    private double monthlySalary;

    @Override
    public double earnings() {
        return monthlySalary;
    }

    public SalariedEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" + super.toString() + "}";
    }
}
