package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class adminCommandsDAO {
    
    public Connection con;
    public PreparedStatement prepare;

    public void addConta(String user, String pass){
        
        con = new connectDAO().getConnection();

        String sql = "insert into conta (user, pass) values (?,?)";

        try {
            
            prepare = con.prepareStatement(sql);
            prepare.setString(1, user);
            prepare.setString(2, pass);
            prepare.execute();
            prepare.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CommandoAdmin.CriarConta" + e);
        }
    }

    public void deleteConta(String ID){

        con = new connectDAO().getConnection();  

        String sql = " delete from conta where ID = ?";

        try {

            prepare = con.prepareStatement(sql);
            prepare.setString(1, ID);
            prepare.executeUpdate();
            prepare.close();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CommandoAdmin.RemoverConta" + e);
        }
    }

    public void deleteData(String ID){
        
        con = new connectDAO().getConnection();
        String sql = " delete from gasto where idconta = ?";

        try {

            prepare = con.prepareStatement(sql);
            prepare.setString(1, ID);
            prepare.executeUpdate();
            prepare.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CommandoAdmin.RemoverDados" + e);
        }
    }

    public void editConta(String user, String pass, String ID){

        con = new connectDAO().getConnection();
        String sql = " update conta set user = ?, pass =? where ID = ?";

        try {

            prepare = con.prepareStatement(sql);
            prepare.setString(1, user);
            prepare.setString(2, pass);
            prepare.setString(3, ID);
            prepare.executeUpdate();
            prepare.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CommandoAdmin.EditarDados" + e);
        }
    }
}
