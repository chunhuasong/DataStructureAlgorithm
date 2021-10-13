package JavaBasic.duotaiDemo;

public class MyDate {
    //MyDate类包含:
    //private成员变量year,month,day ；
    //toDateString()方法返回日期对应的字符串：xxxx年xx月xx日
    private int year;
    private int month;
    private int day;


    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {

    }

    public int getMonth() {
        return month;
    }

    public String toDateString(){
        return (year+"年"+month+"月"+day+"日");
    }
}
