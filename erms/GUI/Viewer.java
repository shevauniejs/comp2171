package GUI;

import javax.swing.JTable;

public abstract class Viewer {
    protected NonEditTableMod tableMod;
    protected JTable table;
    protected String [] columnHeads;

    public Viewer(String[] heads){
        this.columnHeads = heads;
        this.tableMod = new NonEditTableMod(columnHeads, 0);
    }

    protected abstract void generateTable();
    protected abstract void showTable();
    protected JTable getTable(){
        return table;
    }
}
