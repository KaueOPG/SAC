package br.com.github.kaueopg.sac.view;
//Kauê Oliveira Paraízo Garcia - 202262217B

import br.com.github.kaueopg.sac.controller.MedicoController;
import br.com.github.kaueopg.sac.controller.TelaClienteController;
import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.model.Medico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TelaCliente extends JFrame {

    private JPanel painelDados = new JPanel();
    private JPanel painelBotoes = new JPanel();
    private JPanel painelAgendamentos = new JPanel();
    private JPanel agendamentosBotoes = new JPanel();
    private Border borda = BorderFactory.createLineBorder(Color.GRAY, 1);

    private JTextField nome;
    private JTextField cpf;
    private JPasswordField senha;
    private JTable consultas;
    private TelaClienteController control;
    private Cliente cliente;

    public TelaCliente(Cliente cliente) {
        this.cliente = cliente;
        control = new TelaClienteController(this,cliente);
        
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

        String[] colunas = { "Medico", "Especialização", "Data", "Hora", "CPF Medico" };
        DefaultTableModel consultasTabela = new DefaultTableModel(colunas, 0);
        consultas = new JTable(consultasTabela);

        painelAgendamentos.add(new JScrollPane(consultas), BorderLayout.CENTER);
        getContentPane().add(painelAgendamentos, BorderLayout.EAST);

        control.tabelaIniciar(consultasTabela);

        botoesAgendamentos();
        painelAgendamentos.add(agendamentosBotoes, BorderLayout.SOUTH);
        getContentPane().add(painelAgendamentos, BorderLayout.EAST);
    }

    private void campos()
    {
        painelAgendamentos.setBorder(BorderFactory.createTitledBorder("Consultas Marcadas"));
        painelAgendamentos.setPreferredSize(new Dimension(300, 350));
        painelAgendamentos.setLayout(new BorderLayout());
    }

    private void botoesAgendamentos()
    {
        JButton botaoMarcar = new JButton("Marcar Consulta");
        botaoMarcar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarConsulta();
            }
        });
        agendamentosBotoes.add(botaoMarcar);

        JButton BotaoDesmarcar = new JButton("Desmarcar Consulta");
        BotaoDesmarcar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = consultas.getSelectedRow();
                if (selectedRow >= 0) {
                    control.excluirTabela(cliente.getCpf(), consultas.getValueAt(selectedRow, 4).toString(), consultas.getValueAt(selectedRow, 2).toString(), consultas.getValueAt(selectedRow, 3).toString());
                }
            }
        });
        agendamentosBotoes.add(BotaoDesmarcar);
    }

    private void editarDados() {
        JDialog abaEditar = new JDialog(this, "Editar Dados do Cliente", true);
        abaEditar = new JDialog(this, "Editar Dados do Cliente", true);
        abaEditar.setLayout(new GridLayout(4, 2, 5, 10));
        abaEditar.setSize(300, 200);
        abaEditar.setLocationRelativeTo(this);

        JTextField novoNome = new JTextField();
        JTextField novoCPF = new JTextField();
        JPasswordField novaSenha = new JPasswordField();

        abaEditar.add(new JLabel("Nome:"));
        abaEditar.add(novoNome);
        abaEditar.add(new JLabel("CPF:"));
        abaEditar.add(novoCPF);
        abaEditar.add(new JLabel("Senha:"));
        abaEditar.add(novaSenha);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.editarDados(novoNome.getText(), novoCPF.getText(), new String(novaSenha.getPassword()));
            }
        });

        abaEditar.add(new JLabel());
        abaEditar.add(botaoSalvar);
        abaEditar.setVisible(true);
    }

    private void criarConsulta()
    {
        JDialog abaCriarConsulta = new JDialog(this, "Nova consulta", true);
        abaCriarConsulta.setLayout(new GridLayout(4, 2, 5, 10));
        abaCriarConsulta.setSize(300, 200);
        abaCriarConsulta.setLocationRelativeTo(this);

        JComboBox<String> medicoSelecao= new JComboBox<>();
        JTextField data = new JTextField();
        JTextField horario = new JTextField();

        List<String> cpfs = new ArrayList<>();
        for (Medico medico : MedicoController.lista()) {
            cpfs.add(medico.getCpf());
            medicoSelecao.addItem(medico.getNome() + "|" + medico.getEspecializacao() + "|" + medico.getValor());
        }

        abaCriarConsulta.add(new JLabel("Medico:"));
        abaCriarConsulta.add(medicoSelecao);
        abaCriarConsulta.add(new JLabel("Data:"));
        abaCriarConsulta.add(data);
        abaCriarConsulta.add(new JLabel("Horario:"));
        abaCriarConsulta.add(horario);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.criarConsulta(cpfs.get(medicoSelecao.getSelectedIndex()), data.getText(), horario.getText());
            }
        });

        abaCriarConsulta.add(new JLabel());
        abaCriarConsulta.add(botaoSalvar);

        abaCriarConsulta.setVisible(true);
    }
}
    
