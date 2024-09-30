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
    
}
