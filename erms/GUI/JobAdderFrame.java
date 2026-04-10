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
import Payment.StartPaymentProcessor;
/**
 * Shows in context menu when right clicked on customer in "view Customer"
 */
public class JobAdderFrame extends AdderFrame implements DataMv, CreateJob, StartPaymentProcessor{
    private Job job;
    private JobRepo jRepo;
    private int customerId;
    private int PAF = 2;

    public JobAdderFrame(int n, int csID) {
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
            job = new Job(brand, Description, diagnosis, notes, status, location);
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
                startPaymentProcess();
                System.out.println("save Customer, starting payment processor");
            }
        }
    }

        @Override
        public void startPaymentProcess() {
            PaymentAdderFrame paymentFrame = new PaymentAdderFrame(PAF,job.getId());
            paymentFrame.setVisible(true);
        }

}

