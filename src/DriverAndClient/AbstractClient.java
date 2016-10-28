package DriverAndClient;

public abstract class AbstractClient  {
    CreditCard creditCard;
    public boolean isTraveling;

    public AbstractClient(double balance, long creditCardNumber) {
        creditCard = new CreditCard(balance,creditCardNumber);
    }

    public AbstractClient(){}   //Doble constructor para inicializar DriverAndClient.NoClient sin inventar valores

    public abstract void addFunds(double amount);

    public abstract void spend(double amount);

    public abstract long getCreditCardNumber();

    public abstract boolean getStatus();

    public abstract double getBalance();

    public abstract void changeStatus();
}
