package GUI;

import java.util.ArrayList;
import javax.swing.JTable;

import BasicData.Job;
import Data.JobRepo;

public class JobViewer extends Viewer{
    private JobRepo jRepo;
    public JobViewer(String[] heads) {
        super(heads);
         jRepo = new JobRepo();
        generateTable();
        //TODO Auto-generated constructor stub
    }

    @Override
    protected void generateTable() {

        System.out.println("Generate table");
        table = new JTable(tableMod);     
        //loadMenuOptions();

        /*table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        */
        showTable();
    }

    @Override
    protected void showTable() {
        System.out.println("Show Table");
        
        int counter;
        ArrayList<Job> lsCus = jRepo.getJobs();
        tableMod.setRowCount(0);
        if (lsCus.size()>0){ //List size must be greater than 0
            for(counter=0;counter<lsCus.size();counter++){            
                addToTable(lsCus.get(counter)); 
                }
            }  
    }

    private void addToTable(Job j){
        System.out.println("add to Table");
        String[] item={Integer.toString(j.getId()),""+j.getBrand(),""+ j.getDescription(),""+j.getDiagnosis(),""+j.getNotes(),""+j.getStatus(),""+j.getLocation()};
        tableMod.addRow(item); //from the model above, make it a new row        
    }
    
}
