package br.com.github.kaueopg.sac.view;

import br.com.github.kaueopg.sac.controller.MasterController;
import br.com.github.kaueopg.sac.controller.MedicoControler;
import br.com.github.kaueopg.sac.controller.ValidarCPF;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class BotoesMedicoMaster{
    public static void adicionar(DefaultTableModel modelo,  TelaMaster tela) {
        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();
        JTextField senha = new JTextField();
        JTextField especializacao = new JTextField();
        JTextField valor = new JTextField();

        Object[] campos = {
            "Nome:", nome,
            "CPF:", cpf,
            "Senha:", senha,
            "Especialização:", especializacao,
            "Valor:", valor
        };

        int option = JOptionPane.showConfirmDialog(null, campos, "Adicionar Médico", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if(ValidarCPF.validaCPF(cpf.getText()) == false)
            {
                JOptionPane.showMessageDialog(tela, "CPF inválido ou já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                MedicoControler.adicionar(nome.getText(), cpf.getText(), senha.getText(), especializacao.getText(), Double.parseDouble(valor.getText()));
                modelo.addRow(new Object[]{nome.getText(), cpf.getText(), senha.getText(), especializacao.getText(), valor.getText()});
            }
        }
    }

    public static void editar(JTable tabela, DefaultTableModel modelo, TelaMaster master) {
        int selectedRow = tabela.getSelectedRow();
        String cpfAtual = modelo.getValueAt(selectedRow, 1).toString();

        if (selectedRow >= 0) {
            JTextField nome = new JTextField(modelo.getValueAt(selectedRow, 0).toString());
            JTextField cpf = new JTextField(modelo.getValueAt(selectedRow, 1).toString());
            JTextField senha = new JTextField(modelo.getValueAt(selectedRow, 2).toString());
            JTextField especializacao = new JTextField(modelo.getValueAt(selectedRow, 3).toString());
            JTextField valor = new JTextField(modelo.getValueAt(selectedRow, 4).toString());

            Object[] campos = {
                "Nome:", nome,
                "CPF:", cpf,
                "Senha:", senha,
                "Especialização:", especializacao,
                "Valor:", valor
            };

            int option = JOptionPane.showConfirmDialog(null, campos, "Editar Médico", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                MedicoControler.editar(nome.getText(), cpf.getText(), senha.getText(), especializacao.getText(), Double.parseDouble(valor.getText()), cpfAtual);
            }
        }
    }

    public static void excluir(JTable tabela, DefaultTableModel modelo) {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow >= 0) {
            MedicoControler.excluir(modelo.getValueAt(selectedRow, 1).toString());
        }
    }
}
