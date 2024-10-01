package br.com.github.kaueopg.sac.view;

import javax.swing.table.DefaultTableModel;

import br.com.github.kaueopg.sac.controller.ConsultaController;

import javax.swing.*;

public class BotoesConsultaMaster{

    private TelaMaster tela;
    private DefaultTableModel modelo;

    public BotoesConsultaMaster(TelaMaster tela, DefaultTableModel modelo)
    {
        this.tela = tela;
        this.modelo = modelo;
    }

    public void adicionar() {
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
            ConsultaController.adicionar(cpfCliente.getText(), cpfMedico.getText(), data.getText(), horario.getText());
            new TelaMaster();
            tela.dispose();
        }
    }

    public void excluir(JTable tabela) {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow >= 0) {
            String cpfCliente = tabela.getValueAt(selectedRow, 0).toString();
            String cpfMedico = tabela.getValueAt(selectedRow, 1).toString();
            String data = tabela.getValueAt(selectedRow, 2).toString();
            String horario = tabela.getValueAt(selectedRow, 3).toString();
            ConsultaController.excluir(cpfCliente, cpfMedico, data, horario);
            new TelaMaster();
            tela.dispose();
        }
    }    
}