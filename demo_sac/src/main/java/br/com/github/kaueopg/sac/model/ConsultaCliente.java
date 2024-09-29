package br.com.github.kaueopg.sac.model;

public class ConsultaCliente extends Consulta{
    
    private Medico medico;

    public ConsultaCliente(String data, String horario, Medico medico)
    {
        super(data, horario);
        this.medico = medico;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public void adicionaCPF(String cpf) {
        cpfCliente = cpf;
        cpfMedico = medico.getCpf();
    }

}
