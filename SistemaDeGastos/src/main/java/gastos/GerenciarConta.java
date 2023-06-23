package gastos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GerenciarConta {
    
    JFrame tela;
    UI ui = new UI();
    Contas cbd = new Contas();
    JTable jt = new JTable(cbd.modelo);
    JScrollPane jscp = new JScrollPane(jt);
    JButton edit;
    JButton add;
    JButton remove;


    GerenciarConta(){

        tela = ui.createJFrame("Gerenciar Contas", new Color(50, 100, 200), 800, 600);
        remove = ui.createButton("Remover Conta", 0, 0, 125, 35);
        add = ui.createButton("Adicionar Conta", 0, 50, 125, 35);
        edit = ui.createButton("Editar Conta", 0, 100, 125, 35);
        jscp.setBounds(25, 315, 725, 225);

        remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        edit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        jt.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(100);
        jt.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(225);
        jt.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(225);

        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(JLabel.CENTER);
        jt.getColumnModel().getColumn(0).setCellRenderer(render);
        jt.getColumnModel().getColumn(1).setCellRenderer(render);
        jt.getColumnModel().getColumn(2).setCellRenderer(render);
        jt.setAutoCreateRowSorter(true);

        tela.add(jscp);
        tela.add(remove);
        tela.add(add);
        tela.add(edit);
        
        tela.setVisible(true);
    }
}
