package br.com.github.kaueopg.sac.model;
//Kauê Oliveira Paraízo Garcia - 202262217B

public class Consulta{
    
    private String data;
    private String horario;
    private String cpfCliente;
    private String cpfMedico;

    public Consulta(){
    }

    public Consulta(String data, String horario, String cpfCliente, String cpfMedico) {
        this.data = data;
        this.horario = horario;
        this.cpfCliente = cpfCliente;
        this.cpfMedico = cpfMedico;
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