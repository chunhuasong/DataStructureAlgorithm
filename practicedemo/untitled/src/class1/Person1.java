package class1;

public class Person1 {
    //创建程序,在其中定义两个类，Person和
    //TestPerson类的定义如下。用setAge()设置人的合法年龄
    //(0~130)，用getAge()返回人的年龄。在Test类中实例化
    //Person类的对象b，调用setAge()和getAge()方法，体会
    //Java的封装性。
    private int age;

    public void setAge(int age) {
        if(age<=130 & age>=0)
        this.age = age;
        else
        {System.out.println("年龄异常");
        return;}

    }


    public int getAge() {
        return age;
    }
}



