package gastos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import BD.adminCommandsDAO;
import BD.userCadDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class alterarConta {
    
    UI x = new UI();
    JFrame tela;
    JButton addConta;
    JButton sairTela;
    JTextField userValor;
    JTextField passValor;
    JLabel titulo;
    JLabel user;
    JLabel pass;

    alterarConta(){

        tela = x.createJFrame("Criar Conta", new Color(50, 100, 200), 400, 200);
        addConta = x.createButton("Criar", 50, 125, 75, 25);
        sairTela = x.createButton("Voltar", 250, 125, 75, 25);
        userValor = x.createTextField("", new Font("SansSerif", Font.PLAIN, 16), 35, 75, 125, 30);
        passValor = x.createTextField("", new Font("SansSerif", Font.PLAIN, 16), 215, 75, 125, 30);
        titulo = x.createText("Criar Conta", 125, 5, 400, 35,  new Font("SansSerif", Font.BOLD, 26), Color.white);
        user = x.createText("Usuario", 60, 45, 125, 35,  new Font("SansSerif", Font.BOLD, 18), Color.white);
        pass = x.createText("Senha", 250, 45, 125, 35,  new Font("SansSerif", Font.BOLD, 18), Color.white);

        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addConta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String t1 = userValor.getText();
                String t2 = passValor.getText();

                Boolean x = t1.isBlank();
                Boolean y = t2.isBlank();
                
                userCadDAO ver = new userCadDAO();

                try {
                    if(ver.contaExist(t1).next()){

                        JOptionPane.showMessageDialog(null, "Usuário já existe!");
                    }else if(x == true || y == true){
                        
                        JOptionPane.showMessageDialog(null, "Preencha os dados corretamente!");
                    }else{
                        new adminCommandsDAO().addConta(t1, t2);
                    }
                } catch (SQLException e1) {
                    
                    JOptionPane.showMessageDialog(null, "addConta" + e);
                }
                

                userValor.setText("");
                passValor.setText("");
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        sairTela.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                new GerenciarConta();
                tela.dispose();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        tela.add(sairTela);
        tela.add(addConta);
        tela.add(userValor);
        tela.add(passValor);
        tela.add(titulo);
        tela.add(user);
        tela.add(pass);
        
        tela.setVisible(true);
    }

    alterarConta(String ID, String nome, String senha){

        tela = x.createJFrame("Alterar Dados", new Color(50, 100, 200), 400, 200);
        addConta = x.createButton("Salvar", 50, 125, 75, 25);
        sairTela = x.createButton("Voltar", 250, 125, 75, 25);
        userValor = x.createTextField(nome, new Font("SansSerif", Font.PLAIN, 16), 35, 75, 125, 30);
        passValor = x.createTextField(senha, new Font("SansSerif", Font.PLAIN, 16), 215, 75, 125, 30);
        titulo = x.createText("Alterar Conta", 100, 5, 400, 35,  new Font("SansSerif", Font.BOLD, 26), Color.white);
        user = x.createText("Usuario", 60, 45, 125, 35,  new Font("SansSerif", Font.BOLD, 18), Color.white);
        pass = x.createText("Senha", 250, 45, 125, 35,  new Font("SansSerif", Font.BOLD, 18), Color.white);
        
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        addConta.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                String t1 = userValor.getText();
                String t2 = passValor.getText();

                Boolean x = t1.isBlank();
                Boolean y = t2.isBlank();

                userCadDAO ver = new userCadDAO();
                if(x == true || y == true){

                    JOptionPane.showMessageDialog(null, "Preencha os dados corretamente!");
                }else {
                    try {
                    
                        if(t1.equals(nome)){

                            new adminCommandsDAO().editConta(t1, t2, ID);
                            new GerenciarConta();
                            tela.dispose();
                        }else if(ver.contaExist(t1).next()){

                            JOptionPane.showMessageDialog(null, "Usuário já existe!");
                        }else{
                        
                            new adminCommandsDAO().editConta(t1, t2, ID);
                            new GerenciarConta();
                            tela.dispose();
                        }
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(null, "EditConta" + e1);
                        }
                }
                
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        sairTela.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                new GerenciarConta();
                tela.dispose();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        tela.add(sairTela);
        tela.add(addConta);
        tela.add(userValor);
        tela.add(passValor);
        tela.add(pass);
        tela.add(user);
        tela.add(titulo);
        tela.setVisible(true);
    }
}
