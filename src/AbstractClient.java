
public abstract class AbstractClient  {
    public double balance;
    public long creditCardNumber;
    public boolean isTraveling;

    public AbstractClient(double balance, long creditCardNumber) {
        this.balance = balance;
        this.creditCardNumber = creditCardNumber;
    }

    public AbstractClient(){}   //Doble constructor para inicializar NoClient sin inventar valores

    public abstract void addFunds(double amount);

    public abstract void spend(double amount);

    public abstract long getCreditCardNumber();

    public abstract boolean getStatus();

    public abstract double getBalance();

    public abstract void changeStatus();
}
