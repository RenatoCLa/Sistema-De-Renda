package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class gastosDAO {
    
    Connection con;
    PreparedStatement prepare;

    public void adicionarGastos(String gasto, String dia, int ID){

        String sql = "insert into gasto (gastos, dia, idconta) values (?,?,?)";
        
        con = new connectDAO().getConnection();
        
        try {
            prepare = con.prepareStatement(sql);
            prepare.setString(1, gasto);
            prepare.setString(2, dia);
            prepare.setString(3, ID+"");

            prepare.execute();
            prepare.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "gastosDAO" + e);
        }
    }

    public void removerGastos(String gasto, String dia, int iD){
        
        String sql = "delete from gasto where gastos = ? and dia = ? and idconta = ? limit 1";
        
        con = new connectDAO().getConnection();
        
        try {
            prepare = con.prepareStatement(sql);
            prepare.setString(1, gasto);
            prepare.setString(2, dia);
            prepare.setString(3, iD+"");

            prepare.execute();
            prepare.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "gastosDAO" + e);
        }
    }

}
