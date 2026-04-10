package BasicData;

import java.time.LocalDate;

public class Transaction extends BasicData{
    private  static int counterStart = 40000000;
    private LocalDate date;
    private float amountPaid;
    private float jobCost;
    private float balance;

    public Transaction(float jobCost, float amountPaid){
        super(counterStart);
        date = LocalDate.now();
        this.jobCost = jobCost;
        this.amountPaid = amountPaid;
    }

    public Transaction(int id, LocalDate date, float amountPaid, float cost, float balance){
        this.date = date;
        this.amountPaid = amountPaid;
        this.jobCost = cost;
        this.amountPaid = amountPaid;
        this.balance = balance;
    }

    public float getCost(){
        return this.jobCost;
    }
    public void setCost(float paid){
        this.amountPaid = paid;
    }

    public float getPaid(){
        return this.amountPaid;
    }
    public void setPaid(float paid){
        this.amountPaid = paid;
    }

    public void setBalance(float balance){
        this.balance = balance;
    }

    public float getBalance(){
        return this.balance;
    }
    public LocalDate getDate(){
        return date;
    }

    public void setDate(){
        date = LocalDate.now();
    }
}
