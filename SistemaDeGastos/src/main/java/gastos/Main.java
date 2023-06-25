package gastos;

import java.sql.SQLException;

import BD.createDB;
import BD.userCadDAO;

public class Main {
    
    public static void main(String[] args) throws SQLException {
        
        createDB DB = new createDB();
        DB.createBD();

        userCadDAO contaE = new userCadDAO();
        //Começa o aplicativo, chamando a tela de login
        if(contaE.contaExist().next()){
            LoginFrame log = new LoginFrame();
        }else{
            CadastroFrame cad = new CadastroFrame();
            
        }
        
    }
}
