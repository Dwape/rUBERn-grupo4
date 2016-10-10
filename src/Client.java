import Exceptions.InvalidAmountExc;

/**
 * Created by Gianni on 10/9/2016.
 */
public class Client {
    private double balance;
    private long creditCardNumber;
    boolean isTraveling;

    public Client(double balance, long creditCardNumber) {
        this.balance = balance;
        this.creditCardNumber = creditCardNumber;
    }

    public void addFunds(double amount){
        if (amount>0){
            balance+=amount;
        }else
            throw new InvalidAmountExc();
    }

    public void spend(double amount){
        if (amount>0&&amount<=balance){
            balance-=amount;
        }else
            throw new InvalidAmountExc();
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public boolean getStatus(){
        return isTraveling;
    }
}
