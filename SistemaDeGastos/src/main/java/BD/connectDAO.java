package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class connectDAO {

    public Connection getConnection(){

        Connection conn = null;

        try{

            String URL = "jdbc:mysql://localhost:3306/renda?user=root&password=";
            conn = DriverManager.getConnection(URL);
            System.out.println("teste");
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
        return conn;
    }


}
