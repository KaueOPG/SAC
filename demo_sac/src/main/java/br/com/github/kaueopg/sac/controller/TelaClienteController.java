package br.com.github.kaueopg.sac.controller;
//Kauê Oliveira Paraízo Garcia - 202262217B

import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.model.Consulta;
import br.com.github.kaueopg.sac.model.Medico;
import br.com.github.kaueopg.sac.view.TelaCliente;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaClienteController {

    private TelaCliente tela;
    private Cliente cliente;

    public TelaClienteController(TelaCliente tela, Cliente cliente){
        this.cliente = cliente;
        this.tela = tela;
    }

    public void excluirConta()
    {
        ClienteController.excluir(cliente.getCpf());
        tela.dispose();
    }

    public void editarDados(String nome, String cpf, String senha)
    {
        if(ClienteController.editar(nome, cpf, senha, cliente.getCpf()) == true)
        {
            tela.dispose(); 
            new TelaCliente(cliente);
        }
        else 
            JOptionPane.showMessageDialog(tela, "CPF inválido ou já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void tabelaIniciar(DefaultTableModel consultasTabela)
    {
        List<Consulta> consultas = ConsultaController.lista();

        for(Consulta consulta: consultas)
            if(consulta.getCpfCliente().matches(cliente.getCpf()) == true)
            {
                Medico medico = MedicoController.procurar(consulta.getCpfMedico());
                if(medico != null)
                    consultasTabela.addRow(new Object[] { medico.getNome(), medico.getEspecializacao(), consulta.getData(), consulta.getHorario(), medico.getCpf() });
            }
    }

    public void excluirTabela(String cpfCliente, String cpfMedico, String data, String horario)
    {
        ConsultaController.excluir(cpfCliente, cpfMedico, data, horario);
        new TelaCliente(cliente);
        tela.dispose();
    }

    public void criarConsulta(String cpfMedico, String data, String horario)
    {
        if (data.isEmpty() == false && horario.isEmpty() == false) {
            ConsultaController.adicionar(cliente.getCpf(), cpfMedico, data, horario);
            tela.dispose();
            new TelaCliente(cliente);
        }
        else
            JOptionPane.showMessageDialog(tela, "Dado(s) inválio(s).", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
}
