package Exception;
import javax.naming.InsufficientResourcesException;
import java.io.*;

public class CheckingAccount {
    private double balance;
    private int number;
    public CheckingAccount (int number)
    {
        this.number=number;
    }

    //存钱
    public void deposit(double amount)
    {
        balance += amount;
    }
    //取钱
    public void withdraw (double amount)
            throws InsufficientFundsException {
        if(amount <= balance)
        {
            balance -= amount;
        }
        else
        {
            double needs = amount - balance;
            throw new InsufficientFundsException(needs);
        }
    }
    //返回余额
    public double getBalance()
    {
        return balance;
    }
    //返回卡号
    public int getNumber() {
        return number;
    }
}
