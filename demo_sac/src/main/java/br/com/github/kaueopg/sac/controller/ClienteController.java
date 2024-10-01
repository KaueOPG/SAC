package br.com.github.kaueopg.sac.controller;
//Kauê Oliveira Paraízo Garcia - 202262217B

import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.persistence.ClientePersistence;

import java.util.List;

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

    public static void excluir(String cpf){
        Cliente cliente = procurar(cpf);
        clientes.remove(cliente);
        clientePersistence.save(clientes); 
    }

    public static boolean editar(String nome, String cpf, String senha, String cpfAtual)
    {
        Cliente cliente = procurar(cpfAtual);
        Cliente clienteAntigo = cliente;
        boolean verificaAlteracoes = false;
        if(nome.isEmpty() == false)
        {
            cliente.setNome(nome);
            verificaAlteracoes = true;
        }
        if(senha.isEmpty() == false)
        {
            cliente.setSenha(senha);
            verificaAlteracoes = true;
        }
        if(ValidarCPF.validaCPF(cpf) == true && cpf.isEmpty() == false)
        {
            cliente.setCpf(cpf);
            verificaAlteracoes = true;
        }
        if(verificaAlteracoes == true)
        {
            clientes.remove(clienteAntigo);
            clientes.add(cliente);
            clientePersistence.save(clientes);      
        }
        return verificaAlteracoes;
    }

    public static boolean confereVazia()
    {
        return clientes.isEmpty();
    }

    public static Cliente procurar(String cpf)
    {
        for(Cliente cliente: clientes)
            if(cliente.getCpf().matches(cpf) == true)
                return cliente;
        return null;
    }

    public static List<Cliente> lista()
    {
        return clientes;
    }
}
