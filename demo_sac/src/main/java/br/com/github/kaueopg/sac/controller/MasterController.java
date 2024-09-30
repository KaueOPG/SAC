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

    private MedicoPersistence medicoPersistence = new MedicoPersistence();
    private ClientePersistence clientePersistence = new ClientePersistence();
    private ConsultaPersistence consultaPersistence = new ConsultaPersistence();

    private List<Medico> medicos = medicoPersistence.findAll();
    private List<Cliente> clientes = clientePersistence.findAll();
    private List<Consulta> consultas = consultaPersistence.findAll();

    public void imprimeTabela(DefaultTableModel modelo, String tipoTabela){
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
}
