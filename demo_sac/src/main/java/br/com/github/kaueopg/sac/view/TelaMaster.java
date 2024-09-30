package br.com.github.kaueopg.sac.view;

import br.com.github.kaueopg.sac.controller.MasterController;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaMaster extends JFrame {

    private MasterController control;
    private JTabbedPane tabelaGeral;
    private JPanel painelMedicos;
    private JPanel painelClientes;
    private JPanel painelConsultas;
    private JPanel painelDadosMaster;

    public TelaMaster() {
        control = new MasterController();
        configurarJanela();
        criaTabela();
        setVisible(true);
    }

    private void configurarJanela()
    {
        setTitle("Tela Master");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void criaTabela()
    {
        tabelaGeral = new JTabbedPane();

        String[] colunasMedico = {"Nome", "CPF", "Senha", "Especialização", "Valor"};
        String[] colunasCliente = {"Nome", "CPF", "Senha"};
        String[] colunasConsulta = {"CPF Cliente", "CPF Médico", "Data", "Horário"};

        DefaultTableModel modeloMedicos = new DefaultTableModel(colunasMedico, 0);
        DefaultTableModel modeloClientes = new DefaultTableModel(colunasCliente, 0);
        DefaultTableModel modeloConsultas = new DefaultTableModel(colunasConsulta, 0);

        JTable tabelaMedicos = new JTable(modeloMedicos);
        JTable tabelaClientes = new JTable(modeloClientes);
        JTable tabelaConsultas =new JTable(modeloConsultas);

        painelMedicos = criarPainel(colunasMedico, modeloMedicos, tabelaMedicos, "medico");
        painelClientes = criarPainel(colunasCliente, modeloClientes, tabelaClientes, "cliente");
        painelConsultas = criarPainel(colunasConsulta, modeloConsultas, tabelaConsultas, "consulta");

        criarPainelDadosMaster();

        tabelaGeral.addTab("Médicos", painelMedicos);
        tabelaGeral.addTab("Clientes", painelClientes);
        tabelaGeral.addTab("Consultas", painelConsultas);
        tabelaGeral.addTab("Dados Master", painelDadosMaster);

        add(tabelaGeral);
    }

    private JPanel criarPainel(String[] colunas, DefaultTableModel modelo, JTable tabela, String tipoTabela) {
        JPanel painel = new JPanel(new BorderLayout());
        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        botoes(scrollPane, painel, tipoTabela, modelo, tabela);
        return painel;
    }
    
    private void botoes(JScrollPane scrollPane, JPanel painel, String tipoTabela,  DefaultTableModel modelo, JTable tabela)
    {
        JPanel painelBotoes = new JPanel();
        JButton botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tipoTabela.matches("medico") == true)
                    BotoesMedicoMaster.adicionar(modelo);
                else if(tipoTabela.matches("cliente") == true)
                    BotoesClienteMaster.adicionar(modelo);
                else if(tipoTabela.matches("consulta") == true)
                    BotoesConsultaMaster.adicionar(modelo);
            }
        });
        painelBotoes.add(botaoAdicionar);

        JButton botaoEditar = new JButton("Editar");
        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tipoTabela.matches("medico") == true)
                    BotoesMedicoMaster.editar(tabela,modelo);
                else if(tipoTabela.matches("cliente") == true)
                    BotoesClienteMaster.editar(tabela,modelo);
                else if(tipoTabela.matches("consulta") == true)
                    BotoesConsultaMaster.editar(tabela,modelo);
            }
        });
        painelBotoes.add(botaoEditar);

        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tipoTabela.matches("medico") == true)
                    BotoesMedicoMaster.excluir(tabela, modelo);
                else if(tipoTabela.matches("cliente") == true)
                    BotoesClienteMaster.excluir(tabela, modelo);
                else if(tipoTabela.matches("consulta") == true)
                    BotoesConsultaMaster.excluir(tabela, modelo);
            }
        });
        painelBotoes.add(botaoExcluir);

        painel.add(scrollPane, BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.SOUTH);
    }

    private JPanel criarPainelDadosMaster() {
        JPanel painel = new JPanel(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();

        JTextField nomeMaster = new JTextField(20);
        JTextField cpfMaster = new JTextField(20);
        JPasswordField senhaMaster = new JPasswordField(20);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        painel.add(new JLabel("Nome Master:"), gbc);
        gbc.gridx = 1;
        painel.add(nomeMaster, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(new JLabel("CPF Master:"), gbc);
        gbc.gridx = 1;
        painel.add(cpfMaster, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(new JLabel("Senha Master:"), gbc);
        gbc.gridx = 1;
        painel.add(senhaMaster, gbc);

        return painel;
    }
}
