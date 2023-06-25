package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class createDB {
    
    String sql = "CREATE DATABASE IF NOT EXISTS `renda` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;";

    String sql2 = "USE `renda`";
    
    String sql3 = "CREATE TABLE IF NOT EXISTS `conta` (`ID` int(11) NOT NULL AUTO_INCREMENT,`user` varchar(50) DEFAULT '',`pass` varchar(50) DEFAULT '',PRIMARY KEY (`ID`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";

    String sql4 = "CREATE TABLE IF NOT EXISTS `gasto` (`ID` int(11) NOT NULL AUTO_INCREMENT, `tipo` varchar(50) DEFAULT NULL,`gastos` int(20) DEFAULT NULL,`dia` int(11) DEFAULT NULL, `mes` varchar(50) DEFAULT NULL,`idconta` int(11) DEFAULT NULL,PRIMARY KEY (`ID`),KEY `FK_CONTA_ID` (`idconta`),CONSTRAINT `FK_CONTA_ID` FOREIGN KEY (`idconta`) REFERENCES `conta` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";

    String sql5 = "insert into conta (user, pass) values ('admin', 'admin')";

    public void createBD(){

        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");
            Statement stmt = con.createStatement();
        ){
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);
            stmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void createAdminAccount(){
        Connection con = new connectDAO().getConnection();
        try {
            PreparedStatement prepare = con.prepareStatement(sql5);
            prepare.execute();
            prepare.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
