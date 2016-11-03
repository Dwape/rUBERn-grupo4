package Utility;

import java.util.ArrayList;

/**
 * Created by Gianni on 10/9/2016.
 */
public class Invoice {
    private ArrayList<Transaction> transactions;

    public Invoice(){
        transactions = new ArrayList<>();
    }

    public void add(Transaction newTransaction){
        transactions.add(newTransaction);
    }

    public void print(){
        for (int i =0; i<transactions.size(); i++){
            System.out.println(transactions.get(i).getTransactionIdentifier());
            System.out.println(transactions.get(i).getTransactionType());
            System.out.println(transactions.get(i).getDateString());
            System.out.println("Credit card: "+transactions.get(i).getCreditCardNumber());
            System.out.println("Transaction amount: "+transactions.get(i).getTransactionAmount());
            System.out.println("\n"+"***********************************************************"+"\n");
            System.out.println("");
            Scanner.getChar("Enter any character to continue: ");
            System.out.println("");
        }
    }
}
