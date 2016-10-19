import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * Created by Gianni on 10/9/2016.
 */
public class Invoice {
    private ArrayList<Transaction> transactions;

    public Invoice(){
        transactions = new ArrayList<>();
    }

    public void print(){
        for (int i =0; i<transactions.size(); i++){
            System.out.println(transactions.get(i).getTransactionIdentifier());
            System.out.println(transactions.get(i).getTransactionType());
            System.out.println(transactions.get(i).getDateString());
            System.out.println(transactions.get(i).getCreditCardNumber());
            System.out.println(transactions.get(i).getTransactionDescription());
            System.out.println(transactions.get(i).getTransactionAmount());
            System.out.println("\n"+"***********************************************************"+"\n");
        }
    }
}
