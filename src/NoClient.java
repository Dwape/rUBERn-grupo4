import Exceptions.NoClientLoggedExc;

public class NoClient extends AbstractClient{   //todos los metodos iguales >> mejorar

    @Override
    public void addFunds(double amount){
        throw new NoClientLoggedExc();
    }

    @Override
    public void spend(double amount){
        throw new NoClientLoggedExc();
    }

    @Override
    public long getCreditCardNumber(){
        throw new NoClientLoggedExc();
    }

    @Override
    public boolean getStatus(){
        throw new NoClientLoggedExc();
    }

    @Override
    public double getBalance(){
        throw new NoClientLoggedExc();
    }

    @Override
    public void changeStatus(){
        throw new NoClientLoggedExc();
    }

}
