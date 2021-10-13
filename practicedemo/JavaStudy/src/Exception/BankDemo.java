package Exception;

public class BankDemo {
    public static void main(String[] args) {
        CheckingAccount c =  new CheckingAccount(101);
        System.out.println("Depositing $500");
        c.deposit(500);
        try
        {
            System.out.println("Withdrawing $100");
            c.withdraw(100);
            System.out.println("Withdrawing $600");
            c.withdraw(600);
        }
        catch (InsufficientFundsException e) {
            System.out.println("Sorry, but you are short S"+ e.getAmount());
            e.printStackTrace();
        }
    }
}
