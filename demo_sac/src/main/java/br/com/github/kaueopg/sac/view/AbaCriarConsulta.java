package br.com.github.kaueopg.sac.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.util.List;

import br.com.github.kaueopg.sac.controller.ConsultaController;
import br.com.github.kaueopg.sac.controller.MedicoController;
import br.com.github.kaueopg.sac.model.Medico;

public class AbaCriarConsulta extends JDialog {
    private JComboBox<String> medicoSelecao;
    private JTextField data;
    private JTextField horario;
    
    public AbaCriarConsulta(TelaCliente tela, String cpfCliente) {
        super(tela, "Nova consulta", true);
        setLayout(new GridLayout(4, 2, 5, 10));
        setSize(300, 200);
        setLocationRelativeTo(tela);

        data = new JTextField();
        horario = new JTextField();
        
        medicoSelecao = new JComboBox<>();
        List<String> cpfs = new ArrayList<>();
        for (Medico medico : MedicoController.lista()) {
            cpfs.add(medico.getCpf());
            medicoSelecao.addItem(medico.getNome() + "|" + medico.getEspecializacao() + "|" + medico.getValor());
        }

        add(new JLabel("Medico:"));
        add(medicoSelecao);
        add(new JLabel("Data:"));
        add(data);
        add(new JLabel("Horario:"));
        add(horario);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(data.getText().isEmpty() == false && horario.getText().isEmpty() == false){
                ConsultaController.adicionar(cpfCliente, cpfs.get(medicoSelecao.getSelectedIndex()), data.getText(), horario.getText());
                dispose();
            }
            }
        });

        add(new JLabel());
        add(botaoSalvar);
    }
}
