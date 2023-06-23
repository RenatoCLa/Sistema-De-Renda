package gastos;

import java.awt.Color;

import javax.swing.JFrame;

public class GerenciarConta {
    
    JFrame tela;
    UI ui = new UI();


    GerenciarConta(){

        tela = ui.createJFrame("Gerenciar Contas", new Color(50, 100, 200), 800, 600);

        
        tela.setVisible(true);
    }
}
