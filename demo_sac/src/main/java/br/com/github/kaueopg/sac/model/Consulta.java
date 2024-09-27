package br.com.github.kaueopg.sac.model;

import java.util.List;

public class Consulta extends Produto{
    
    private Medico medico;

    public Consulta(){
    }

    public Consulta(double preco, List<Tarefa> tarefas, Medico medico)
    {
        super(preco,tarefas);
        this.medico = medico;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
}