package br.com.github.kaueopg.sac.model;


public class Cliente extends Usuario{

    private String nome;

    public Cliente() {
    }
    
    public Cliente(String nome, String cpf, String senha) {
        super(cpf, senha);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}