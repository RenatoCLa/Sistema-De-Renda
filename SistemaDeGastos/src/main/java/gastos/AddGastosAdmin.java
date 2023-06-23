package gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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

    AddGastosAdmin() {

        tela = x.createJFrame("Adicionar Gastos", new Color(50, 100, 200), 800, 400);
        addGastos = x.createButton("Adicionar", 25, 250, 100, 50);
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
            }

                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });
        sairTela = x.createButton("Voltar", 600, 300, 100, 50);
        sairTela.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminTabela();
                tela.dispose();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

        });
        IDvalor = x.createTextField("", new Font("SansSerif", Font.PLAIN, 16), 350, 150, 125, 30);
        tipoGasto = x.createTextField("", new Font("SansSerif", Font.PLAIN, 16), 200, 50, 125, 30);
        gastosValor = x.createTextField("", new Font("SansSerif", Font.PLAIN, 16), 0, 50, 75, 30);
        selectDia = x.createComboBox(1, 350, 50, 50, 30, new Font("SansSerif", Font.PLAIN, 16));
        selectMes = x.createComboBox(2, 450, 50, 100, 30, new Font("SansSerif", Font.PLAIN, 16));

        tela.add(addGastos);
        tela.add(sairTela);
        tela.add(gastosValor);
        tela.add(tipoGasto);
        tela.add(selectDia);
        tela.add(selectMes);
        tela.add(IDvalor);
        tela.setVisible(true);
    }
}