package DriverAndClient;

public class Client extends AbstractClient {

    public Client(double balance, long creditCardNumber) {
        super(balance, creditCardNumber);
    }

    public void addFunds(double amount){
        creditCard.addFunds(amount);
    }

    public void spend(double amount){
        creditCard.spend(amount);
    }

    public long getCreditCardNumber() {
        return creditCard.getCreditCardNumber();
    }

    public boolean getStatus(){
        return isTraveling;
    }

    public double getBalance(){
        return creditCard.getBalance();
    }

    public void changeStatus(){
        isTraveling = !isTraveling;
    }
}
