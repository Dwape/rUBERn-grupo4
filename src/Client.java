import Exceptions.InvalidAmountExc;

/**
 * Created by Gianni on 10/9/2016.
 */
public class Client extends AbstractClient{

    public Client(double balance, long creditCardNumber) {
        super(balance, creditCardNumber);
    }

    @Override
    public void addFunds(double amount){
        if (amount>0){
            balance+=amount;
        }else
            throw new InvalidAmountExc();
    }

    @Override
    public void spend(double amount){
        if (amount>0&&amount<=balance){
            balance-=amount;
        }else
            throw new InvalidAmountExc();
    }

    @Override
    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    @Override
    public boolean getStatus(){
        return isTraveling;
    }

    @Override
    public double getBalance(){
        return balance;
    }

    @Override
    public void changeStatus(){
        isTraveling = !isTraveling;
    }
}
