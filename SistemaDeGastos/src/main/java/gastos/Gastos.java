package gastos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import BD.connectDAO;
import BD.gastosDAO;

public class Gastos {
    
    Connection con;
    PreparedStatement prepare;

    protected DefaultTableModel modelo = new DefaultTableModel(){

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public void setValueAt(Object aValue, int aRow, int aColumn) {
        try {

            String sql;

            if(aColumn == 0){
                sql = "update gasto set gastos = ? where gastos = ? and dia = ? limit 1";
            }else{
                sql = "update gasto set dia = ? where gastos = ? and dia = ? limit 1";
            }
            
            con = new connectDAO().getConnection();
            prepare = con.prepareStatement(sql);
            prepare.setString(1, (aValue.toString()).replaceAll("[^\\p{Digit}]", ""));
            prepare.setString(2,  this.getValueAt(aRow, 0)+"");
            prepare.setString(3, this.getValueAt(aRow, 1)+"");
            prepare.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        @SuppressWarnings("unchecked")
        Vector<Object> rowVector = dataVector.elementAt(aRow);
        rowVector.setElementAt((aValue.toString()).replaceAll("[^\\p{Digit}]", ""), aColumn);
        fireTableCellUpdated(aRow, aColumn);
        }

        @Override
        public void removeRow(int row){
            //Vector x = dataVector.get(row);
            ArrayList<String> values = new ArrayList<String>();
            values.add(dataVector.elementAt(row).get(0).toString());
            values.add(dataVector.elementAt(row).get(1).toString());
            values.add(dataVector.elementAt(row).get(2).toString());
            values.add(dataVector.elementAt(row).get(3).toString());
            System.out.println(values);
            
            new gastosDAO().removerGastos(values.get(0), values.get(1),values.get(2),values.get(3), userID.getID());
            dataVector.removeElementAt(row);
            fireTableRowsDeleted(row, row);
        }
    };

    public Gastos(){
        this.modelo.addColumn("Tipo");
        this.modelo.addColumn("R$");
        this.modelo.addColumn("Dia");
        this.modelo.addColumn("Mês");
        String sql = "select * from gasto where idconta = ?";
        con = new connectDAO().getConnection();
        

        try {
            prepare = con.prepareStatement(sql);
            prepare.setString(1, userID.getID()+"");
            ResultSet rs = prepare.executeQuery();
            java.sql.ResultSetMetaData rsm = rs.getMetaData();
            int n = rsm.getColumnCount();

            while (rs.next()){
                Vector<String> v = new Vector<>();
                for(int i = 1; i<=n; i++){
                    v.add(rs.getString("tipo"));
                    v.add(rs.getString("gastos"));
                    v.add(rs.getString("dia"));
                    v.add(rs.getString("mes"));
                }
                this.modelo.addRow(v);
            }

            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Gastos(String x){
        this.modelo.addColumn("Tipo");
        this.modelo.addColumn("R$");
        this.modelo.addColumn("Dia");
        this.modelo.addColumn("Mês");
        this.modelo.addColumn("ID");
        String sql = "select * from gasto";
        con = new connectDAO().getConnection();

        try {
            prepare = con.prepareStatement(sql);
            ResultSet rs = prepare.executeQuery();
            java.sql.ResultSetMetaData rsm = rs.getMetaData();
            int n = rsm.getColumnCount();

            while (rs.next()){
                Vector<String> v = new Vector<>();
                for(int i = 1; i<=n; i++){
                    v.add(rs.getString("tipo"));
                    v.add(rs.getString("gastos"));
                    v.add(rs.getString("dia"));
                    v.add(rs.getString("mes"));
                    v.add(rs.getString("idconta"));
                }
                this.modelo.addRow(v);
            }

            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
