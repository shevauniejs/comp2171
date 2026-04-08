import GUI.Gui;

public class Driver {
    public static Gui gui = null;
    public static void main(String[] args) {
        gui = new Gui();
        gui.setVisible(true);
    }
}
