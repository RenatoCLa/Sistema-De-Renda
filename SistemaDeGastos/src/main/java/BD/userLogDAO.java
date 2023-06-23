package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import gastos.Conta;

public class userLogDAO {
    
    Connection con;

    public ResultSet verificarUser(Conta conta){
        
        con = new connectDAO().getConnection();

        try {
            
            String sql = "select * from conta where user = ? and pass = ?";

            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, conta.getNome());
            prepare.setString(2, conta.getSenha());

            ResultSet result = prepare.executeQuery();
            return result;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " userLogDAO" + e);
            return null;
        }
    }
}
