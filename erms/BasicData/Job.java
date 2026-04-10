package BasicData;

import java.util.concurrent.ThreadLocalRandom;

public class Job{
    private int idC = 3000000;
    private int id;
    private String brand;
    private String description;
    private float cost;
    private float amountPaid;
    private String location;
    private String diagnosis;
    private String status;
    private String notes;
    

    public Job(String brand, String description, String diagnosis, String notes, String status,
            String location){
        this.brand = brand;
        this.description = description;
        this.diagnosis = diagnosis;
        this.notes = notes;
        this.status = status;
        this.location = location;
        this.id = calcId();
    }

    public Job(int id, String brand, String description, String diagnosis, String notes, String status,
            String location) {
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.diagnosis = diagnosis;
        this.notes = notes;
        this.status = status;
        this.location = location;
    }

    private int calcId(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int rand = random.nextInt(0+1, 10000);
        return idC+ rand;
    }

    public int getId(){
        return this.id;
    }
    public String getBrand(){
	    return brand;
    }

    public String getDescription(){
	    return description;
    }

    public float getCost(){
    	return cost;
    }
    public String getLocation(){
        return location;
    }
    public String getStatus(){
	    return status;
    }
    public String getDiagnosis(){
	    return diagnosis;
    }
    public String getNotes(){
	    return notes;
    }
    public float getAmountPaid(){
        return amountPaid;
    }

    public void setCost(float cost){
        this.cost= cost;
    }
    public void setLocation(String location){
        this.location= location;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setDiagnosis(String diagnosis){
        this.diagnosis= diagnosis;
    }
    public void setNotes(String note){
        this.notes+= note;
    }       

    public void setAmountPaid(float amountPaid){
        this.amountPaid = amountPaid;
    }

    public void setBrand(String brand){
        this.brand=brand;
    }

    public void setDescription(String Description){
        this.description += description;
    }
}
