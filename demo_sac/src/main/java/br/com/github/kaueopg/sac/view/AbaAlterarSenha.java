package br.com.github.kaueopg.sac.view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import br.com.github.kaueopg.sac.controller.TelaMedicoController;

public class AbaAlterarSenha extends JDialog{

    private JPasswordField novaSenha;

    public AbaAlterarSenha(TelaMedico tela, TelaMedicoController control)
    {
        super(tela, "Alterar Senha - Medico", true);
        setLayout(new GridLayout(4, 2, 5, 10));
        setSize(300, 200);
        setLocationRelativeTo(tela);

        novaSenha = new JPasswordField();

        add(new JLabel("Senha:"));
        add(novaSenha);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (control.alterarSenha(new String(novaSenha.getPassword())) == true)
                    dispose(); 
                else {
                    JOptionPane.showMessageDialog(AbaAlterarSenha.this, "Digite uma senha válida.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(new JLabel());
        add(botaoSalvar);
    }
}
