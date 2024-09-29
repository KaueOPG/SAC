package br.com.github.kaueopg.sac.controller;

import br.com.github.kaueopg.sac.view.TelaMedico;
import br.com.github.kaueopg.sac.model.Medico;
import br.com.github.kaueopg.sac.persistence.MedicoPersistence;

import java.util.*;

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
                medicos.add(medico);
                break;
            }
            
        new TelaMedico(medico);
        tela.dispose();
        medicoPersistence.save(medicos);
        return true;
    }

}
