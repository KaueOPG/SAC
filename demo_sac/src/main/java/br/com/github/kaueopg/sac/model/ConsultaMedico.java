package br.com.github.kaueopg.sac.model;

public class ConsultaMedico extends Consulta{

    private Cliente cliente;

    public ConsultaMedico( Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void adicionaCPF(String cpf) {
        cpfMedico = cpf;
        cpfCliente = cliente.getCpf();
    }
}
