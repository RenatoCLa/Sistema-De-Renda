package gastos;

import java.awt.Color;
import java.awt.Font;
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
    JTable jt = new JTable(g.modelo);
    JLabel titulo;
    JScrollPane tabela = new JScrollPane(jt);
    

    AdminTabela(){
        
        tela = ui.createJFrame("Gerenciar Gastos de Usuários", new Color(50, 100, 200), 600, 350);
        add = ui.createButton("Adicionar Gastos", 25, 55, 150, 30);
        remover = ui.createButton("Remover Gastos", 405, 55, 150, 30);
        editar = ui.createButton("Editar Gastos", 215, 55, 150, 30);
        titulo = ui.createText("Gerenciar Gastos de usuários", 100, 0, 400, 35, new Font("SansSerif", Font.BOLD, 28), Color.white);

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
                valor.add(x.get(4).toString());
                try {
                    new EditarGastos(new gastosDAO().getID(valor.get(0),valor.get(1) ,valor.get(2), valor.get(3), valor.get(4)));
                    tela.dispose();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }       
        });

        tabela.setBounds(0, 100, 600, 275);

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
        //jt.setAutoCreateRowSorter(true);
        
        tela.add(tabela);
        tela.add(add);
        tela.add(remover);
        tela.add(editar);
        tela.add(titulo);

        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setVisible(true);
    }
}
