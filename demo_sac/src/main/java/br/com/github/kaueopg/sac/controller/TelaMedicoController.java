package br.com.github.kaueopg.sac.controller;
//Kauê Oliveira Paraízo Garcia - 202262217B

import br.com.github.kaueopg.sac.view.TelaMedico;
import br.com.github.kaueopg.sac.model.Consulta;
import br.com.github.kaueopg.sac.model.Medico;

import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaMedicoController {
    
    private TelaMedico tela;
    private Medico medico;

    public TelaMedicoController(TelaMedico tela, Medico medico)
    {
        this.tela = tela;
        this.medico = medico;
    }

    public void alterarSenha(String senhaNova)
    {
        if(senhaNova.isBlank() == true)
        {
            JOptionPane.showMessageDialog(tela, "Digite uma senha válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        MedicoController.editar(medico.getNome(), medico.getCpf(), senhaNova, medico.getEspecializacao(), medico.getValor(), medico.getCpf());
        tela.dispose();
        new TelaMedico(medico);
    }

    public void tabela(DefaultTableModel consultasTabela)
    {
        List<Consulta> consultas = ConsultaController.lista();

        for(Consulta consulta: consultas)
            if(consulta.getCpfMedico().matches(medico.getCpf()) == true)
                consultasTabela.addRow(new Object[] { consulta.getCpfCliente(), consulta.getData(), consulta.getHorario()});
    }

}
