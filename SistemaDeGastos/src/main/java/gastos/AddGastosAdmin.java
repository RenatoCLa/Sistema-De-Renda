package gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BD.gastosDAO;

public class AddGastosAdmin {

    UI x = new UI();

    JFrame tela;
    JButton addGastos;
    JButton sairTela;
    JTextField tipoGasto;
    JTextField gastosValor;
    JTextField IDvalor;
    JComboBox<String> selectDia;
    JComboBox<String> selectMes;
    JLabel titulo;
    JLabel tipoTxt;
    JLabel gastoTxt;
    JLabel diaTxt;
    JLabel mesTxt;
    JLabel IDTxt;

    AddGastosAdmin() {

        tela = x.createJFrame("Adicionar Gastos", new Color(50, 100, 200), 550, 250);
        addGastos = x.createButton("Adicionar", 70, 175, 100, 25);
        titulo = x.createText("Adicionar Gastos", 155, 5, 400, 35,  new Font("SansSerif", Font.BOLD, 26), Color.white);
        tipoTxt = x.createText("Tipo", 85, 45, 125, 35,  new Font("SansSerif", Font.BOLD, 18), Color.white);
        gastoTxt = x.createText("Valor", 225, 45, 125, 35,  new Font("SansSerif", Font.BOLD, 18), Color.white);
        diaTxt = x.createText("Dia", 330, 45, 125, 35,  new Font("SansSerif", Font.BOLD, 18), Color.white);
        mesTxt = x.createText("Mês", 435, 45, 125, 35,  new Font("SansSerif", Font.BOLD, 18), Color.white);
        IDTxt = x.createText("ID", 255, 120, 125, 35,  new Font("SansSerif", Font.BOLD, 18), Color.white);;

        addGastos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            String gastoVar = gastosValor.getText().replaceAll("[^\\p{Digit}]", "");
            String tipoVar = tipoGasto.getText();
            String diaVar = selectDia.getSelectedItem().toString();
            String mesVar = selectMes.getSelectedItem().toString();
            String ID = IDvalor.getText().replaceAll("[^\\p{Digit}]", "");
            if (gastoVar.isBlank() || tipoVar.isBlank()) {
                JOptionPane.showMessageDialog(null, "Preencha os campos com informações validas!", "Erro", 0);
            } else {
                new gastosDAO().adicionarGastos(tipoVar, gastoVar, diaVar, mesVar, Integer.parseInt(ID));
                gastosValor.setText("");
                tipoGasto.setText("");
                IDvalor.setText("");
            }

                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });
        
        sairTela = x.createButton("Voltar", 365, 175, 100, 25);
        
        sairTela.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminTabela();
                tela.dispose();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

        });
        
        IDvalor = x.createTextField("", new Font("SansSerif", Font.PLAIN, 16), 240, 150, 50, 30);
        tipoGasto = x.createTextField("", new Font("SansSerif", Font.PLAIN, 16), 30, 75, 150, 30);
        gastosValor = x.createTextField("", new Font("SansSerif", Font.PLAIN, 16), 210, 75, 75, 30);
        selectDia = x.createComboBox(1, 320, 75, 50, 30, new Font("SansSerif", Font.PLAIN, 16));
        selectMes = x.createComboBox(2, 405, 75, 100, 30, new Font("SansSerif", Font.PLAIN, 16));

        tela.add(addGastos);
        tela.add(sairTela);
        tela.add(gastosValor);
        tela.add(tipoGasto);
        tela.add(selectDia);
        tela.add(selectMes);
        tela.add(IDvalor);
        tela.add(tipoTxt);
        tela.add(titulo);
        tela.add(gastoTxt);
        tela.add(diaTxt);
        tela.add(mesTxt);
        tela.add(IDTxt);

        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setVisible(true);
    }
}
