package DriverAndClient;

import Exceptions.InvalidAmountExc;

public class CreditCard {
    double balance;
    long creditCardNumber;

    public CreditCard(double balance, long creditCardNumber) {
        this.balance = balance;
        this.creditCardNumber = creditCardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void addFunds(double balance){
        if (balance>0){
            this.balance += balance;
        }else
            throw new InvalidAmountExc();
    }

    public void spend(double amount){
        balance-=amount;
    }
}
