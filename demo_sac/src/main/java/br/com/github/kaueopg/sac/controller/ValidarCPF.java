package br.com.github.kaueopg.sac.controller;
//Kauê Oliveira Paraízo Garcia - 202262217B

import java.util.List;

import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.model.Master;
import br.com.github.kaueopg.sac.model.Medico;

public class ValidarCPF {
    private static String regex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

    public static boolean validaCPF(String cpf)
    {
        List<Cliente> clientes = ClienteController.lista();
        List<Medico> medicos = MedicoController.lista();

        Master master = new Master();

        if(cpf.matches(regex) == false || master.getCpf().matches(cpf) == true)
            return false;
        
        for(Cliente cliente: clientes)
            if(cliente.getCpf().matches(cpf) == true)
                return false;
        
        for(Medico medico: medicos)
            if(medico.getCpf().matches(cpf) == true)
                return false;

        return true;
    }
}
