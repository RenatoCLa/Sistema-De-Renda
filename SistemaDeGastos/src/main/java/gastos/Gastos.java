package gastos;

import javax.swing.table.DefaultTableModel;

public class Gastos {
    
    protected DefaultTableModel modelo = new DefaultTableModel();

    public Gastos(){
        this.modelo.addColumn("Gastos(R$)");
        this.modelo.addColumn("Dia");
    }

    public void setModelo(DefaultTableModel x){
        this.modelo = x;
    }

    public void addModeloRow(String x, String y){
        this.modelo.insertRow(0, new Object[]{x,y});
    }

    public void deleteModeloRow(int x){
        this.modelo.removeRow(x);
    }

    public int getRowQuant(){
        return this.modelo.getRowCount();
    }

    public int calcularQuant(int x, int x1){
        int y = Integer.parseInt(this.modelo.getValueAt(x,x1)+"");
        return y;
    }
}
