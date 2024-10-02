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

    public TelaMaster() {
        control = new MasterController(this);
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

        JPanel painelMedicos = criarPainel(colunasMedico, modeloMedicos, tabelaMedicos, "medico");
        JPanel painelClientes = criarPainel(colunasCliente, modeloClientes, tabelaClientes, "cliente");
        JPanel painelConsultas = criarPainel(colunasConsulta, modeloConsultas, tabelaConsultas, "consulta");

        tabelaGeral.addTab("Médicos", painelMedicos);
        tabelaGeral.addTab("Clientes", painelClientes);
        tabelaGeral.addTab("Consultas", painelConsultas);

        add(tabelaGeral);
    }

    private JPanel criarPainel(String[] colunas, DefaultTableModel modelo, JTable tabela, String tipoTabela) {
        JPanel painel = new JPanel(new BorderLayout());
        modelo = new DefaultTableModel(colunas, 0);
        control.imprimeTabela(modelo, tipoTabela);
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
                    control.adicionarMedico();
                else if(tipoTabela.matches("cliente") == true)
                    control.adicionarCliente();
                else if(tipoTabela.matches("consulta") == true)
                    control.adicionarConsutas();
            }
        });
        painelBotoes.add(botaoAdicionar);

        if(tipoTabela.matches("consulta") == false){
        JButton botaoEditar = new JButton("Editar");
        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tipoTabela.matches("medico") == true)
                    control.editarMedico(tabela);
                else if(tipoTabela.matches("cliente") == true)
                    control.editarCliente(tabela);
            }
        });
        painelBotoes.add(botaoEditar);}

        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabela.getSelectedRow();
                if(selectedRow >= 0) {
                    control.excluir(tabela, selectedRow, tipoTabela);
                }
            }
        });
        painelBotoes.add(botaoExcluir);

        painel.add(scrollPane, BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.SOUTH);
    }
}