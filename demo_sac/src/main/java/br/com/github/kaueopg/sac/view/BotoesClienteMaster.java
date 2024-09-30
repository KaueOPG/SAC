package br.com.github.kaueopg.sac.view;

import javax.swing.table.DefaultTableModel;

import br.com.github.kaueopg.sac.controller.ClienteController;
import br.com.github.kaueopg.sac.controller.ValidarCPF;

import javax.swing.*;

public class BotoesClienteMaster{

    private TelaMaster tela;
    private DefaultTableModel modelo;

    public BotoesClienteMaster(TelaMaster tela, DefaultTableModel modelo)
    {
        this.tela = tela;
        this.modelo = modelo;
    }

    public void adicionar() {
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
            if(ValidarCPF.validaCPF(cpf.getText()) == false)
            {
                JOptionPane.showMessageDialog(tela, "CPF inválido ou já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                ClienteController.adicionar(nome.getText(), cpf.getText(), new String(senha.getPassword()));
                new TelaMaster();
                tela.dispose();
            }
        }
    }
    
    public void editar(JTable tabela) {

        int selectedRow = tabela.getSelectedRow();
        String cpfAtual = modelo.getValueAt(selectedRow, 1).toString();

        if (selectedRow >= 0) {
            JTextField nome = new JTextField(modelo.getValueAt(selectedRow, 0).toString());
            JTextField cpf = new JTextField(modelo.getValueAt(selectedRow, 1).toString());
            JTextField senha = new JTextField(modelo.getValueAt(selectedRow, 2).toString());
    
            Object[] campos = {
                "Nome:", nome,
                "CPF:", cpf,
                "Senha:", senha
            };
    
            int option = JOptionPane.showConfirmDialog(null, campos, "Editar Cliente", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                if(ValidarCPF.validaCPF(cpf.getText()) == false)
                {
                    JOptionPane.showMessageDialog(tela, "CPF inválido ou já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(ClienteController.editar(nome.getText(), cpf.getText(), senha.getText(), cpfAtual) == false)
                    return;
                new TelaMaster();
                tela.dispose();
            }
        }
    }

    public void excluir(JTable tabela) {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow >= 0) {
            ClienteController.excluir(modelo.getValueAt(selectedRow, 1).toString());
            new TelaMaster();
            tela.dispose();
        }
    }    
    
}
