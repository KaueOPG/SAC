package br.com.github.kaueopg.sac.controller;
//Kauê Oliveira Paraízo Garcia - 202262217B

import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.model.Master;
import br.com.github.kaueopg.sac.model.Medico;
import br.com.github.kaueopg.sac.view.TelaCadastro;
import br.com.github.kaueopg.sac.view.TelaCliente;
import br.com.github.kaueopg.sac.view.TelaInicial;
import br.com.github.kaueopg.sac.view.TelaMaster;
import br.com.github.kaueopg.sac.view.TelaMedico;

import javax.swing.JOptionPane;

public class TelaInicialController {
    private TelaInicial tela;

    public TelaInicialController(TelaInicial tela)
    {
        this.tela = tela;
    }

    public void entrar(String cpf, String senha){

        Master master = new Master();
        if(master.getCpf().matches(cpf) == true)
            if(master.getSenha().matches(senha) == true)
            {
                new TelaMaster();
                tela.dispose();
                return;
            }
        
        if(ClienteController.confereVazia() == true && MedicoController.confereVazia() == true){
            JOptionPane.showMessageDialog(tela, "Nenhum usuário cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = ClienteController.procurar(cpf);
        if(cliente != null && cliente.getSenha().matches(senha) == true)
        {
            new TelaCliente(cliente);
            tela.dispose();
            return;
        } 

        Medico medico = MedicoController.procurar(cpf);
        if(medico != null && medico.getSenha().matches(senha) == true)
        {
            new TelaMedico(medico);
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