package gastos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import BD.gastosDAO;
public class AdminTabela {
    
    UI ui = new UI();

    JFrame tela;
    
    Gastos g = new Gastos("");
    JButton add;
    JButton remover;
    JButton editar;
    JButton sair;
    JTable jt = new JTable(g.modelo);
    JScrollPane tabela = new JScrollPane(jt);
    

    AdminTabela(){
        
        tela = ui.createJFrame("Informações de gastos", new Color(50, 100, 200), 800, 600);
        add = ui.createButton("Adicionar Gastos", 25, 282, 150, 30);
        remover = ui.createButton("Remover Gastos", 325, 282, 150, 30);
        editar = ui.createButton("Editar Gastos", 175, 282, 150, 30);
        sair = ui.createButton("Voltar", 475, 282, 150, 30);

        remover.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x = jt.convertColumnIndexToModel(jt.getSelectedRow());
                Vector y = g.modelo.getDataVector().elementAt(x);
                ArrayList<String> values = new ArrayList<String>();
                values.add(y.get(0).toString());
                values.add(y.get(1).toString());
                values.add(y.get(2).toString());
                values.add(y.get(3).toString());
                values.add(y.get(4).toString());
                new gastosDAO().removerGastos(values.get(0),values.get(1),values.get(2),values.get(3), Integer.parseInt(values.get(4)));
                g.deleteModeloRow(x);
                
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddGastosAdmin();
                tela.dispose();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector x = g.modelo.getDataVector().elementAt(jt.convertColumnIndexToModel(jt.getSelectedRow()));
                ArrayList<String> valor = new ArrayList<String>();
                System.out.println(x);
                valor.add(x.get(0).toString());
                valor.add(x.get(1).toString());
                valor.add(x.get(2).toString());
                valor.add(x.get(3).toString());
                try {
                    new EditarGastos(new gastosDAO().getID(valor.get(0),valor.get(1) ,valor.get(2), valor.get(3)));
                    tela.dispose();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }       
        });
        sair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                new AdminMenu();
                tela.dispose();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        tabela.setBounds(25, 315, 725, 225);

        jt.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(225);
        jt.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(100);
        jt.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(100);
        jt.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(225);
        jt.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(225);

        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(JLabel.CENTER);
        jt.getColumnModel().getColumn(0).setCellRenderer(render);
        jt.getColumnModel().getColumn(1).setCellRenderer(render);
        jt.getColumnModel().getColumn(2).setCellRenderer(render);
        jt.getColumnModel().getColumn(3).setCellRenderer(render);
        jt.getColumnModel().getColumn(4).setCellRenderer(render);
        jt.setAutoCreateRowSorter(true);
        
        tela.add(sair);
        tela.add(tabela);
        tela.add(add);
        tela.add(remover);
        tela.add(editar);

        tela.setVisible(true);
    }
}
