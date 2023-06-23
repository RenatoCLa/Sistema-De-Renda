package gastos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BD.userLogDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LoginFrame implements ActionListener{
    //JFrame
    JFrame login = new JFrame();

    //Componentes do JFrame
    //Buttons
    JButton logBt = new JButton("Login");//botao de login
    JButton cadBt = new JButton("Cadastro");//botao para acessar a tela de cadastro

    //TextFields
    JTextField nomeField = new JTextField();
    JPasswordField senhaField = new JPasswordField();

    //labels
    JLabel titulo = new JLabel("Login");
    JLabel usuarioLabel = new JLabel("Usuário:");
    JLabel senhaLabel = new JLabel("Senha:");


    //Fontes
    Font fonte1 = new Font("SansSerif", Font.BOLD, 24);
    Font fonte2 = new Font("SansSerif", Font.PLAIN, 18);
    Font fonte3 = new Font("SansSerif", Font.BOLD, 20);
    Font fonte4 = new Font("SansSerif", Font.BOLD, 48);
    Font fonte5 = new Font("SansSerif", Font.BOLD, 14);

    LoginFrame(){
        //titulo
        titulo.setBounds(235, 65, 200, 55);
        titulo.setFont(fonte4);
        titulo.setForeground(Color.white);

        //texto "nome"
        usuarioLabel.setBounds(75, 200, 125, 25);
        usuarioLabel.setForeground(Color.white);
        usuarioLabel.setFont(fonte1);

        //campo de nome
        nomeField.setBounds(175, 200, 275, 25);
        nomeField.setFont(fonte2);
        nomeField.setCursor(new Cursor(Cursor.TEXT_CURSOR));//isso aqui é pro icone do mouse mudar caso ele esteja em cima desse componente

        //texto "senha"
        senhaLabel.setBounds(90, 275, 125, 25);
        senhaLabel.setFont(fonte1);
        senhaLabel.setForeground(Color.white);

        //campo de senha
        senhaField.setBounds(175, 275, 275, 25);
        senhaField.setFont(fonte2);
        senhaField.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        //Botao login
        logBt.setBounds(240, 350, 120, 35);
        logBt.setFont(fonte1);
        logBt.setFocusable(false);
        logBt.addActionListener(this);
        logBt.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Botao redirecionar para tela de cadastro
        cadBt.setBounds(262, 385, 75, 25);
        cadBt.setFont(fonte5);
        cadBt.setFocusable(false);
        cadBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cadBt.setForeground(Color.white);
        cadBt.addActionListener(this);
        cadBt.setBackground(new Color(50,100,200));
        cadBt.setBorder(null);
        cadBt.setContentAreaFilled(false);
        
        //tela login
        login.setSize(600, 500);
        login.getContentPane().setBackground(new Color(50, 100, 200));
        login.setTitle("Login");
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setResizable(false);
        login.setLayout(null);

        //adicionar componentes a tela
        login.add(usuarioLabel);
        login.add(senhaLabel);
        login.add(logBt);
        login.add(nomeField);
        login.add(senhaField);
        login.add(titulo);
        login.add(cadBt);
        //Deixar a tela visivel
        login.setVisible(true);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cadBt){

            //abre a tela de cadastro
            CadastroFrame cad = new CadastroFrame();
            login.dispose();
        }

        if(e.getSource() == logBt){

            try {

                String usuarioTxt = nomeField.getText();
                char[] pass = senhaField.getPassword();
                String senhaTxt = new String(pass);
                Conta c1 = new Conta(usuarioTxt, senhaTxt);

                userLogDAO userdao = new userLogDAO();

                ResultSet resultUser = userdao.verificarUser(c1);

                if (resultUser.next()){
                    int x = resultUser.getInt(1);
                    userID.setID(x);
                    MenuInicial inicio = new MenuInicial();
                    login.dispose();

                }else{
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválido", "Conta inválida",0);
                }


            } catch (Exception error) {
                JOptionPane.showMessageDialog(cadBt, error.getMessage());
            }
        }
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}