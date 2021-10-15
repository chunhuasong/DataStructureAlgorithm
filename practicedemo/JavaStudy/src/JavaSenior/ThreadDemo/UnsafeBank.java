package JavaSenior.ThreadDemo;



//不安全取钱
//两个人去银行取钱，账户有100万，你们两看见都是100万都可以取，
//但是一操作后就会出现负数，造成不安全的取钱。
//线程的内存都是各自的，互不影响，都是从原来的地方拷贝过去的。

public class UnsafeBank {
    public static void main(String[] args) {
        //账户
        BankAccount bankAccount = new BankAccount(100, "结婚基金");

        Drawing you = new Drawing(bankAccount, 50, "你");
        Drawing girlFriend = new Drawing(bankAccount, 100, "girlFriend");

        you.start();
        girlFriend.start();

    }
}


//账户
class BankAccount {
    int money;//余额
    String name;//卡名

    public BankAccount(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行：模拟取款
class Drawing extends Thread {

    //账户
    BankAccount bankAccount;
    //取了多少钱
    int drawingMoney;
    //现在手里有多少钱
    int nowMoney;

    public Drawing(BankAccount bankAccount, int drawingMoney, String name) {
        super(name);
        this.bankAccount = bankAccount;
        this.drawingMoney = drawingMoney;
    }

    //取钱

    @Override
    public void run() {

        //判断有没有钱
        if (bankAccount.money - drawingMoney < 0) {
            System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
            return;
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //卡内余额 = 余额 - 你取得钱
        bankAccount.money = bankAccount.money - drawingMoney;
        //你手里的钱
        nowMoney = nowMoney + drawingMoney;

        System.out.println(bankAccount.name + "余额为：" + bankAccount.money);
        //Thread.currentThread().getName() = this.getName()
        System.out.println(this.getName() + "手里的钱：" + nowMoney);

    }
}


