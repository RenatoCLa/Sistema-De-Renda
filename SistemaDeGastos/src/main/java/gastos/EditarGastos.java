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

public class EditarGastos {

    UI x = new UI();

    JFrame tela;
    JButton addGastos;
    JButton sairTela;
    JTextField tipoGasto;
    JTextField gastosValor;
    JComboBox<String> selectDia;
    JComboBox<String> selectMes;

    EditarGastos() {

        tela = x.createJFrame("Editar dados", new Color(50, 100, 200), 800, 400);
        addGastos = x.createButton("Salvar", 25, 250, 100, 50);
        addGastos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            String gastoVar = gastosValor.getText().replaceAll("[^\\p{Digit}]", "");
            String tipoVar = tipoGasto.getText();
            String diaVar = selectDia.getSelectedItem().toString();
            String mesVar = selectMes.getSelectedItem().toString();
            int ID = userID.getID();
            if (gastoVar.isBlank() || tipoVar.isBlank()) {
                JOptionPane.showMessageDialog(null, "Preencha os campos com informações validas!", "Erro", 0);
            } else {
                new gastosDAO().adicionarGastos(tipoVar, gastoVar, diaVar, mesVar, ID);
            }

                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });
        sairTela = x.createButton("Voltar", 600, 300, 100, 50);
        sairTela.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuInicial();
                tela.dispose();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

        });
        tipoGasto = x.createTextField("oi", new Font("SansSerif", Font.PLAIN, 16), 200, 50, 125, 30);
        gastosValor = x.createTextField("a", new Font("SansSerif", Font.PLAIN, 16), 0, 50, 75, 30);
        selectDia = x.createComboBox(1, 350, 50, 50, 30, new Font("SansSerif", Font.PLAIN, 16));
        selectMes = x.createComboBox(2, 450, 50, 100, 30, new Font("SansSerif", Font.PLAIN, 16));

        tela.add(addGastos);
        tela.add(sairTela);
        tela.add(gastosValor);
        tela.add(tipoGasto);
        tela.add(selectDia);
        tela.add(selectMes);
        tela.setVisible(true);
    }

    public static void main(String[] args) {
        new AdicionarGastos();
    }
}
