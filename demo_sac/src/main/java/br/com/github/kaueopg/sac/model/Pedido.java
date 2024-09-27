package br.com.github.kaueopg.sac.model;

public class Pedido {
    
    private String data;
    private String horario;
    private Produto produto;

    public Pedido() {
    }

    public Pedido(String data, String horario, Produto produto) {
        this.data = data;
        this.horario = horario;
        this.produto = produto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}