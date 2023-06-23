package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class gastosDAO {
    
    Connection con;
    PreparedStatement prepare;

    public void adicionarGastos(String tipo, String gasto, String dia, String mes, int ID){

        String sql = "insert into gasto (tipo, gastos, dia, mes, idconta) values (?,?,?,?,?)";
        
        con = new connectDAO().getConnection();
        
        try {
            prepare = con.prepareStatement(sql);
            prepare.setString(1, tipo);
            prepare.setString(2, gasto);
            prepare.setString(3, dia);
            prepare.setString(4, mes);
            prepare.setString(5, ID+"");

            prepare.execute();
            prepare.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "gastosDAO" + e);
        }
    }

    public void removerGastos(String tipo, String gasto, String dia, String mes, int iD){
        
        String sql = "delete from gasto where tipo = ? and gastos = ? and dia = ? and mes = ? and idconta = ? limit 1";
        
        con = new connectDAO().getConnection();
        
        try {
            prepare = con.prepareStatement(sql);
            prepare.setString(1, tipo);
            prepare.setString(2, gasto);
            prepare.setString(3, dia);
            prepare.setString(4, mes);
            prepare.setString(5, iD+"");

            prepare.execute();
            prepare.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "gastosDAO" + e);
        }
    }

    public void editarGastos(){
        
    }

}
