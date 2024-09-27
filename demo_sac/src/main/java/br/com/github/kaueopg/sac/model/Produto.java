package br.com.github.kaueopg.sac.model;

import java.util.List;

public abstract class Produto {

    private double preco;
    private List<Tarefa> tarefas;

    public Produto(){
    }

    public Produto(double preco, List<Tarefa> tarefas)
    {
        this.preco = preco;
        this.tarefas = tarefas;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

}