package gastos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BD.userCadDAO;

public class CadastroFrame implements ActionListener {

    JFrame cadastro = new JFrame();

    //Componentes do JFrame
    //Buttons
    JButton logBt = new JButton("Login");//botao para acessar tela de login
    JButton cadBt = new JButton("Cadastro");//botao de cadastro

    //TextFields
    JTextField nomeField = new JTextField();
    JPasswordField senhaField = new JPasswordField();

    //labels
    JLabel titulo = new JLabel("Cadastro");
    JLabel usuarioLabel = new JLabel("Usuário:");
    JLabel senhaLabel = new JLabel("Senha:");


    //Fontes
    Font fonte1 = new Font("SansSerif", Font.BOLD, 24);
    Font fonte2 = new Font("SansSerif", Font.PLAIN, 18);
    Font fonte3 = new Font("SansSerif", Font.BOLD, 20);
    Font fonte4 = new Font("SansSerif", Font.BOLD, 48);
    Font fonte5 = new Font("SansSerif", Font.BOLD, 14);

    CadastroFrame(){

        //titulo
        titulo.setBounds(65, 10, 225, 55);
        titulo.setFont(fonte4);
        titulo.setForeground(Color.white);

        //texto "nome"
        usuarioLabel.setBounds(15, 100, 125, 25);
        usuarioLabel.setForeground(Color.white);
        usuarioLabel.setFont(fonte1);

        //campo de nome
        nomeField.setBounds(120, 101, 200, 25);
        nomeField.setFont(fonte2);
        nomeField.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        //texto "senha"
        senhaLabel.setBounds(32, 175, 125, 25);
        senhaLabel.setFont(fonte1);
        senhaLabel.setForeground(Color.white);

        //campo de senha
        senhaField.setBounds(120, 176, 200, 25);
        senhaField.setFont(fonte2);
        senhaField.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        //Botao cadastro
        cadBt.setBounds(95, 230, 140, 35);
        cadBt.setFont(fonte1);
        cadBt.setFocusable(false);
        cadBt.addActionListener(this);
        cadBt.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //botao redirecionar para login
        logBt.setBounds(125, 265, 75, 25);
        logBt.setFont(fonte5);
        logBt.setFocusable(false);
        logBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logBt.setForeground(Color.white);
        logBt.addActionListener(this);
        logBt.setBackground(new Color(50,100,200));
        logBt.setBorder(null);
        logBt.setContentAreaFilled(false);
        
        //configurar tela
        cadastro.setSize(350, 350);
        cadastro.getContentPane().setBackground(new Color(50, 100, 200));
        cadastro.setTitle("Cadastro");
        cadastro.setResizable(false);
        cadastro.setLocationRelativeTo(null);
        cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cadastro.setResizable(false);
        cadastro.setLayout(null);

        //adicionar componentes
        cadastro.add(usuarioLabel);
        cadastro.add(senhaLabel);
        cadastro.add(logBt);
        cadastro.add(nomeField);
        cadastro.add(senhaField);
        cadastro.add(titulo);
        cadastro.add(cadBt);

        
        cadastro.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cadBt){
            
            //abre a tela inicial (caso o cadastro tenha ocorrido com sucesso)
            String nome = nomeField.getText().replaceAll(" ", "");
            char[] pass = senhaField.getPassword();
            String senha = new String(pass);
            if(nome.isBlank() && senha.isBlank()){
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválido", "Conta inválida", 0);
            }else{
                Conta c1 = new Conta(nome, senha);
                userCadDAO cad = new userCadDAO();
                
                try {
                    if(cad.contaExist(nome).next()){
                        JOptionPane.showMessageDialog(null, "Conta já existe");
                    }else{
                        cad.cadastrarUser(c1);
                        new LoginFrame();
                        cadastro.dispose();
                    }
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, e);
                }
                
                
            }
            
        }

        if(e.getSource() == logBt){

             //abre a tela de login
            new LoginFrame();
            cadastro.dispose();
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
