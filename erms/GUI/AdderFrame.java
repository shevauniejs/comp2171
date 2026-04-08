package GUI;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class AdderFrame extends JFrame{
    protected JPanel addPanel;
    protected JButton save;
    protected ArrayList<JTextField> txfds;
    protected ArrayList<JLabel> lbls;
    
    public AdderFrame(int n){       
        txfds = new ArrayList<JTextField>(n);
        lbls = new ArrayList<JLabel>(n);
        save = new JButton("SAVE");
    }
}
