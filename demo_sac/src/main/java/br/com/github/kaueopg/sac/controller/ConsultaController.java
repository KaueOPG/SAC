package br.com.github.kaueopg.sac.controller;
//Kauê Oliveira Paraízo Garcia - 202262217B

import br.com.github.kaueopg.sac.model.Consulta;
import br.com.github.kaueopg.sac.persistence.ConsultaPersistence;

import java.util.List;

public class ConsultaController {

    private static ConsultaPersistence consultaPersistence = new ConsultaPersistence();
    private static List<Consulta> consultas = consultaPersistence.findAll();

    public static Consulta adicionar(String cpfCliente, String cpfMedico, String data, String horario)
    {
        Consulta consulta = new Consulta(data, horario, cpfCliente, cpfMedico);
        consultas.add(consulta);
        consultaPersistence.save(consultas);
        return consulta;
    }

    public static void excluir(String cpfCliente, String cpfMedico, String data, String horario){
        Consulta consulta = procurar(cpfCliente, cpfMedico, data, horario);
        consultas.remove(consulta);
        consultaPersistence.save(consultas); 
    }

    public static boolean confereVazia()
    {
        return consultas.isEmpty();
    }

    public static Consulta procurar(String cpfCliente, String cpfMedico, String data, String horario)
    {
        for(Consulta consulta: consultas)
            if(consulta.getCpfCliente().matches(cpfCliente) == true && consulta.getCpfMedico().matches(cpfMedico) == true)
                if(consulta.getHorario().matches(horario) == true && consulta.getData().matches(data) == true)
                    return consulta;
        return null;
    }

    public static List<Consulta> lista()
    {
        return consultas;
    }
}
