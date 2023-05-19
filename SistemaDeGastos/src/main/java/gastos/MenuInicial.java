package gastos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuInicial implements ActionListener{

    //JFrame
    JFrame inicialFrame = new JFrame();

    //Componentes
    //Label
    JLabel titulo = new JLabel("Gerenciador de gastos mensais");
    JLabel gastosContador = new JLabel("Gastos: R$");
    //Buttons
    JButton graficoDisplay = new JButton("Grafico de gastos");

    //Fontes
    Font fonteTitulo = new Font("SansSerif", Font.BOLD, 36);
    Font fonteTexto = new Font("SansSerif", Font.PLAIN, 16);
    Font gastos = new Font("SansSerif", Font.BOLD, 28);

    int x = 0;
    MenuInicial(){

        //Adicionar componentes
        inicialFrame.add(titulo);
        inicialFrame.add(gastosContador);
        inicialFrame.add(graficoDisplay);

        //configurar componentes
        //configurar titulo
        titulo.setBounds(100, 5, 600, 50);
        titulo.setFont(fonteTitulo);
        titulo.setForeground(Color.white);
        //configurar contador de gastos
        gastosContador.setBounds(30, 175, 200, 35);
        gastosContador.setFont(gastos);
        gastosContador.setForeground(Color.white);
        //configurar botao de visualização  de grafico
        graficoDisplay.setBounds(25, 125, 150, 40);

        //configurar tela
        inicialFrame.getContentPane().setBackground(new Color(50, 100, 200));
        inicialFrame.setSize(800, 600);
        inicialFrame.setLocationRelativeTo(null);
        inicialFrame.setLayout(null);
        inicialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicialFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == graficoDisplay){
            //Chamar o grafico
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
