package br.com.github.kaueopg.sac.view;
//Kauê Oliveira Paraízo Garcia - 202262217B

import br.com.github.kaueopg.sac.controller.TelaMedicoController;
import br.com.github.kaueopg.sac.model.Medico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class TelaMedico extends JFrame{

    private JPanel painelDados = new JPanel();
    private JPanel painelBotoes = new JPanel();
    private JPanel painelAgendamentos = new JPanel();
    private Border borda = BorderFactory.createLineBorder(Color.GRAY, 1);
    
    private JTextField nome;
    private JTextField cpf;
    private JPasswordField senha;
    private TelaMedicoController control;
    private Medico medico;

    public TelaMedico(Medico medico) {
        this.medico = medico;
        control = new TelaMedicoController(this,medico);
        
        configurarJanela();
        criaPainelDados();  
        criaPainelConsultas();  

        setVisible(true);
        pack();
        setLocationRelativeTo(null);  
    }

    private void configurarJanela() {
        setTitle("Medico - Consultas Marcadas");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void criaPainelDados() {
        dados();
        botaoAlterarSenha();
        painelDados.add(painelBotoes);
        getContentPane().add(painelDados, BorderLayout.WEST);
    }

    private void dados() {
        painelDados.setBorder(BorderFactory.createTitledBorder("Informações do Cliente"));
        painelDados.setLayout(new GridLayout(4, 1, 10, 10));

        nome = new JTextField();
        nome.setBorder(BorderFactory.createTitledBorder(borda, "Nome"));
        painelDados.add(nome);
        nome.setText(medico.getNome());

        cpf = new JTextField();
        cpf.setBorder(BorderFactory.createTitledBorder(borda, "CPF"));
        painelDados.add(cpf);
        cpf.setText(medico.getCpf());

        senha = new JPasswordField();
        senha.setBorder(BorderFactory.createTitledBorder(borda, "Senha"));
        painelDados.add(senha);
        senha.setText(medico.getSenha());
    }

    private void botaoAlterarSenha() {
        JButton botaoEditar = new JButton("Editar Dados");
        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterarSenha();
            }
        });
        painelBotoes.add(botaoEditar);
    }

    private void criaPainelConsultas() {
        campos();

        String[] colunas = { "CPF do Cliente", "Data", "Hora" };
        DefaultTableModel consultasTabela = new DefaultTableModel(colunas, 0);
        JTable Consultas = new JTable(consultasTabela);

        painelAgendamentos.add(new JScrollPane(Consultas), BorderLayout.CENTER);
        getContentPane().add(painelAgendamentos, BorderLayout.EAST);

        control.tabela(consultasTabela);
    }

    private void campos()
    {
        painelAgendamentos.setBorder(BorderFactory.createTitledBorder("Consultas Marcadas"));
        painelAgendamentos.setPreferredSize(new Dimension(300, 350));
        painelAgendamentos.setLayout(new BorderLayout());
    }

    private void alterarSenha() {
        JDialog aba = new JDialog(TelaMedico.this, "Alterar Senha - Médico", true);
        aba.setLayout(new GridLayout(4, 2, 5, 10));
        aba.setSize(300, 200);
        aba.setLocationRelativeTo(TelaMedico.this);

        JPasswordField novaSenha = new JPasswordField();

        aba.add(new JLabel("Senha:"));
        aba.add(novaSenha);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.alterarSenha(new String(novaSenha.getPassword()));
            }
        });

        aba.add(new JLabel());
        aba.add(botaoSalvar);
        aba.setVisible(true);
    }
}