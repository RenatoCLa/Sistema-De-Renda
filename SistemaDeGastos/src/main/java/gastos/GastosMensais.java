package gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import BD.gastosDAO;

public class GastosMensais {
    
    UI ui = new UI();

    JFrame tela;
    JLabel titulo;
    JButton calcular;
    JComboBox<String> selMes;
    JLabel valor;

    GastosMensais(){

        tela = ui.createJFrame("Calcular Gastos Mensais", new Color(50, 100, 200), 350, 225);
        titulo = ui.createText("Calcular gastos de:", 15, 15, 250, 35, new Font("SansSerif", Font.BOLD, 22), Color.white);
        selMes = ui.createComboBox(2, 215, 15, 100, 35, new Font("SansSerif", Font.BOLD, 16));
        valor = ui.createText("Gastos:R$00,00", 15, 135, 250, 35, new Font("SansSerif", Font.BOLD, 22), Color.white);
        calcular = ui.createButton("Gerar Gastos", 15, 100, 115, 35);

        calcular.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = new gastosDAO().getValues(String.valueOf(userID.getID()), selMes.getSelectedItem().toString());
                int soma = 0;
                try {
                    
                    while(rs.next()){
                        soma += rs.getInt(1);
                        System.out.println(soma);
                    }

                    if(soma < 10){
                        valor.setText("Gastos:R$0"+soma+",00");
                    }else{
                        valor.setText("Gastos:R$"+soma+",00");
                    }
                    
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "gerarCalculo" + e1);
                }
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        tela.add(titulo);
        tela.add(selMes);
        tela.add(valor);
        tela.add(calcular);

        tela.setVisible(true);
    }
}
