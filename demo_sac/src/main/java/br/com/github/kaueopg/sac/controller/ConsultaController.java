package br.com.github.kaueopg.sac.controller;

import br.com.github.kaueopg.sac.model.Consulta;
import br.com.github.kaueopg.sac.persistence.ConsultaPersistence;

import java.util.List;

public class ConsultaController {

    private static ConsultaPersistence consultaPersistence = new ConsultaPersistence();
    private static List<Consulta> consultas = consultaPersistence.findAll();

    public static Consulta adicionar(String cpfCliente, String cpfMedico, String data, String horario)
    {
        Consulta consulta = new Consulta(cpfCliente, cpfMedico, data, horario);
        consultas.add(consulta);
        consultaPersistence.save(consultas);
        return consulta;
    }

    public static void excluir(Consulta consulta){
        consultas.remove(consulta);
        consultaPersistence.save(consultas); 
    }

    public static boolean confereVazia()
    {
        return consultas.isEmpty();
    }
}
