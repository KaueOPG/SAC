package br.com.github.kaueopg.sac.controller;

import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.model.Consulta;
import br.com.github.kaueopg.sac.model.Medico;
import br.com.github.kaueopg.sac.view.TelaMaster;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MasterController {

    private List<Medico> medicos = MedicoController.lista();
    private List<Cliente> clientes = ClienteController.lista();
    private List<Consulta> consultas = ConsultaController.lista();

    private TelaMaster tela;

    public MasterController(TelaMaster tela)
    {
        this.tela = tela;
    }

    public void imprimeTabela(DefaultTableModel modelo, String tipoTabela){
        if(tipoTabela.matches("medico") == true && medicos.isEmpty() == false)
        {
            for(Medico medico: medicos)
                modelo.addRow(new Object[]{medico.getNome(), medico.getCpf(),medico.getSenha(), medico.getEspecializacao(), medico.getValor()});
        }
        else if(tipoTabela.matches("cliente") == true && clientes.isEmpty() == false)
        {
            for(Cliente cliente: clientes)
                modelo.addRow(new Object[]{cliente.getNome(), cliente.getCpf(),cliente.getSenha()});
        }
        else if(tipoTabela.matches("consulta") == true && consultas.isEmpty() == false)
        {
            for(Consulta consulta: consultas)
                modelo.addRow(new Object[]{consulta.getCpfCliente(), consulta.getCpfMedico(), consulta.getData(), consulta.getHorario()});
        }
    }

    public void excluir(JTable tabela, int selectedRow,String tipo)
    {
        if(tipo.matches("medico") == true)
            MedicoController.excluir(tabela.getValueAt(selectedRow, 1).toString());            
        else if(tipo.matches("cliente") == true)
            ClienteController.excluir(tabela.getValueAt(selectedRow, 1).toString());
        else if(tipo.matches("consulta") == true)
            ConsultaController.excluir(tabela.getValueAt(selectedRow, 0).toString(), tabela.getValueAt(selectedRow, 1).toString(), tabela.getValueAt(selectedRow, 2).toString(), tabela.getValueAt(selectedRow, 3).toString());
        new TelaMaster();
        tela.dispose();
    }

    public void adicionarCliente() {
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
    
    public void editarCliente(JTable tabela) {

        int selectedRow = tabela.getSelectedRow();

        if (selectedRow >= 0) {
            String cpfAtual = tabela.getValueAt(selectedRow, 1).toString();

            JTextField nome = new JTextField(tabela.getValueAt(selectedRow, 0).toString());
            JTextField cpf = new JTextField(tabela.getValueAt(selectedRow, 1).toString());
            JTextField senha = new JTextField(tabela.getValueAt(selectedRow, 2).toString());
    
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

    public void adicionarConsutas() {
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

    public void adicionarMedico() {

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
                MedicoController.adicionar(nome.getText(), cpf.getText(), senha.getText(), especializacao.getText(), Double.parseDouble(valor.getText()));
                new TelaMaster();
                tela.dispose();
            }
        }
    }

    public void editarMedico(JTable tabela) {
        int selectedRow = tabela.getSelectedRow();

        if (selectedRow >= 0) {
            String cpfAtual = tabela.getValueAt(selectedRow, 1).toString();
            JTextField nome = new JTextField(tabela.getValueAt(selectedRow, 0).toString());
            JTextField cpf = new JTextField(tabela.getValueAt(selectedRow, 1).toString());
            JTextField senha = new JTextField(tabela.getValueAt(selectedRow, 2).toString());
            JTextField especializacao = new JTextField(tabela.getValueAt(selectedRow, 3).toString());
            JTextField valor = new JTextField(tabela.getValueAt(selectedRow, 4).toString());

            Object[] campos = {
                "Nome:", nome,
                "CPF:", cpf,
                "Senha:", senha,
                "Especialização:", especializacao,
                "Valor:", valor
            };

            int option = JOptionPane.showConfirmDialog(null, campos, "Editar Médico", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                if(ValidarCPF.validaCPF(cpf.getText()) == false)
                {
                    JOptionPane.showMessageDialog(tela, "CPF inválido ou já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(MedicoController.editar(nome.getText(), cpf.getText(), senha.getText(), especializacao.getText(), Double.parseDouble(valor.getText()), cpfAtual) == false)
                    return;
                new TelaMaster();
                tela.dispose();
            }
        }
    }

}
