package br.com.github.kaueopg.sac.controller;

import br.com.github.kaueopg.sac.model.Cliente;
import br.com.github.kaueopg.sac.model.Consulta;
import br.com.github.kaueopg.sac.model.Medico;
import br.com.github.kaueopg.sac.persistence.ClientePersistence;
import br.com.github.kaueopg.sac.persistence.ConsultaPersistence;
import br.com.github.kaueopg.sac.persistence.MedicoPersistence;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MasterController {

    private static MedicoPersistence medicoPersistence = new MedicoPersistence();
    private static ClientePersistence clientePersistence = new ClientePersistence();
    private static ConsultaPersistence consultaPersistence = new ConsultaPersistence();

    private static List<Medico> medicos = medicoPersistence.findAll();
    private static List<Cliente> clientes = clientePersistence.findAll();
    private static List<Consulta> consultas = consultaPersistence.findAll();

    public static void imprimeTabela(DefaultTableModel modelo, String tipoTabela){
        if(tipoTabela.matches("medico") == true && medicos.isEmpty() == false)
        {
            for(Medico medico: medicos)
                modelo.addRow(new Object[]{medico.getNome(), medico.getCpf(),medico.getSenha(), medico.getEspecializacao(), medico.getValor()});
        }
        else if(tipoTabela.matches("cliente") == true && clientes.isEmpty() == false)
        {
            for(Cliente cliente: clientes)
                modelo.addRow(new Object[]{cliente.getNome(), cliente.getCpf(),cliente.getSenha()});
        }
        else if(tipoTabela.matches("consulta") == true && consultas.isEmpty() == false)
        {
            for(Consulta consulta: consultas)
                modelo.addRow(new Object[]{consulta.getCpfCliente(), consulta.getCpfMedico(), consulta.getData(), consulta.getHorario()});
        }
    }

    public static void editarMedico(String nome, String cpf, String senha, String especializacao, double valor, String cpfAtual)
    {
        MedicoControler.editar(nome, cpf, senha, especializacao, valor, cpfAtual);
    }

    public static  void excluir(String cpf)
    {
        MedicoControler.excluir(cpf);
    }
}
