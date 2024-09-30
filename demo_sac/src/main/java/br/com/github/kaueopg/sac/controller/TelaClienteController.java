package br.com.github.kaueopg.sac.controller;

import br.com.github.kaueopg.sac.model.Cliente;
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
        ClienteController.excluir(cliente);
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
            ClienteController.editar(cliente);       
            new TelaCliente(cliente);
            tela.dispose();
        }
        return verificaAlteracoes;
    }
    
}
