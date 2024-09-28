package br.com.github.kaueopg.sac.view;

import br.com.github.kaueopg.sac.controller.TelaCadastroController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class TelaCadastro extends JFrame{
        private JPanel painel = new JPanel();
    private Border borda = BorderFactory.createLineBorder(Color.GRAY, 1);

    private JTextField nome;
    private JTextField cpf;
    private JPasswordField senha;
    private TelaCadastroController control;

    public TelaCadastro() {
        configurarJanela();
        JPanel painel = criarPainel();
        add(painel);
        setVisible(true);
    }

    private void configurarJanela() {
        setTitle("Tela de Cadastro");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setResizable(false); 
    }

    private JPanel criarPainel() {
        painel.setLayout(new GridLayout(5, 1, 10, 10));
        campos();
        botoes(); 
        return painel;
    }

    private void campos(){
        nome = new JTextField();
        nome.setBorder(BorderFactory.createTitledBorder(borda, "Nome"));
        painel.add(nome);

        cpf = new JTextField();
        cpf.setBorder(BorderFactory.createTitledBorder(borda, "CPF"));
        painel.add(cpf); 

        senha = new JPasswordField();
        senha.setBorder(BorderFactory.createTitledBorder(borda, "Senha"));
        painel.add(senha);
    }

    private void botoes() {

        JButton botaoFinalizar = new JButton("Finalizar Cadastro");
        botaoFinalizar.setBorder(borda);
        botaoFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.finalizar(cpf.getText(),  nome.getText(), new String(senha.getPassword()));
            }
        });
        painel.add(botaoFinalizar);

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBorder(borda);
        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.cancelar();
            }
        });
        painel.add(botaoCancelar); 
    }
}
