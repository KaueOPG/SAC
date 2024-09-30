package br.com.github.kaueopg.sac.controller;

import br.com.github.kaueopg.sac.model.Medico;
import br.com.github.kaueopg.sac.persistence.MedicoPersistence;

import java.util.List;

public class MedicoControler {
    
    private static MedicoPersistence medicoPersistence = new MedicoPersistence();
    private static List<Medico> medicos = medicoPersistence.findAll();

    public static Medico adicionar(String cpf, String nome, String senha, String especializacao, double valor)
    {
        Medico medico = new Medico(nome,cpf, senha,especializacao, valor);
        medicos.add(medico);
        medicoPersistence.save(medicos);
        return medico;
    }
}
