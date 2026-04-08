package GUI;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Data.DataMv;
/**
 * Shows in context menu when right clicked on customer in "view Customer"
 */
public class JobAdder extends AdderFrame implements DataMv{

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
        addPanel.add(save);
        this.add(addPanel);
        this.setVisible(true);
    }

    @Override
    public void writer() {
        // write Job to DB
    }

    @Override
    public void loader() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loader'");
    }
    
}

