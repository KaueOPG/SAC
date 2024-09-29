package br.com.github.kaueopg.sac.model;

import java.util.List;

public class Medico {
    
    private String nome;
    private String especializacao;
    private double valor;
    private String cpf;
    private List<ConsultaMedico> consultas;
    
    public Medico() {
    }

    public Medico(String nome, String especializacao, double valor, String cpf) {
        this.nome = nome;
        this.especializacao = especializacao;
        this.valor = valor;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ConsultaMedico> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaMedico> consultas) {
        this.consultas = consultas;
    }
    
}