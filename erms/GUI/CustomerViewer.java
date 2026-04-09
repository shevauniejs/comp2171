package GUI;

import java.util.ArrayList;

import javax.swing.JTable;

import BasicData.Customer;
import Data.CustomerRepo;

public class CustomerViewer extends Viewer {

    public CustomerViewer(String[] heads) {
        super(heads);
        generateTable();
    }

    public void generateTable() {
        System.out.println("Generate table");
        table = new JTable(tableMod);
        showTable();
    }

    protected void showTable(){
        System.out.println("Show Table");
        CustomerRepo cRepo = new CustomerRepo();
        int counter;
        ArrayList<Customer> lsCus = cRepo.getCustomers();
        
        if (lsCus.size()>0){ //List size must be greater than 0
            for(counter=0;counter<lsCus.size();counter++){            
                addToTable(lsCus.get(counter)); 
                }
            }        
    }
    protected void addToTable(Customer c){
        System.out.println("add to Table");
        String[] item={Integer.toString(c.getId()),""+c.getName(),""+ c.getEmail(),""+c.getNumber()};
        tableMod.addRow(item); //from the model above, make it a new row        
    }    
    
}
