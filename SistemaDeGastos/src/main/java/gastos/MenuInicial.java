package gastos;

import java.awt.*;
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

import BD.gastosDAO;

public class MenuInicial{

    UI ui = new UI();
    //JFrame
    JFrame inicialFrame = new JFrame();

    Gastos gastT = new Gastos();

    //Componentes da tela
    //Label (variaveis de texto)
    JLabel titulo = new JLabel("Gerenciador de Gastos");
    //Buttons (botoes)
    JButton removerGastos;
    JButton editarGastos;
    JButton telaAddGastos;
    //Table (componentes da tabela)
    JTable gastosLista = new JTable(gastT.modelo);
    JScrollPane painelScroll = new JScrollPane(gastosLista);

    //Fontes
    Font fonteTitulo = new Font("SansSerif", Font.BOLD, 36);
    Font fonteTexto = new Font("SansSerif", Font.PLAIN, 16);
    Font gastos = new Font("SansSerif", Font.BOLD, 28);
    Font listaFonte = new Font("SansSerif", Font.BOLD, 18);
    Font fonteBotao = new Font("SansSerif", Font.PLAIN, 14);
    Font gastosInputFont = new Font("SansSerif", Font.BOLD, 24);
    

    //esse codigo vai ser chamado, quando um menu for criado
    MenuInicial(){

        telaAddGastos = ui.createButton("Adicionar Gastos", 50, 235, 150, 30);
        telaAddGastos.setFont(new Font("SansSerif", Font.BOLD, 12));
        telaAddGastos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AdicionarGastos();
                inicialFrame.dispose();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        removerGastos = ui.createButton("Remover Gastos", 250, 235, 150, 30);
        removerGastos.setFont(new Font("SansSerif", Font.BOLD, 12));
        removerGastos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x = gastosLista.convertRowIndexToModel(gastosLista.getSelectedRow());
                gastT.deleteModeloRow(x); 
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        editarGastos = ui.createButton("Editar Gastos", 375, 235, 150, 30);
        editarGastos.setFont(new Font("SansSerif", Font.BOLD, 12));
        editarGastos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Vector x = gastT.modelo.getDataVector().elementAt(gastosLista.convertColumnIndexToModel(gastosLista.getSelectedRow()));
                ArrayList<String> valor = new ArrayList<String>();
                System.out.println(x);
                valor.add(x.get(0).toString());
                valor.add(x.get(1).toString());
                valor.add(x.get(2).toString());
                valor.add(x.get(3).toString());
                try {
                    new EditarGastos(new gastosDAO().getID(valor.get(0),valor.get(1) ,valor.get(2), valor.get(3)));
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(editarGastos, e1);
                }
                inicialFrame.dispose();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        
        //configurar titulo
        titulo.setBounds(190, 5, 600, 50);
        //setBounds é um comando que posiciona o objeto na tela, vc pode colocar 4 valores
        //setBounds (posiçãoX, posiçãoY, largura, altura)
        titulo.setFont(fonteTitulo); //altera a fonte
        titulo.setForeground(Color.white); // altera a cor da fonte
        //Configurar tabela de gastos
        gastosLista.getTableHeader().setFont(listaFonte); // altera a fonte
        gastosLista.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(225); // isso aqui deixa a coluna de gastos maior que a coluna de dias
        gastosLista.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(100);
        gastosLista.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(225);
        gastosLista.getTableHeader().setResizingAllowed(false); //isso aqui faz com que as colunas n possam mudar de tamanho
        painelScroll.setBounds(400, 300, 350, 250);
        gastosLista.setAutoCreateRowSorter(true); //isso aqui é pra poder escolher em qual ordem os itens aparecem na coluna
        //Configurar botões de interação com a tabela /remover gastos
        //configurar tela
        inicialFrame.getContentPane().setBackground(new Color(50, 100, 200)); // troca o cor do plano de fundo
        inicialFrame.setSize(800, 600); // ajusta o tamanho da tela
        inicialFrame.setLocationRelativeTo(null); // deixa a tela centralizada
        inicialFrame.setLayout(null); // isso aqui é pra gente poder definir a posição final de um componente pelo codigo la de cima
        inicialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ao clicar no X, o aplicativo fecha
        inicialFrame.setResizable(false);

        //adicionar componentes na tela
        inicialFrame.add(titulo);
        inicialFrame.add(removerGastos);
        inicialFrame.add(painelScroll);
        inicialFrame.add(telaAddGastos);
        inicialFrame.add(editarGastos);
        
        inicialFrame.setVisible(true); // deixar a tela visivel
    }
}
