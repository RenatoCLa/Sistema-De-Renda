package gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import BD.adminCommandsDAO;

public class GerenciarConta {
    
    JFrame tela;
    UI ui = new UI();
    ContaTableInfo cbd = new ContaTableInfo();
    JTable jt = new JTable(cbd.modelo);
    JScrollPane jscp = new JScrollPane(jt);
    JButton edit;
    JButton add;
    JButton remove;
    JLabel titulo;

    GerenciarConta(){

        tela = ui.createJFrame("Gerenciar Contas", new Color(50, 100, 200), 500, 350);
        remove = ui.createButton("Remover Conta", 330, 65, 125, 35);
        add = ui.createButton("Adicionar Conta", 30, 65, 125, 35);
        edit = ui.createButton("Editar Conta", 180, 65, 125, 35);
        titulo = ui.createText("Gerenciador de Contas", 100, 5, 400, 35, new Font("SansSerif", Font.BOLD, 26), Color.white);
        jscp.setBounds(0, 115, 500, 200);

        remove.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = jt.convertColumnIndexToModel(jt.getSelectedRow());
                Vector y = cbd.modelo.getDataVector().elementAt(x);
                String ID = y.get(0).toString();
                System.out.println(ID);
                if(ID.equals("1")){
                    JOptionPane.showMessageDialog(null, "Não é possível remover a conta de administrador!");
                }else{

                    cbd.modelo.removeRow(x);
                    new adminCommandsDAO().deleteData(ID);
                    new adminCommandsDAO().deleteConta(ID);
                }

                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new alterarConta();
                tela.dispose();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        edit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x = jt.convertRowIndexToModel(jt.getSelectedRow());
                Vector y = cbd.modelo.getDataVector().elementAt(x);
                String ID = y.get(0).toString();
                String nome = y.get(1).toString();
                String senha = y.get(2).toString();
                new alterarConta(ID,nome,senha);
                tela.dispose();
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
        //jt.setAutoCreateRowSorter(true);

        tela.add(jscp);
        tela.add(remove);
        tela.add(titulo);
        tela.add(add);
        tela.add(edit);

        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        tela.setVisible(true);
    }
}
