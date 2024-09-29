package br.com.github.kaueopg.sac.controller;

import java.util.List;

import java.util.ArrayList;
import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.persistence.ClientePersistence;
import br.com.github.kaueopg.sac.view.TelaCliente;

public class TelaClienteController {

    private TelaCliente tela;
    private Cliente cliente;

    public TelaClienteController(TelaCliente tela, Cliente cliente){
        this.cliente = cliente;
        this.tela = tela;
    }

    public void excluirConta()
    {
        ClientePersistence clientePersistence = new ClientePersistence();
        List<Cliente> clientes = clientePersistence.findAll(); 
        List<Cliente> clientesAtualizados = new ArrayList<>();
        for(Cliente clienteDif: clientes)
            if(clienteDif.getCpf().matches(cliente.getCpf()) == false)
                clientesAtualizados.add(clienteDif);
        clientePersistence.save(clientesAtualizados); 
        tela.dispose();
    }

    public boolean editarDados(String nome, String cpf, String senha)
    {
        boolean verificaAlteracoes = false;
        if(nome.isEmpty() == false)
        {
            cliente.setNome(nome);
            verificaAlteracoes = true;
        }
        if(senha.isEmpty() == false)
        {
            cliente.setSenha(senha);
            verificaAlteracoes = true;
        }
        if(ValidarCPF.validaCPF(cpf) == true && cpf.isEmpty() == false)
        {
            cliente.setCpf(cpf);
            verificaAlteracoes = true;
        }
        if(verificaAlteracoes == true)
        {
            ClientePersistence clientePersistence = new ClientePersistence();
            List<Cliente> clientes = clientePersistence.findAll();

            for(Cliente clienteAntigo : clientes)
                if(clienteAntigo.getCpf().matches(cliente.getCpf()))
                {
                    clientes.remove(clienteAntigo);
                    clientes.add(cliente);
                    break;
                }
                
            new TelaCliente(cliente);
            tela.dispose();
            clientePersistence.save(clientes);
        }
        return verificaAlteracoes;
    }
    
}
