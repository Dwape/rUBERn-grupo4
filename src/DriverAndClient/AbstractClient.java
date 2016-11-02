package DriverAndClient;

public abstract class AbstractClient  {
    CreditCard creditCard;
    protected String name;
    protected boolean isTraveling;

    public AbstractClient(double balance, long creditCardNumber, String name) {
        creditCard = new CreditCard(balance,creditCardNumber);
        this.name = name;
    }

    public AbstractClient(){}   //Doble constructor para inicializar DriverAndClient.NoClient sin inventar valores

    public abstract void addFunds(double amount);

    public abstract void spend(double amount);

    public abstract long getCreditCardNumber();

    public abstract boolean getStatus();

    public abstract double getBalance();

    public abstract void changeStatus();

    public abstract String getName();
}
