package br.com.github.kaueopg.sac.controller;

import br.com.github.kaueopg.sac.view.TelaMedico;
import br.com.github.kaueopg.sac.model.Consulta;
import br.com.github.kaueopg.sac.model.Medico;
import br.com.github.kaueopg.sac.persistence.ConsultaPersistence;
import br.com.github.kaueopg.sac.persistence.MedicoPersistence;

import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class TelaMedicoController {
    
    private TelaMedico tela;
    private Medico medico;

    public TelaMedicoController(TelaMedico tela, Medico medico)
    {
        this.tela = tela;
        this.medico = medico;
    }

    public boolean alterarSenha(String senhaNova)
    {
        if(senhaNova.isEmpty() == true)
             return false;

        MedicoPersistence medicoPersistence = new MedicoPersistence();
        List<Medico> medicos = medicoPersistence.findAll();

        for(Medico medicoAntigo : medicos)
            if(medicoAntigo.getCpf().matches(medico.getCpf()))
            {
                medicos.remove(medicoAntigo);
                medico.setSenha(senhaNova);
                medicos.add(medico);
                medicoPersistence.save(medicos);
                break;
            }
            
        new TelaMedico(medico);
        tela.dispose();
        return true;
    }

    public void tabela(DefaultTableModel consultasTabela)
    {
        ConsultaPersistence consultaPersistence = new ConsultaPersistence();
        List<Consulta> consultas = consultaPersistence.findAll();

        for(Consulta consulta: consultas)
            if(consulta.getCpfMedico().matches(medico.getCpf()) == true)
                consultasTabela.addRow(new Object[] { consulta.getCpfCliente(), consulta.getData(), consulta.getHorario() });
    }

}
