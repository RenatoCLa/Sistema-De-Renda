package gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class GraficoGastos {
    
    JFrame tela = new JFrame();

    Gastos table;

    JLabel displayGastos = new JLabel("");
    JLabel titulo = new JLabel("Gastos do dia :");

    String[] x = {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
                    "20","21","22","23","24","25","26","27","28","29","30","31"};

    JComboBox<String> comboLista = new JComboBox<String>(x);

    Font fonte01 = new Font("SansSerif", Font.BOLD, 24);
    Font fonte02 = new Font("SansSerif", Font.BOLD, 30);
    Font fonte03 = new Font("SansSerif", Font.BOLD, 18);
    Font fonte04 = new Font("SansSerif", Font.BOLD, 42);

    GraficoGastos(Gastos gastT){
        
        tela.add(displayGastos);
        tela.add(titulo);
        tela.add(comboLista);

        comboLista.setBounds(230, 40, 50, 25);
        comboLista.setFont(fonte03);
        comboLista.setForeground(Color.black);
        comboLista.setSelectedItem(-1);
        titulo.setBounds(10, 25, 250, 50);
        titulo.setFont(fonte02);
        titulo.setForeground(Color.white);

        comboLista.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange()==ItemEvent.SELECTED){
                    if(comboLista.getSelectedItem().toString() == ""){

                    }else{
                        displayGastos.setText(calcularGastos(Integer.parseInt(comboLista.getSelectedItem()+"")));
                    }
                    
                }
            }
        });

        displayGastos.setBounds(25,125,300,75);
        displayGastos.setFont(fonte04);
        displayGastos.setForeground(Color.white);

        table = gastT;

        tela.setSize(300, 250);
        tela.setLayout(null);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);
        tela.getContentPane().setBackground(new Color(245, 232, 192));
        tela.setResizable(false);
        tela.setVisible(true);
        
        
    }
    
    public String calcularGastos(int diaX){
        int gast = 0;
        for(int i = 0; i < table.getRowQuant(); i++){
            int diaY = table.calcularQuant(i, 1);;
            if(diaY == diaX){
                int quant = table.calcularQuant(i, 0);
                gast += quant;
            }
            
        }
        String x = "R$" + String.valueOf(gast)+ ",00";
        return x;
    }
}
