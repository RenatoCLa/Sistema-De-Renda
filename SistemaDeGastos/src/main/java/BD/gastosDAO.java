package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public void editarGastos(String tipo, String gastos, String dia, String mes, String ID){
        String slq = "update gasto set tipo = ?, gastos = ?, dia = ?, mes = ? where ID = ?";

        con = new connectDAO().getConnection();

        try {
            prepare = con.prepareStatement(slq);
            prepare.setString(1, tipo);
            prepare.setString(2, gastos);
            prepare.setString(3, dia);
            prepare.setString(4, mes);
            prepare.setString(5, ID);

            prepare.executeUpdate();
            prepare.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "editarGastosDAO" + e);
        }
    }

    public String getID(String tipo, String gastos, String dia, String mes){

        String slq = "select ID from gasto where tipo = ? and gastos = ? and dia = ? and mes = ?";

        con = new connectDAO().getConnection();

        try {
            prepare = con.prepareStatement(slq);
            prepare.setString(1, tipo);
            prepare.setString(2, gastos);
            prepare.setString(3, dia);
            prepare.setString(4, mes);
            ResultSet rs = prepare.executeQuery();
            rs.next();
            String x = rs.getString("ID");
            System.out.println(x);
            return x;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "editarGastosDAO" + e);
        }

        return null;
    }

    public ResultSet getValues(String ID){

        String sql = "select * from gasto where ID = ?";

        con = new connectDAO().getConnection();

        try {
            prepare = con.prepareStatement(sql);
            prepare.setString(1, ID);
            ResultSet rs = prepare.executeQuery();
            rs.next();
            return rs;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "getValuesDAO"+e);
        }

        return null;
    }

    public ResultSet getValues(){

        String sql = "select * from gasto";

        con = new connectDAO().getConnection();

        try {
            prepare = con.prepareStatement(sql);
            ResultSet rs = prepare.executeQuery();
            rs.next();
            return rs;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "getValuesDAO"+e);
        }

        return null;
    }
}
