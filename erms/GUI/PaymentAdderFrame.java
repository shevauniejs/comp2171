package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Payment.PaymentService;
import Payment.StartPaymentProcessor;

public class PaymentAdderFrame extends AdderFrame implements StartPaymentProcessor{
    private int jobId;
    private PaymentService paymentService;

    public PaymentAdderFrame(int n, int jobId) {
        super(n);
        this.jobId = jobId;
        this.setTitle("Payment");
        this.setBounds(200, 100, 215,100);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addPanel = new JPanel();
        addPanel.setLayout(new GridLayout(n+1,2,3,6));

        lbls.add(new JLabel("Job Cost"));
        lbls.add(new JLabel("Amount Paid"));

        txfds.add(new JTextField(""));
        txfds.add(new JTextField(""));
        save = new JButton("Process Payment");
        save.addActionListener(new ButtonListener());

        for(int x=0; x<n; x++){
            addPanel.add(lbls.get(x));
            addPanel.add(txfds.get(x));
        }

        addPanel.add(save);
        this.add(addPanel);
        this.setVisible(true);
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed (ActionEvent event){
            if((event.getSource()==save)){
                startPaymentProcess();
                System.out.println("save Customer, starting payment processor");
            }
        }
    }

    @Override
    public void startPaymentProcess() {
        float cost = Float.parseFloat(txfds.get(0).getText());
        float amountPaid = Float.parseFloat(txfds.get(1).getText());
        paymentService = new PaymentService(jobId, cost, amountPaid);
    }
}
