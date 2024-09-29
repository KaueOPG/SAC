package br.com.github.kaueopg.sac.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import br.com.github.kaueopg.sac.controller.TelaClienteController;
import br.com.github.kaueopg.sac.model.Cliente;

public class TelaCliente extends JFrame {

    private JPanel painelDados = new JPanel();
    private JPanel painelBotoes = new JPanel();
    private JPanel painelAgendamentos = new JPanel();
    private JPanel agendamentosBotoes = new JPanel();
    private Border borda = BorderFactory.createLineBorder(Color.GRAY, 1);
    
    private JTextField nome;
    private JTextField cpf;
    private JPasswordField senha;
    private JList<String> jlConsultas;
    private DefaultListModel<String> consultasModel;
    private TelaClienteController control;
    private Cliente cliente;

    public TelaCliente(Cliente cliente) {
        this.cliente = cliente;
        control = new TelaClienteController(this, cliente);
        
        configurarJanela();
        criaPainelDados();  
        criaPainelAgendamentos();  

        setVisible(true);
        pack();
        setLocationRelativeTo(null);  
    }

    private void configurarJanela() {
        setTitle("Cliente - Consultas Marcadas");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void criaPainelDados() {
        dados();
        botoesDados();
        painelDados.add(painelBotoes);
        getContentPane().add(painelDados, BorderLayout.WEST);
    }

    private void dados() {
        painelDados.setBorder(BorderFactory.createTitledBorder("Informações do Cliente"));
        painelDados.setLayout(new GridLayout(4, 1, 10, 10));

        nome = new JTextField();
        nome.setBorder(BorderFactory.createTitledBorder(borda, "Nome"));
        painelDados.add(nome);
        nome.setText(cliente.getNome());

        cpf = new JTextField();
        cpf.setBorder(BorderFactory.createTitledBorder(borda, "CPF"));
        painelDados.add(cpf);
        cpf.setText(cliente.getCpf());

        senha = new JPasswordField();
        senha.setBorder(BorderFactory.createTitledBorder(borda, "Senha"));
        painelDados.add(senha);
        senha.setText(cliente.getSenha());
    }

    private void botoesDados() {
        JButton botaoEditar = new JButton("Editar Dados");
        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarDados();
            }
        });
        painelBotoes.add(botaoEditar);

        JButton botaoExcluir = new JButton("Excluir Conta");
        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(TelaCliente.this, "Tem certeza que deseja excluir a conta?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    control.excluirConta();
                }
            }
        });
        painelBotoes.add(botaoExcluir);
    }

    private void criaPainelAgendamentos() {
        campos();
        botoesAgendamentos();
        painelAgendamentos.add(agendamentosBotoes, BorderLayout.SOUTH);
        getContentPane().add(painelAgendamentos, BorderLayout.EAST);
    }

    private void campos()
    {
        painelAgendamentos.setBorder(BorderFactory.createTitledBorder("Consultas Marcadas"));
        painelAgendamentos.setPreferredSize(new Dimension(300, 350));
        painelAgendamentos.setLayout(new BorderLayout());

        consultasModel = new DefaultListModel<>();
        jlConsultas = new JList<>(consultasModel);

        painelAgendamentos.add(new JScrollPane(jlConsultas), BorderLayout.CENTER);
    }

    private void botoesAgendamentos()
    {
        JButton botaoMarcar = new JButton("Marcar Consulta");
        botaoMarcar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcarConsulta();
            }
        });
        agendamentosBotoes.add(botaoMarcar);

        JButton BotaoDesmarcar = new JButton("Desmarcar Consulta");
        BotaoDesmarcar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desmarcarConsulta();
            }
        });
        agendamentosBotoes.add(BotaoDesmarcar);
    }

    private void marcarConsulta() {
    }

    private void desmarcarConsulta() {
    }

    private void editarDados() {
        AbaEditarDados aba = new AbaEditarDados(this, control);
        aba.setVisible(true);
    }
}
    
