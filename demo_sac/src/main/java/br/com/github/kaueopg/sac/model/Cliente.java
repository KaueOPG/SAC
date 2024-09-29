package br.com.github.kaueopg.sac.model;

import java.util.List;

public class Cliente extends Usuario{

    private List<ConsultaCliente> consultas;

    public Cliente() {
    }
    
    public Cliente(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
    }

    public List<ConsultaCliente> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaCliente> consultas) {
        this.consultas = consultas;
    }
    
}