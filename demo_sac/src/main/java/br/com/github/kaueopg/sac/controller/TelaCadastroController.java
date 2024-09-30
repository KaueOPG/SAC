package br.com.github.kaueopg.sac.controller;

import br.com.github.kaueopg.sac.view.TelaCadastro;
import br.com.github.kaueopg.sac.view.TelaCliente;
import br.com.github.kaueopg.sac.view.TelaInicial;

import javax.swing.JOptionPane;

public class TelaCadastroController {
    private TelaCadastro tela;

    public TelaCadastroController(TelaCadastro tela)
    {
        this.tela = tela;
    }

    public void finalizar(String cpf, String nome, String senha)
    {
        if(ValidarCPF.validaCPF(cpf) == false)
        {
            JOptionPane.showMessageDialog(tela, "CPF inválido ou já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        new TelaCliente(ClienteController.adicionar(cpf, nome, senha));
        tela.dispose();
    }

    public void cancelar()
    {
        new TelaInicial();
        tela.dispose();
    }
}
