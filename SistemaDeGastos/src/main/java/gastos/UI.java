package gastos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UI {
    
    private String[] dia = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
    "19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private String[] mes = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
    "Setembro", "outubro","Novembro", "Dezembro"};

    public JButton createButton(String buttonText, int x, int y, int width, int height){

        JButton button = new JButton(buttonText);
        button.setBounds(x,y, width, height);
        
        return button;
    }

    public JFrame createJFrame(String title, Color cor, int width, int height){
        JFrame tela = new JFrame(title);
        tela.getContentPane().setBackground(cor);
        tela.setSize(width, height);
        tela.setLocationRelativeTo(null);
        tela.setLayout(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        return tela;
    }

    public JTextField createTextField(String title, Font fonte, int x, int y, int width, int height){
        JTextField text = new JTextField();
        text.setText(title);
        text.setBounds(x, y, width, height);
        text.setFont(fonte);

        return text;
    }

    public JComboBox<String> createComboBox(int type, int x, int y, int width, int height, Font fonte){
        JComboBox<String> jcb = null;

        switch (type){
            case 1:
                jcb = new JComboBox<>(dia);
                break;
            case 2:
                jcb = new JComboBox<>(mes);
                break;
            default:
                return null;
        }

        jcb.setBounds(x, y, width, height);
        jcb.setSelectedItem(-1);
        jcb.setFont(fonte);

        return jcb; 
    }

    public JLabel createText(String titulo, int x, int y, int width, int height, Font fonte, Color cor){
        JLabel text = new JLabel();
        text.setText(titulo);
        text.setBounds(x, y, width, height);
        text.setFont(fonte);
        text.setForeground(cor);

        return text;
    }

}
