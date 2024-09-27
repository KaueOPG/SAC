package br.com.github.kaueopg.sac.model;

import java.util.List;

public class Exame extends Produto{

    private String nome;

    public Exame(){
    }

    public Exame(double preco, List<Tarefa> tarefas, String nome)
    {
        super(preco,tarefas);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}