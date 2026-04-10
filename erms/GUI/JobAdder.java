package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BasicData.CreateJob;
import BasicData.Job;
import Data.DataMv;
import Data.JobRepo;
/**
 * Shows in context menu when right clicked on customer in "view Customer"
 */
public class JobAdder extends AdderFrame implements DataMv, CreateJob{
    private Job job;
    private JobRepo jRepo;
    private int customerId;

    public JobAdder(int n, int csID) {
            super(n);
            this.customerId = csID;
            this.setTitle("Add Job");
            this.setBounds(200, 100, 320,500);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            addPanel = new JPanel();
            addPanel.setLayout(new GridLayout(n+1,2,3,6));

            lbls.add(new JLabel("Brand"));
            lbls.add(new JLabel("Description"));
            lbls.add(new JLabel("Diagnosis")); 
            lbls.add(new JLabel("Notes"));           
            lbls.add(new JLabel("Status"));
            lbls.add(new JLabel("Location"));         
            lbls.add(new JLabel("Cost"));

            txfds.add(new JTextField(""));
            txfds.add(new JTextField(""));
            txfds.add(new JTextField(""));
            txfds.add(new JTextField(""));
            txfds.add(new JTextField(""));
            txfds.add(new JTextField(""));
            txfds.add(new JTextField(""));


            for(int x=0; x<n;x++){
                addPanel.add(lbls.get(x));
                addPanel.add(txfds.get(x));
            }
            save.addActionListener(new ButtonListener());
            addPanel.add(save);
            this.add(addPanel);
            this.setVisible(true);
        }

        @Override
        public void createJob(){
            String brand = txfds.get(0).getText();
            String Description = txfds.get(1).getText();
            String diagnosis = txfds.get(2).getText();
            String notes = txfds.get(3).getText();
            String status = txfds.get(4).getText();
            String location = txfds.get(5).getText();           
            int cost = Integer.parseInt(txfds.get(6).getText());
            job = new Job(brand, Description, diagnosis, notes, status, location);
            job.setCost(cost);
        }
        
        @Override
        public void writer() {
            // write Job to DB
            jRepo = new JobRepo();
            jRepo.addJob(job);
            jRepo.addJobToCustomer(customerId, job.getId());
            JOptionPane.showMessageDialog(this, "Job added!");
        }    

        private class ButtonListener implements ActionListener{
        public void actionPerformed (ActionEvent event){
            if((event.getSource()==save)){
                createJob();
                writer();
                //PaymentService payment = new PaymentService(job, )
                //System.out.println("save Customer");
            }
        }
    }

}

