import Exceptions.InvalidAmountExc;

/**
 * Created by Gianni on 10/9/2016.
 */
public class Client extends AbstractClient{

    public Client(double balance, long creditCardNumber) {
        super(balance, creditCardNumber);
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

    public double getBalance(){
        return balance;
    }

    public void changeStatus(){
        isTraveling = !isTraveling;
    }
}
