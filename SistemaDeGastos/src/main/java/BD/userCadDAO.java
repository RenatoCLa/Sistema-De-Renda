package BD;

import gastos.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class userCadDAO {
    
    Connection con;
    PreparedStatement prepare;


    public void cadastrarUser(Conta cnt){
        String sql = "insert into conta (user, pass) values (?,?)";

        con = new connectDAO().getConnection();

        try {
            
            prepare = con.prepareStatement(sql);
            prepare.setString(1, cnt.getNome());
            prepare.setString(2, cnt.getSenha());

            prepare.execute();
            System.out.println("Teste1");
            prepare.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "userCadDAO" + e);
        }
    }

    public ResultSet contaExist(String nome){

        String sql = "select * from conta where user = ?";

        con = new connectDAO().getConnection();

        try {
            
            prepare = con.prepareStatement(sql);
            prepare.setString(1, nome);

            prepare.execute();
            return prepare.getResultSet();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "userCadDAO" + e);
        }
        return null;

    }
    
}
