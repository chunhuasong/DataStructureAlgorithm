package Exception;
import java.io.*;
public class InsufficientFundsException extends Throwable {
    private double amount;//取出的钱多于余额时所缺乏的钱
    public InsufficientFundsException(double amount)
    {
        this.amount = amount;
    }
    public double getAmount()
    {
        return amount;
    }
}
