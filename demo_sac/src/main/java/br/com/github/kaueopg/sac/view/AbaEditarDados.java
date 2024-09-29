package br.com.github.kaueopg.sac.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import br.com.github.kaueopg.sac.controller.TelaClienteController;

public class AbaEditarDados extends JDialog {

    private JTextField novoNome;
    private JTextField novoCPF;
    private JPasswordField novaSenha;
    
    public AbaEditarDados(TelaCliente tela, TelaClienteController control) {
        super(tela, "Editar Dados do Cliente", true);
        setLayout(new GridLayout(4, 2, 5, 10));
        setSize(300, 200);
        setLocationRelativeTo(tela);

        novoNome = new JTextField();
        novoCPF = new JTextField();
        novaSenha = new JPasswordField();

        add(new JLabel("Nome:"));
        add(novoNome);
        add(new JLabel("CPF:"));
        add(novoCPF);
        add(new JLabel("Senha:"));
        add(novaSenha);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (control.editarDados(novoNome.getText(), novoCPF.getText(), new String(novaSenha.getPassword())) == true)
                    dispose(); 
                else {
                    JOptionPane.showMessageDialog(AbaEditarDados.this, "CPF inválido ou já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(new JLabel());
        add(botaoSalvar);
    }
}