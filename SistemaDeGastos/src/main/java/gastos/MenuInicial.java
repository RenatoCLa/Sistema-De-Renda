package gastos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class MenuInicial implements ActionListener{

    //JFrame
    JFrame inicialFrame = new JFrame();

    //Componentes
    //Label
    JLabel titulo = new JLabel("Gerenciador de Gastos Mensais");
    JLabel gastosContador = new JLabel("Gastos: R$");
    //Buttons
    JButton graficoDisplay = new JButton("Grafico de gastos");
    JButton addGastos = new JButton("Adicionar Gastos");
    JButton removerGastos = new JButton("Remover Gastos");
    //Table
    DefaultTableModel modeloTable = new DefaultTableModel();
    JTable gastosLista = new JTable(modeloTable);
    JScrollPane painelScroll = new JScrollPane(gastosLista);
    //
    JTextField valorGasto = new JTextField();

    //Fontes
    Font fonteTitulo = new Font("SansSerif", Font.BOLD, 36);
    Font fonteTexto = new Font("SansSerif", Font.PLAIN, 16);
    Font gastos = new Font("SansSerif", Font.BOLD, 28);
    Font listaFonte = new Font("SansSerif", Font.BOLD, 18);
    Font fonteBotao = new Font("SansSerif", Font.PLAIN, 14);
    Font gastosInputFont = new Font("SansSerif", Font.BOLD, 24);

    String[] x = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
                    "20","21","22","23","24","25","26","27","28","29","30"};
    JComboBox combo = new JComboBox<String>(x);
    JComboBox comboLista = new JComboBox<String>(x);
    MenuInicial(){

        //Adicionar componentes
        inicialFrame.add(titulo);
        inicialFrame.add(gastosContador);
        inicialFrame.add(graficoDisplay);
        inicialFrame.add(addGastos);
        inicialFrame.add(removerGastos);
        inicialFrame.add(painelScroll);
        inicialFrame.add(valorGasto);
        inicialFrame.add(comboLista);

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
        //Configurar tabela de gastos
        modeloTable.addColumn("Gastos(R$)");
        modeloTable.addColumn("Dia");
        gastosLista.getTableHeader().setFont(listaFonte);
        gastosLista.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(225);
        gastosLista.getTableHeader().setResizingAllowed(false);
        painelScroll.setBounds(400, 300, 350, 250);
        TableColumn col = gastosLista.getColumnModel().getColumn(1);
        col.setCellEditor(new DefaultCellEditor(combo));
        //Configurar botões de interação com a tabela /adicionar gastos
        addGastos.setBounds(215, 415, 150, 30);
        addGastos.setFont(fonteBotao);
        addGastos.addActionListener(this);
        //Configurar botões de interação com a tabela /remover gastos
        removerGastos.setFont(fonteBotao);
        removerGastos.addActionListener(this);
        removerGastos.setBounds(215, 500, 150, 30);
        //Configurar input de gastos
        valorGasto.setBounds(200, 350, 175, 50);
        valorGasto.setFont(gastosInputFont);
        //
        comboLista.setBounds(215, 300, 50, 25);


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

        if(e.getSource() == addGastos){

            String x = "R$" + valorGasto.getText();
            String y = comboLista.getSelectedItem().toString();
            modeloTable.insertRow(0, new Object[]{x, y});
        }

        if(e.getSource() == removerGastos){
            int x = gastosLista.getSelectedRow();
            modeloTable.removeRow(x);
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
