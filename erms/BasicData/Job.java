package BasicData;
public class Job{
    private Device device;
    private float cost;
    private String location;
    private String diagnosis;
    private String status;
    private String notes;

    public Job(Device dev){
        this.device = dev;
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
