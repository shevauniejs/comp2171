package BasicData;

import java.util.concurrent.ThreadLocalRandom;

public class Customer {
    private String name;
    private String email;
    private String number;
    private Job job;
    private int idC = 10000000;
    private int id;

    public Customer(String _name, String _email, String _number){
        this.name =_name;
        this.email = _email;
        this.number = _number;
        this.id = calcId();
    }

    private int calcId(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int rand = random.nextInt(0+1, 10000);
        return idC+ rand;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getNumber(){
        return number;
    }
    public Job getJob(){
        return job;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public void setJob(Job job){
        this.job = job;
    }
}
