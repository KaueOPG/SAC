package br.com.github.kaueopg.sac.view;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class BotoesConsultaMaster{

    public static void adicionar(DefaultTableModel modelo) {
        JTextField cpfCliente = new JTextField();
        JTextField cpfMedico = new JTextField();
        JTextField data = new JTextField();
        JTextField horario = new JTextField();
    
        Object[] campos = {
            "CPF Cliente:", cpfCliente,
            "CPF Médico:", cpfMedico,
            "Data:", data,
            "Horário:", horario
        };
    
        int option = JOptionPane.showConfirmDialog(null, campos, "Adicionar Consulta", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            modelo.addRow(new Object[]{cpfCliente.getText(), cpfMedico.getText(), data.getText(), horario.getText()});
        }
    }

    public static void excluir(JTable tabela, DefaultTableModel modelo) {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow >= 0) {
            modelo.removeRow(selectedRow);
        }
    }    
    
}