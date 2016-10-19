import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by Dwape on 10/19/16.
 */
public class Transaction {

    private String transactionIdentifier;
    private String transactionType;
    private String dateString;
    private long creditCardNumber;
    private String transactionDescription;
    private double transactionAmount;

    private DateTime date;

    public Transaction(String identifier, String type, long cardNumber, String description, double amount){
        transactionIdentifier = identifier;
        transactionType = type;
        creditCardNumber = cardNumber;
        transactionDescription = description;
        transactionAmount = amount;

        date = date.now();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
        String dateString = formatter.print(date);
    }

    public String getTransactionIdentifier(){
        return transactionIdentifier;
    }

    public String getTransactionType(){
        return transactionType;
    }

    public String getDateString(){
        return dateString;
    }

    public long getCreditCardNumber(){
        return creditCardNumber;
    }

    public String getTransactionDescription(){
        return transactionDescription;
    }

    public double getTransactionAmount(){
        return transactionAmount;
    }
}
