package gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminMenu {

    JFrame tela;
    JButton gerenciarGastos;
    JButton gerenciarContas;
    JButton alterarDados;
    JLabel titulo;

    UI ui = new UI();
    
    AdminMenu(){

        //Criar Componentes
        tela = ui.createJFrame("Menu Admin", new Color(50, 100, 200), 600, 350);
        gerenciarContas = ui.createButton("Gerenciar Contas", 0, 75, 125, 35);
        gerenciarGastos = ui.createButton("Gerenciar Gastos", 0, 150, 125, 35);
        alterarDados = ui.createButton("Alterar Informações", 0, 225, 125, 35);
        titulo = ui.createText("Menu Admin", 225, 5, 175, 45, new Font("SansSerif", Font.BOLD, 26), Color.white);
        
        gerenciarGastos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                AdminTabela x = new AdminTabela();

                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });


        tela.add(gerenciarContas);
        tela.add(gerenciarGastos);
        tela.add(alterarDados);
        tela.add(titulo);

        tela.setVisible(true);

    }
}
