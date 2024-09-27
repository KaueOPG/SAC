package br.com.github.kaueopg.sac.model;

public class Tarefa {
    
    private String data;
    private String hora;
    private String cliente;

    public Tarefa() {
    }

    public Tarefa(String data, String hora, String cliente) {
        this.data = data;
        this.hora = hora;
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

}