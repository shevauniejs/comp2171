package BasicData;
public class Device {
    private String brand;
    private String model;
    private String description;

    public Device(String _brand, String _model, String _descrip){
        this.brand = _brand;
        this.model= _model;
        this.description= _descrip;
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
