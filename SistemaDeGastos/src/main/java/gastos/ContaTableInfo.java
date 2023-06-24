package gastos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import BD.connectDAO;

public class ContaTableInfo {
    
    Connection con;
    PreparedStatement prepare;

    protected DefaultTableModel modelo = new DefaultTableModel(){

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
        
    };

    public ContaTableInfo(){
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


}
