package gastos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import BD.connectDAO;
import BD.gastosDAO;

public class Gastos {
    
    private gastosDAO g = new gastosDAO();
    protected DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };

    public Gastos(){
        this.modelo.addColumn("Gastos(R$)");
        this.modelo.addColumn("Dia");
        String sql = "select * from gasto where idconta = ?";
        Connection con = new connectDAO().getConnection();
        PreparedStatement prepare;

        try {
            prepare = con.prepareStatement(sql);
            prepare.setString(1, userID.getID()+"");
            ResultSet rs = prepare.executeQuery();
            java.sql.ResultSetMetaData rsm = rs.getMetaData();
            int n = rsm.getColumnCount();

            while (rs.next()){
                Vector v = new Vector();
                for(int i = 1; i<=n; i++){
                    v.add(rs.getString("gastos"));
                    v.add(rs.getString("dia"));
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
