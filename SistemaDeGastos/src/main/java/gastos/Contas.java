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

public class Contas {
    
    Connection con;
    PreparedStatement prepare;

    protected DefaultTableModel modelo = new DefaultTableModel(){

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        
    };

    public Contas(){
        this.modelo.addColumn("ID");
        this.modelo.addColumn("Usuario");
        this.modelo.addColumn("Senha");
        String sql = "select * from conta";
        con = new connectDAO().getConnection();
        

        try {
            prepare = con.prepareStatement(sql);
            ResultSet rs = prepare.executeQuery();
            java.sql.ResultSetMetaData rsm = rs.getMetaData();
            int n = rsm.getColumnCount();

            while (rs.next()){
                Vector<String> v = new Vector<>();
                for(int i = 1; i<=n; i++){
                    v.add(rs.getString("ID"));
                    v.add(rs.getString("user"));
                    v.add(rs.getString("pass"));
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
