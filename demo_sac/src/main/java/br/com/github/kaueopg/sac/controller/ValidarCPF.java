package br.com.github.kaueopg.sac.controller;

import java.util.List;

import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.model.Master;
import br.com.github.kaueopg.sac.model.Medico;
import br.com.github.kaueopg.sac.persistence.ClientePersistence;
import br.com.github.kaueopg.sac.persistence.MedicoPersistence;

public class ValidarCPF {
    private static String regex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

    public static boolean validaCPF(String cpf)
    {
        ClientePersistence clientePersistence = new ClientePersistence();
        List<Cliente> clientes = clientePersistence.findAll();

        MedicoPersistence medicoPersistence = new MedicoPersistence();
        List<Medico> medicos = medicoPersistence.findAll();

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
