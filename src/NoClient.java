import Exceptions.NoClientLoggedExc;

public class NoClient extends AbstractClient{   //todos los metodos iguales >> mejorar

    public void addFunds(double amount){
        throw new NoClientLoggedExc();
    }

    public void spend(double amount){
        throw new NoClientLoggedExc();
    }

    public long getCreditCardNumber(){
        throw new NoClientLoggedExc();
    }

    public boolean getStatus(){
        throw new NoClientLoggedExc();
    }

    public double getBalance(){
        throw new NoClientLoggedExc();
    }

    public void changeStatus(){
        throw new NoClientLoggedExc();
    }

}
