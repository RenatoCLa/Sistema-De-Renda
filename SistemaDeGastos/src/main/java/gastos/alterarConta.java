package gastos;

import javax.swing.JButton;
import javax.swing.JFrame;
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

    alterarConta(){

        tela = x.createJFrame("Adicionar Conta", new Color(50, 100, 200), 800, 400);
        addConta = x.createButton("Adicionar", 25, 250, 100, 50);
        sairTela = x.createButton("Voltar", 600, 300, 100, 50);
        userValor = x.createTextField("", new Font("SansSerif", Font.PLAIN, 16), 200, 50, 125, 30);
        passValor = x.createTextField("", new Font("SansSerif", Font.PLAIN, 16), 0, 50, 75, 30);
        
        addConta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String t1 = userValor.getText();
                String t2 = passValor.getText();
                
                userCadDAO ver = new userCadDAO();

                try {
                    if(ver.contaExist(t1).next()){

                        JOptionPane.showMessageDialog(null, "Usuário já existe!");
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
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        tela.add(sairTela);
        tela.add(addConta);
        tela.add(userValor);
        tela.add(passValor);
        tela.setVisible(true);
    }

    alterarConta(String ID, String nome, String senha){

        tela = x.createJFrame("Alterar Dados", new Color(50, 100, 200), 800, 400);
        addConta = x.createButton("Salvar", 25, 250, 100, 50);
        sairTela = x.createButton("Voltar", 600, 300, 100, 50);
        userValor = x.createTextField(nome, new Font("SansSerif", Font.PLAIN, 16), 200, 50, 125, 30);
        passValor = x.createTextField(senha, new Font("SansSerif", Font.PLAIN, 16), 0, 50, 75, 30);
        
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
                        }else if(ver.contaExist(t1).next()){

                            JOptionPane.showMessageDialog(null, "Usuário já existe!");
                        }else{
                        
                            new adminCommandsDAO().editConta(t1, t2, ID);
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
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        tela.add(sairTela);
        tela.add(addConta);
        tela.add(userValor);
        tela.add(passValor);
        tela.setVisible(true);
    }
}
