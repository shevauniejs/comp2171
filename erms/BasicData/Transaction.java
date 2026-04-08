package BasicData;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime date;
    private int transactionId;
    private double amountPaid;
    private double balance;

    public Transaction(Job job){
        date = LocalDateTime.now();
        this.balance = job.getCost()-amountPaid;
    }
 
    public int getTransId(){
        return transactionId;
    }
    
    public void setTransId(int t_id){
        transactionId = t_id;
    }

    public double getPaid(){
        return this.amountPaid;
    }
    public void setPaid(double paid){
        this.amountPaid = paid;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }
    public LocalDateTime getDate(){
        return date;
    }
}
