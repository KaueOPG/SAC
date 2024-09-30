package br.com.github.kaueopg.sac.model;

public class Medico extends Usuario{
    
    private String nome;
    private String especializacao;
    private double valor;
    
    public Medico() {
    }

    public Medico(String nome, String cpf, String senha, String especializacao, double valor) {
        super(cpf,senha);
        this.nome = nome;
        this.especializacao = especializacao;
        this.valor = valor;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}