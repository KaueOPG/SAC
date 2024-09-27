package br.com.github.kaueopg.sac.model;

public class Medico {
    
    private String nome;
    private String Especializacao;
    
    public Medico() {
    }

    public Medico(String nome, String especializacao) {
        this.nome = nome;
        Especializacao = especializacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecializacao() {
        return Especializacao;
    }

    public void setEspecializacao(String especializacao) {
        Especializacao = especializacao;
    }

}