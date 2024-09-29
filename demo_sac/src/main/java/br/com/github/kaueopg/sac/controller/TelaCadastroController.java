package br.com.github.kaueopg.sac.controller;

import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.persistence.ClientePersistence;
import br.com.github.kaueopg.sac.view.TelaCadastro;
import br.com.github.kaueopg.sac.view.TelaCliente;
import br.com.github.kaueopg.sac.view.TelaInicial;

import java.util.List;
import javax.swing.JOptionPane;

public class TelaCadastroController {
    private TelaCadastro tela;

    public TelaCadastroController(TelaCadastro tela)
    {
        this.tela = tela;
    }

    public void finalizar(String cpf, String nome, String senha)
    {
        ClientePersistence clientePersistence = new ClientePersistence();
        List<Cliente> clientes = clientePersistence.findAll();

        if(ValidarCPF.validaCPF(cpf) == false)
        {
            JOptionPane.showMessageDialog(tela, "CPF inválido ou já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Cliente cliente = new Cliente(nome,cpf, senha);
        clientes.add(cliente);
        clientePersistence.save(clientes);
        new TelaCliente(cliente);
        tela.dispose();
    }

    public void cancelar()
    {
        new TelaInicial();
        tela.dispose();
    }
}
