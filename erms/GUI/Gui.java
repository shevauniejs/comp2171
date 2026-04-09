package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Gui extends JFrame implements GuiFuncProcessor{
    private JFrame UI = this;
    private JScrollPane scrollPane;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel mainPanel;

    private JButton addCustomer;
    private JButton viewCustomer;
    private JButton viewJob;
    private JButton generateReport;

    private int JBFLD = 7;
    private int CSFLD = 3;

    //protected JLabel statLabel;


    public Gui(){
        UI.setTitle("Electronic Repair MS");
        UI.setDefaultCloseOperation(EXIT_ON_CLOSE);
        UI.setPreferredSize(new Dimension(1024,720)); //frame size
        
        leftPanel = new JPanel(new GridLayout(4,1,0,5)); //left side has options to add job etc
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        leftPanel.setPreferredSize(new Dimension(300,400));
        
        rightPanel = new JPanel(new GridLayout(2,1,0,10)); //right side shows details and fields
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        rightPanel.setPreferredSize(new Dimension(650,400));
        rightPanel.setBackground(Color.gray);

        ButtonListener coreListener = new ButtonListener();
        addCustomer = new JButton("ADD Customer");
        addCustomer.addActionListener(coreListener);

        viewCustomer = new JButton("View Customers");
        viewCustomer.addActionListener(coreListener);

        viewJob = new JButton("VIEW Jobs");
        viewJob.addActionListener(coreListener);
        
        generateReport = new JButton("GENERATE Reports");
        generateReport.addActionListener(coreListener);
        
        
        addCustomer.setPreferredSize(new Dimension(50,20));
        viewJob.setPreferredSize(new Dimension(50,20));
        generateReport.setPreferredSize(new Dimension(50,20));
        
        leftPanel.add(addCustomer);
        leftPanel.add(viewCustomer);
        leftPanel.add(viewJob);
        leftPanel.add(generateReport);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.GRAY);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        UI.getContentPane().add(mainPanel);
        
        UI.pack();
    }

    
    private class ButtonListener implements ActionListener{
        public void actionPerformed (ActionEvent event){
            if((event.getSource()==addCustomer)){
                System.out.println("Add Customer");
                addCustomer();
            }
            if(event.getSource()==viewCustomer){
                System.out.println("View Customer");
                viewCustomers();
            }  
            if(event.getSource()==viewJob){
                System.out.println("View Job");
            }            
            if(event.getSource()==generateReport){
                System.out.println("Generate report");
            }
        }
    }


    
    public void addCustomer() {
        CustAdder addcs = new CustAdder(CSFLD);
        addcs.setVisible(true);
    }

    public void viewCustomers(){
        String [] theads = {"ID", "Name","Email","Number"};
        CustomerViewer viewCs = new CustomerViewer(theads);
        rightPanel.removeAll();
        scrollPane = new JScrollPane(viewCs.getTable());
        rightPanel.add(scrollPane);
        rightPanel.updateUI();
    }
    
    public void addJobToCustomer() {
        JobAdder addcs = new JobAdder(JBFLD);
        addcs.setVisible(true);
    }


    public void updateContact() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateContact'");
    }


    public void viewJobs() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewJobs'");
    }


    public void updateStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStatus'");
    }


    public void updateLocation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateLocation'");
    }


    public void addNote() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addNote'");
    }


    public void generateReport() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateReport'");
    }


    public void saveData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveData'");
    }
}
