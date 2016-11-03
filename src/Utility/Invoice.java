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
            System.out.print(transactions.get(i).getTransactionIdentifier()+"\t");
            System.out.print(transactions.get(i).getTransactionType()+"\t"+"\t");
            System.out.print(transactions.get(i).getDateString()+"\t"+"\t");
            System.out.print("Credit card: "+transactions.get(i).getCreditCardNumber()+"\t"+"\t");
            System.out.print("Transaction amount: "+transactions.get(i).getTransactionAmount()+"\t"+"\t");
            System.out.println("");
            System.out.print("\n"+"*****************************************************************************************************************************"+"\n");
            System.out.println("");
            if ((i+1)%3==0 ){
                System.out.print("");
                Scanner.getChar("Enter any character to continue: "+"\t");
                System.out.print("");
            }
        }
    }
}
