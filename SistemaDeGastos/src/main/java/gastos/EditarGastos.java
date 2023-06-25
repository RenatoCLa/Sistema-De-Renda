package gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BD.gastosDAO;

public class EditarGastos {

    UI x = new UI();

    JFrame tela;
    JButton editarGastos;
    JButton sairTela;
    JTextField tipoGasto;
    JTextField gastosValor;
    JComboBox<String> selectDia;
    JComboBox<String> selectMes;

    EditarGastos(String ID) throws SQLException {

        tela = x.createJFrame("Adicionar Gastos", new Color(50, 100, 200), 550, 250);
        addGastos = x.createButton("Adicionar", 75, 175, 100, 25);
        titulo = x.createText("Adicionar Gastos", 155, 5, 400, 35,  new Font("SansSerif", Font.BOLD, 26), Color.white);
        tipoTxt = x.createText("Tipo", 85, 45, 125, 35,  new Font("SansSerif", Font.BOLD, 18), Color.white);
        gastoTxt = x.createText("Valor", 225, 45, 125, 35,  new Font("SansSerif", Font.BOLD, 18), Color.white);
        diaTxt = x.createText("Dia", 330, 45, 125, 35,  new Font("SansSerif", Font.BOLD, 18), Color.white);
        mesTxt = x.createText("Mês", 435, 45, 125, 35,  new Font("SansSerif", Font.BOLD, 18), Color.white);
        editarGastos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            String gastoVar = gastosValor.getText().replaceAll("[^\\p{Digit}]", "");
            String tipoVar = tipoGasto.getText();
            String diaVar = selectDia.getSelectedItem().toString();
            String mesVar = selectMes.getSelectedItem().toString();
            if (gastoVar.isBlank() || tipoVar.isBlank()) {
                JOptionPane.showMessageDialog(null, "Preencha os campos com informações validas!", "Erro", 0);
            } else {
                new gastosDAO().editarGastos(tipoVar, gastoVar, diaVar, mesVar, ID);
                if(userID.getID() == 1){
                    new AdminTabela();
                }else{
                    new MenuInicial();
                }                
                tela.dispose();
            }

                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });
        
        sairTela = x.createButton("Voltar", 365, 175, 100, 25);
        
        sairTela.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(userID.getID() == 1){
                    new AdminTabela();
                }else{
                    new MenuInicial();
                }                
                tela.dispose();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

        });
        
        ResultSet rs = new gastosDAO().getValues(ID);

        tipoGasto = x.createTextField(rs.getString("tipo"), new Font("SansSerif", Font.PLAIN, 16), 200, 50, 125, 30);
        gastosValor = x.createTextField(rs.getString("gastos"), new Font("SansSerif", Font.PLAIN, 16), 0, 50, 75, 30);
        selectDia = x.createComboBox(1, 350, 50, 50, 30, new Font("SansSerif", Font.PLAIN, 16));
        selectDia.setSelectedItem(rs.getString("dia"));
        selectMes = x.createComboBox(2, 450, 50, 100, 30, new Font("SansSerif", Font.PLAIN, 16));
        selectMes.setSelectedItem(rs.getString("mes"));

        tela.add(editarGastos);
        tela.add(sairTela);
        tela.add(gastosValor);
        tela.add(tipoGasto);
        tela.add(selectDia);
        tela.add(selectMes);
        tela.setVisible(true);
    }
}
