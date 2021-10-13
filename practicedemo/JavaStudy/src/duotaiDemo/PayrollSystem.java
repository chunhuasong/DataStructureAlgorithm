package duotaiDemo;

import java.util.Calendar;
import java.util.Scanner;

//定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各
//类雇员对象的引用。利用循环结构遍历数组元素，输出各个对象的类
//型,name,number,birthday,以及该对象生日。当键盘输入本月月份值时，如果本
//月是某个Employee对象的生日，还要输出增加工资信息。
public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] e = new Employee[2];
        e[0] = new SalariedEmployee("bob",20,new MyDate(1998,6,7),10000);
        e[1] = new HourlyEmployee("TOM",30,new MyDate(1998,10,4),90,8);

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入当前月份");
//        int month = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH)+1;




        for(int i = 0; i<e.length;i++){
            System.out.println(e[i]);
            System.out.println("月薪：" + e[i].earnings());
            if(month == e[i].getBirthday().getMonth())
            {
                System.out.println("生日多给100  " + "月薪:" + (e[i].earnings()+100) );
            }

        }
    }




}
