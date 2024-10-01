package br.com.github.kaueopg.sac.controller;

import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.model.Consulta;
import br.com.github.kaueopg.sac.model.Medico;
import br.com.github.kaueopg.sac.persistence.ConsultaPersistence;
import br.com.github.kaueopg.sac.view.TelaCliente;
import java.util.List;

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

    public boolean editarDados(String nome, String cpf, String senha)
    {
        boolean verifica = ClienteController.editar(nome, cpf, senha, cliente.getCpf());
        if(verifica == true)
            new TelaCliente(cliente);
        return verifica;
    }

    public void tabelaIniciar(DefaultTableModel consultasTabela)
    {
        ConsultaPersistence consultaPersistence = new ConsultaPersistence();
        List<Consulta> consultas = consultaPersistence.findAll();

        for(Consulta consulta: consultas)
            if(consulta.getCpfCliente().matches(cliente.getCpf()) == true)
            {
                Medico medico = MedicoController.procurar(consulta.getCpfMedico());
                if(medico != null)
                    consultasTabela.addRow(new Object[] { medico.getNome(), medico.getEspecializacao(), consulta.getData(), consulta.getHorario(), medico.getCpf() });
            }
    }
    
}
