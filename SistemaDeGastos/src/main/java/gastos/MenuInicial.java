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

    static Gastos gastT = new Gastos();

    //Componentes da tela
    //Label (variaveis de texto)
    JLabel titulo = new JLabel("Olá");
    JLabel gastosContador = new JLabel("Gastos: R$");
    //Buttons (botoes)
    JButton graficoDisplay = new JButton("Grafico de gastos");
    JButton addGastos = new JButton("Adicionar Gastos");
    JButton removerGastos = new JButton("Remover Gastos");
    //Table (componentes da tabela)
    static DefaultTableModel modeloTable = new DefaultTableModel();
    JTable gastosLista = new JTable(gastT.modelo);
    JScrollPane painelScroll = new JScrollPane(gastosLista);
    //TextField (variavel de texto que pode receber o input do usuario)
    JTextField valorGasto = new JTextField();

    //Fontes
    Font fonteTitulo = new Font("SansSerif", Font.BOLD, 36);
    Font fonteTexto = new Font("SansSerif", Font.PLAIN, 16);
    Font gastos = new Font("SansSerif", Font.BOLD, 28);
    Font listaFonte = new Font("SansSerif", Font.BOLD, 18);
    Font fonteBotao = new Font("SansSerif", Font.PLAIN, 14);
    Font gastosInputFont = new Font("SansSerif", Font.BOLD, 24);

    //Variavel que contem os dias em um mes (possivelmente temporario)
    String[] x = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
                    "20","21","22","23","24","25","26","27","28","29","30","31"};
    //Isso aqui é o menu de seleção de dias na tabela                
    JComboBox<String> combo = new JComboBox<String>(x);
    //isso aqui é o menu de seleção de dias fora da tabela
    JComboBox<String> comboLista = new JComboBox<String>(x);

    //esse codigo vai ser chamado, quando um menu for criado
    MenuInicial(){

        //adicionar componentes na tela
        inicialFrame.add(titulo);
        inicialFrame.add(gastosContador);
        inicialFrame.add(graficoDisplay);
        inicialFrame.add(addGastos);
        inicialFrame.add(removerGastos);
        inicialFrame.add(painelScroll);
        inicialFrame.add(valorGasto);
        inicialFrame.add(comboLista);

        //configurar componentes da tela
        //configurar titulo
        titulo.setBounds(15, 5, 600, 50);
        //setBounds é um comando que posiciona o objeto na tela, vc pode colocar 4 valores
        //setBounds (posiçãoX, posiçãoY, largura, altura)
        titulo.setFont(fonteTitulo); //altera a fonte
        titulo.setForeground(Color.black); // altera a cor da fonte
        //configurar contador de gastos (Desablitado pois não consegui fazer funcionar -Ramael)
        //gastosContador.setBounds(30, 175, 200, 35);
        //gastosContador.setFont(gastos);
        //gastosContador.setForeground(Color.black);
        //configurar botao de visualização  de grafico
        graficoDisplay.setBounds(18, 525, 365, 30);
        graficoDisplay.addActionListener(this);
        //Configurar tabela de gastos
        //modeloTable.addColumn("Gastos(R$)"); //cria a coluna de gastos na tabela
        //.addColumn("Dia"); // cria a coluna de dias na tabela
        gastosLista.getTableHeader().setFont(listaFonte); // altera a fonte
        gastosLista.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(225); // isso aqui deixa a coluna de gastos maior que a coluna de dias
        gastosLista.getTableHeader().setResizingAllowed(false); //isso aqui faz com que as colunas n possam mudar de tamanho
        painelScroll.setBounds(25, 300, 350, 225);
        //preocupa com isso aqui n, serve pra deixar a coluna de dias com aquele menu de seleção
        TableColumn col = gastosLista.getColumnModel().getColumn(1); 
        col.setCellEditor(new DefaultCellEditor(combo));
        gastosLista.setAutoCreateRowSorter(true); //isso aqui é pra poder escolher em qual ordem os itens aparecem na coluna
        //Configurar botões de interação com a tabela /adicionar gastos
        addGastos.setBounds(15, 265, 150, 30);
        addGastos.setFont(fonteBotao);
        addGastos.addActionListener(this); // isso aqui é pra poder pegar a interação com o botão no codigo
        //Configurar botões de interação com a tabela /remover gastos
        removerGastos.setFont(fonteBotao);
        removerGastos.addActionListener(this);
        removerGastos.setBounds(160, 265, 150, 30);
        //Configurar input de gastos
        valorGasto.setBounds(21, 210, 283, 50);
        valorGasto.setFont(gastosInputFont);
        //Configurar menu de seleção de dias
        comboLista.setBounds(325, 215, 50, 25);


        //configurar tela
        inicialFrame.getContentPane().setBackground(new Color(245, 232, 192)); // troca o cor do plano de fundo
        inicialFrame.setSize(400, 600); // ajusta o tamanho da tela
        inicialFrame.setLocationRelativeTo(null); // deixa a tela centralizada
        inicialFrame.setLayout(null); // isso aqui é pra gente poder definir a posição final de um componente pelo codigo la de cima
        inicialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ao clicar no X, o aplicativo fecha
        inicialFrame.setResizable(false);
        inicialFrame.setTitle("Sistema de Gastos");
        
        inicialFrame.setVisible(true); // deixar a tela visivel
    }

    //aqui é onde vai ser processado todas as interações
    @Override
    public void actionPerformed(ActionEvent e) {
        // esse comando serve pra detectar onde ocorreu uma interação
        if(e.getSource() == graficoDisplay){
            //Chamar o grafico
            GraficoGastos gfx = new GraficoGastos(gastT);
            
        }
        
        if(e.getSource() == addGastos){
            //isso aqui adiciona um novo item na tabela, pegando os valores inseridos nos respectivos botoes
            if(valorGasto.getText().replaceAll("[^\\p{Digit}]", "").isBlank()){

            }else{
                String x = valorGasto.getText().replaceAll("[^\\p{Digit}]", "");
                String y = comboLista.getSelectedItem().toString();
                //modeloTable.insertRow(0, new Object[]{x, y});
                gastT.addModeloRow(x, y);
                valorGasto.setText("");
            }
            
        }

        if(e.getSource() == removerGastos){
            //esse comando aqui remove o item selecionado na tabela, caso vc clique no botao de removerGastos
            int x = gastosLista.convertRowIndexToModel(gastosLista.getSelectedRow());
            //modeloTable.removeRow(x);
            gastT.deleteModeloRow(x);
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
