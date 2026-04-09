package BasicData;

import java.util.concurrent.ThreadLocalRandom;

public class Job{
    private int idC = 3000000;
    private int id;
    private Device device;
    private float cost;
    private String location;
    private String diagnosis;
    private String status;
    private String notes;

    public Job(Device dev){
        this.device = dev;
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
    public Device getDevice(){
	    return device;
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

    public void setDevice(Device device){
        this.device = device;
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
}
