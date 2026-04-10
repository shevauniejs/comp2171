package GUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import BasicData.Customer;
import Data.CustomerRepo;
/**
 * Views customers from DB
 */
public class CustomerViewer extends Viewer implements ContextMenu {
    private JMenuItem addJob;
    private int JBFLD = 6;
    public CustomerViewer(String[] heads) {
        super(heads);
        generateTable();
    }

    /**
     * this method lists the data from DB in a table
     */
    public void generateTable() {
        System.out.println("Generate table");
        table = new JTable(tableMod);     
        loadMenuOptions();
        
        addJob.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    
            }
            @Override
            public void mousePressed(MouseEvent e) {
                table.setSelectionForeground(Color.red);
                JOptionPane.showMessageDialog(table, "CUSTOMER LOADED");
                NonEditTableMod tMod = (NonEditTableMod)table.getModel();

                int customerIdFromTbl = Integer.parseInt(tMod.getValueAt(table.getSelectedRow(), 0).toString());
                addJob(customerIdFromTbl);
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        
        showTable();
    }

    protected void showTable(){
        System.out.println("Show Table");
        CustomerRepo cRepo = new CustomerRepo();
        int counter;
        ArrayList<Customer> lsCus = cRepo.getAllCustomers();
        tableMod.setRowCount(0);
        if (lsCus.size()>0){ //List size must be greater than 0
            for(counter=0;counter<lsCus.size();counter++){            
                addToTable(lsCus.get(counter)); 
                }
            }        
    }
    
    private void addToTable(Customer c){
        System.out.println("add to Table");
        String[] item={Integer.toString(c.getId()),""+c.getName(),""+ c.getEmail(),""+c.getNumber()};
        tableMod.addRow(item); //from the model above, make it a new row        
    }

    @Override
    public void loadMenuOptions() {
        addJob = new JMenuItem("Add job");
        popupMenu.add(addJob);
    } 

    public void addJob(int csId) {
        JobAdderFrame addJ = new JobAdderFrame(JBFLD, csId);
        addJ.setVisible(true);
    }  
}
