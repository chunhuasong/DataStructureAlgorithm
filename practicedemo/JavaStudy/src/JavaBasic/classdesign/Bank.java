package JavaBasic.classdesign;

public class Bank {
    //练习1：编写一个类，实现银行账户的概念，包含的属性有“帐号”、“密码”、
    //“存款余额”、“利率”、“最小余额”，定义封装这些
    //属性的方法。账号要自动生成。
    //编写主类，使用银行账户类，输入、输出3个储户的上述信息。
    //考虑：哪些属性可以设计成static属性。 Bank.java
    private int account;
    private  String password;
    private double deposit_balance;
    private double min_balance;
    private double interest_rate;
    static int firstaccount=0;
    //account=firstaccount++;
    public int getAccount() {

        return account;
    }

    public static void setFirstaccount(){
        //this.account=account; 错误
    }

    public static void main(String[] args) {
        Bank li= new Bank();

    }
}
