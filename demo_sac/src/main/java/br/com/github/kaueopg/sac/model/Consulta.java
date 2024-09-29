package br.com.github.kaueopg.sac.model;

public abstract class Consulta{
    
    private String data;
    private String horario;
    protected String cpfCliente;
    protected String cpfMedico;

    public Consulta(){
    }

    public Consulta(String data, String horario) {
        this.data = data;
        this.horario = horario;
    }

    public abstract void adicionaCPF(String cpf);

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

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCpfMedico() {
        return cpfMedico;
    }

    public void setCpfMedico(String cpfMedico) {
        this.cpfMedico = cpfMedico;
    }
    
}