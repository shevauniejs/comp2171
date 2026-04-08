package GUI;
public interface GuiFuncProcessor{
    public void addCustomer(); //mainbutton
    public void viewCustomers();
    public void addJobToCustomer(); //context menu option
    public void updateContact(); //context menu option
    //----------------------
    public void viewJobs(); //mainbutton should also alert when window shows
    public void updateStatus(); //context menu option
    public void updateLocation(); //context menu option
    public void addNote(); //context menu option
    //----------------------
    public void generateReport(); //mainbutton
    public void saveData(); //write to DB
}