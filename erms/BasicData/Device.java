package BasicData;

import java.util.concurrent.ThreadLocalRandom;

public class Device {
    private int idC =2000000;
    private int id;
    private String brand;
    private String model;
    private String description;

    public Device(String _brand, String _model, String _descrip){
        this.brand = _brand;
        this.model= _model;
        this.description= _descrip;
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
    public String getBrand(){
	    return brand;
    }
    public String getModel(){
	    return model;
    }
    public String getDescription(){
	    return description;
    }

    public void setBrand(String brand){
        this.brand=brand;
    }
    public void setModel(String model){
        this.model= model;
    }
    public void setDescription(String Description){
        this.description += description;
    }
}
