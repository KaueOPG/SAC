package br.com.github.kaueopg.sac.controller;

import java.util.List;

import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.persistence.ClientePersistence;
import br.com.github.kaueopg.sac.view.TelaCliente;

public class TelaClienteController {

    private TelaCliente tela;
    private Cliente cliente;

    public TelaClienteController(TelaCliente tela, Cliente cliente){
        this.tela = tela;
        this.cliente = cliente;
    }

    public void excluirConta()
    {
        ClientePersistence clientePersistence = new ClientePersistence();
        List<Cliente> clientes = clientePersistence.findAll();
        clientes.remove(cliente);
        clientePersistence.save(clientes);
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
            cliente.setSenha(senha);
            verificaAlteracoes = true;
        }
        if(verificaAlteracoes == true)
        {
            ClientePersistence clientePersistence = new ClientePersistence();
            List<Cliente> clientes = clientePersistence.findAll();
            clientePersistence.save(clientes);
        }
        return verificaAlteracoes;
    }
    
}
