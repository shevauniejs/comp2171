package GUI;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BasicData.CreateJob;
import BasicData.Device;
import BasicData.Job;
import Data.DataMv;
import Data.JobRepo;
/**
 * Shows in context menu when right clicked on customer in "view Customer"
 */
public class JobAdder extends AdderFrame implements DataMv, CreateJob{
    private Device device;
    private Job job;
    private JobRepo jRepo;

    public JobAdder(int n) {
            super(n);
            this.setTitle("Add Job");
            this.setBounds(200, 100, 320,500);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            addPanel = new JPanel();
            addPanel.setLayout(new GridLayout(n+1,2,3,6));
            lbls.add(new JLabel("Brand"));
            lbls.add(new JLabel("Model"));
            lbls.add(new JLabel("Description"));
            lbls.add(new JLabel("Location"));
            lbls.add(new JLabel("Status"));
            lbls.add(new JLabel("Notes"));
            lbls.add(new JLabel("Diagnosis"));
            lbls.add(new JLabel("Cost"));
            txfds.add(new JTextField(""));
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
            addPanel.add(save);
            this.add(addPanel);
            this.setVisible(true);
        }
        @Override
        public void createDevice(){
            String brand = txfds.get(0).getText();
            String model = txfds.get(1).getText();
            String Description = txfds.get(2).getText();
            device = new Device(brand, model, Description);
        }
        @Override
        public void createJob(){
            createDevice();
            String location = txfds.get(3).getText();
            String status = txfds.get(4).getText();
            String notes = txfds.get(5).getText();
            String diagnosis = txfds.get(6).getText();
            int cost = Integer.parseInt(txfds.get(7).getText());
            job = new Job(device);
            job.setCost(cost);
            job.setLocation(location);
            job.setStatus(status);
            job.setNotes(notes);
            job.setDiagnosis(diagnosis);
        }
        @Override
        public void writer() {
            // write Job to DB
            jRepo = new JobRepo();
            jRepo.addJob(job);
            JOptionPane.showMessageDialog(this, "Job added!");
        }    
}

