package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BasicData.Customer;
import Data.CustomerRepo;
import Data.DataMv;

public class CustAdder extends AdderFrame implements DataMv{
    private Customer cs;
    private CustomerRepo csr;
    public CustAdder(int n) {
        super(n);
        this.setTitle("Add Customer");
        this.setBounds(200, 100, 320,240);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addPanel = new JPanel();
        addPanel.setLayout(new GridLayout(n+1,2,3,6));
        lbls.add(new JLabel("Name"));
        lbls.add(new JLabel("Email"));
        lbls.add(new JLabel("Phone number"));
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

    private void createCustomer(){
        String name = txfds.get(0).getText();
        String email  = txfds.get(1).getText();
        String phone = txfds.get(2).getText();
        cs = new Customer(name, email, phone);

    }
    public void storeToDb(){
        //write data to DB
        csr = new CustomerRepo();
        csr.addCustomer(cs);
        JOptionPane.showMessageDialog(this, "Customer added!");
    }

    @Override
    public void writer() {
        // write customer to DB
    }

    @Override
    public void loader() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loader'");
    }
    private class ButtonListener implements ActionListener{
        public void actionPerformed (ActionEvent event){
            if((event.getSource()==save)){
                System.out.println("save Customer");
                createCustomer();
                storeToDb();
            }
        }
    }

}
