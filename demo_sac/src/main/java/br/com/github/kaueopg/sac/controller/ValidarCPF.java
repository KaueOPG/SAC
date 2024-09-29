package br.com.github.kaueopg.sac.controller;

import java.util.List;

import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.persistence.ClientePersistence;

public class ValidarCPF {
        private static String regex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

    public static boolean validaCPF(String cpf)
    {
        ClientePersistence clientePersistence = new ClientePersistence();
        List<Cliente> clientes = clientePersistence.findAll();
        System.out.println(cpf);
        if(cpf.matches(regex) == false)
            return false;
        
        for(Cliente cliente : clientes)
            if(cliente.getCpf().matches(cpf) == true)
                return false;

        return true;
    }
}
