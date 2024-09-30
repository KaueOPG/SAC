package br.com.github.kaueopg.sac.view;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class BotoesClienteMaster{

    public static void adicionar(DefaultTableModel modelo) {
        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();
        JPasswordField senha = new JPasswordField();
    
        Object[] campos = {
            "Nome:", nome,
            "CPF:", cpf,
            "Senha:", senha
        };
    
        int option = JOptionPane.showConfirmDialog(null, campos, "Adicionar Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            modelo.addRow(new Object[]{nome.getText(), cpf.getText(), new String(senha.getPassword())});
        }
    }
    
    public static void editar(JTable tabela, DefaultTableModel modelo) {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow >= 0) {
            JTextField nome = new JTextField(modelo.getValueAt(selectedRow, 0).toString());
            JTextField cpf = new JTextField(modelo.getValueAt(selectedRow, 1).toString());
            JPasswordField senha = new JPasswordField(modelo.getValueAt(selectedRow, 2).toString());
    
            Object[] campos = {
                "Nome:", nome,
                "CPF:", cpf,
                "Senha:", senha
            };
    
            int option = JOptionPane.showConfirmDialog(null, campos, "Editar Cliente", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                modelo.setValueAt(nome.getText(), selectedRow, 0);
                modelo.setValueAt(cpf.getText(), selectedRow, 1);
                modelo.setValueAt(new String(senha.getPassword()), selectedRow, 2);
            }
        }
    }

    public static void excluir(JTable tabela, DefaultTableModel modelo) {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow >= 0) {
            modelo.removeRow(selectedRow);
        }
    }    
    
}
