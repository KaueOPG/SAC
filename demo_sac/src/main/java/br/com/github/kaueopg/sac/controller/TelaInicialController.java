package br.com.github.kaueopg.sac.controller;

import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.persistence.ClientePersistence;
import br.com.github.kaueopg.sac.view.TelaCadastro;
import br.com.github.kaueopg.sac.view.TelaCliente;
import br.com.github.kaueopg.sac.view.TelaInicial;

import java.util.List;
import javax.swing.JOptionPane;

public class TelaInicialController {
    private TelaInicial tela;

    public TelaInicialController(TelaInicial tela)
    {
        this.tela = tela;
    }

    public void entrar(String cpf, String senha){
        ClientePersistence clientePersistence = new ClientePersistence();
        List<Cliente> clientes = clientePersistence.findAll();
        
        if(clientes.isEmpty() == true){
            JOptionPane.showMessageDialog(tela, "Nenhum cliente cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for(Cliente cliente: clientes)
            if(cliente.getCpf().matches(cpf) == true)
                if(cliente.getSenha().matches(senha) == true)
                {
                    new TelaCliente();
                    tela.dispose();
                    return;
                }

        JOptionPane.showMessageDialog(tela, "CPF ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void cadastrar(){
        new TelaCadastro();
        tela.dispose();
    }
}