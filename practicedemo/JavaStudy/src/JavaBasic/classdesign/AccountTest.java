package JavaBasic.classdesign;

public class AccountTest {

    public static void main(String[] args) {

        Account acct1 = new Account();
        Account acct2 = new Account("qwerty", 5000);

        Account.setInterestRate(0.012);
        Account.setMinBalance(100);

        System.out.println(acct1);
        System.out.println(acct2);

        System.out.println(Account.getInterestRate());
        System.out.println(Account.getMinBalance());


    }
}

class Account {

    private int id;
    private String pwd = "000000";
    private double balance;

    private static double interestRate;
    private static double minBalance = 1.0;
    private static int init = 1001;

    public Account() {
        this.id = init++;
    }
    //Account 自动生成

    public Account(String pwd, double balance) {
        this.id = init++;
        this.pwd = pwd;
        this.balance = balance;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public static double getMinBalance() {
        return minBalance;
    }

    public static void setMinBalance(double minBalance) {
        Account.minBalance = minBalance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", pwd=" + pwd + ", balance=" + balance + "]";
    }


}


