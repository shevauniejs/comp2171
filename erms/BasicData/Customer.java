package BasicData;

public class Customer extends BasicData{
    private String name;
    private String email;
    private String number;
    private Job job;
    private static int counterStarter = 1000000;

    public Customer(String _name, String _email, String _number){
        super(counterStarter);
        this.name =_name;
        this.email = _email;
        this.number = _number;
        this.id = calcId();
    }

    public Customer(int _id, String _name, String _email, String _number){
        this.name =_name;
        this.email = _email;
        this.number = _number;
        this.id = _id;
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

    public String toString(){
        String str = Integer.toString(id) +" "+name+" "+" "+email+" "+number;
        return str;
    }
}
