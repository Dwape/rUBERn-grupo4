import Exceptions.InvalidAmountExc;

/**
 * Created by Gianni on 10/9/2016.
 */
public class Client {
    private double balance;
    private double creditCardNumber;

    public Client(double balance, double creditCardNumber) {
        this.balance = balance;
        this.creditCardNumber = creditCardNumber;
    }

    public void addFunds(double amount){
        if (amount>0){
            balance+=amount;
        }else
            throw new InvalidAmountExc();
    }
}
