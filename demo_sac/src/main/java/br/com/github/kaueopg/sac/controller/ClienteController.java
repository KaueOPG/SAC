package br.com.github.kaueopg.sac.controller;

import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.persistence.ClientePersistence;

import java.util.List;
import java.util.ArrayList;

public class ClienteController {

    private static ClientePersistence clientePersistence = new ClientePersistence();
    private static List<Cliente> clientes = clientePersistence.findAll();

    public static Cliente adicionar(String cpf, String nome, String senha)
    {
        Cliente cliente = new Cliente(nome,cpf, senha);
        clientes.add(cliente);
        clientePersistence.save(clientes);
        return cliente;
    }

    public static void excluir(Cliente cliente){
        List<Cliente> clientesAtualizados = new ArrayList<>();
        for(Cliente clienteDif: clientes)
            if(clienteDif.getCpf().matches(cliente.getCpf()) == false)
                clientesAtualizados.add(clienteDif);
        clientePersistence.save(clientesAtualizados); 
    }

    public static void editar(Cliente cliente)
    {
        for(Cliente clienteAntigo : clientes)
        if(clienteAntigo.getCpf().matches(cliente.getCpf()))
        {
            clientes.remove(clienteAntigo);
            clientes.add(cliente);
            break;
        }
        clientePersistence.save(clientes);
    }

    public static boolean confereVazia()
    {
        return clientes.isEmpty();
    }
}
