package gastos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame implements ActionListener{
    
    private String nome;
    private String senha;

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

    LoginFrame(Conta c){
        //titulo
        titulo.setBounds(80, 65, 275, 50);
        titulo.setFont(fonte4);
        titulo.setForeground(Color.black);

        //texto "nome"
        usuarioLabel.setBounds(79, 175, 125, 25);
        usuarioLabel.setFont(fonte1);
        usuarioLabel.setForeground(Color.black);

        //campo de nome
        nomeField.setBounds(75, 200, 275, 25);
        nomeField.setFont(fonte2);
        nomeField.setCursor(new Cursor(Cursor.TEXT_CURSOR));//isso aqui é pro icone do mouse mudar caso ele esteja em cima desse componente

        //texto "senha"
        senhaLabel.setBounds(79, 250, 125, 25);
        senhaLabel.setFont(fonte1);
        senhaLabel.setForeground(Color.black);

        //campo de senha
        senhaField.setBounds(75, 275, 275, 25);
        senhaField.setFont(fonte2);
        senhaField.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        //Botao login
        logBt.setBounds(75, 350, 140, 35);
        logBt.setFont(fonte1);
        logBt.setFocusable(false);
        logBt.addActionListener(this);
        logBt.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Botao redirecionar para tela de cadastro
        cadBt.setBounds(220, 355, 75, 25);
        cadBt.setFont(fonte5);
        cadBt.setFocusable(false);
        cadBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cadBt.setForeground(Color.black);
        cadBt.addActionListener(this);
        cadBt.setBackground(new Color(50,100,200));
        cadBt.setBorder(null);
        cadBt.setContentAreaFilled(false);
        
        //tela login
        login.setSize(430, 500);
        login.getContentPane().setBackground(new Color(245, 232, 192));
        login.setTitle("Sistema de Gastos");
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

        this.senha = c.getSenha();
        this.nome = c.getNome();

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

            //abre o menu inicial
            String usuarioTxt = nomeField.getText();
            char[] pass = senhaField.getPassword();
            String senhaTxt = new String(pass);

            if(usuarioTxt.equals(this.nome) && senhaTxt.equals(this.senha)){
                MenuInicial inicio = new MenuInicial();
                login.dispose();
            }
        }
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}