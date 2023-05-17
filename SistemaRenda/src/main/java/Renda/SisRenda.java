package Renda;

import java.awt.Color;

public class SisRenda {
    
    public static boolean existeConta = false;
    
    public static String usuarioTemp;
    public static String senhaTemp;

    
    public static void main(String[] args) {
        
        /*Abrir tela de registro, caso não haja uma conta no sistema
        Abrir tela de login, caso haja uma conta no sistema
        */
        if(existeConta == false){
           new RegistroUser().setVisible(true); 
        }
        else{
            new Login().setVisible(true);
        }
    }
}

