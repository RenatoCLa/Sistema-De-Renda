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
    JButton gastosAdmin;
    JLabel titulo;

    UI ui = new UI();
    
    AdminMenu(){

        //Criar Componentes
        tela = ui.createJFrame("Menu Admin", new Color(50, 100, 200), 250, 300);
        gerenciarContas = ui.createButton("Gerenciar Contas", 40, 100, 150, 35);
        gerenciarGastos = ui.createButton("Gerenciar Gastos", 40, 150, 150, 35);
        gastosAdmin = ui.createButton("Tabela de gastos", 40, 200, 150, 35);
        titulo = ui.createText("Menu Admin", 40, 5, 175, 45, new Font("SansSerif", Font.BOLD, 26), Color.white);
        
        gerenciarGastos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                new AdminTabela();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        
        gerenciarContas.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                new GerenciarConta();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });

        gastosAdmin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                new MenuInicial();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        tela.add(gastosAdmin);
        tela.add(gerenciarContas);
        tela.add(gerenciarGastos);
        tela.add(titulo);

        tela.setVisible(true);

    }
}
