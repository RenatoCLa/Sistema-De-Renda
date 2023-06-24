package gastos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GastosMensais {
    
    UI ui = new UI();

    JFrame tela;
    JLabel titulo;
    JButton calcular;
    JComboBox<String> selMes;
    JLabel valor;

    GastosMensais(){

        tela = ui.createJFrame("Calcular Gastos Mensais", new Color(50, 100, 200), 450, 250);
        titulo = ui.createText("Calcular gastos do mês", 25, 0, 275, 35, new Font("SansSerif", Font.BOLD, 22), Color.white);
        selMes = ui.createComboBox(2, 300, 15, 125, 35, new Font("SansSerif", Font.PLAIN, 18));
        valor = ui.createText("Gastos:", 225, 125, 250, 35, new Font("SansSerif", Font.BOLD, 22), Color.white);
        calcular = ui.createButton("Gerar Gastos", 400, 15, 100, 35);

        tela.add(titulo);
        tela.add(selMes);
        tela.add(valor);
        tela.add(calcular);

        tela.setVisible(true);
    }

    public static void main(String[] args) {
        
        new GastosMensais();
    }
}
