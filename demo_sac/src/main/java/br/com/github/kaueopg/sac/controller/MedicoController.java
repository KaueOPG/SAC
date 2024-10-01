package br.com.github.kaueopg.sac.controller;

import br.com.github.kaueopg.sac.model.Medico;
import br.com.github.kaueopg.sac.persistence.MedicoPersistence;

import java.util.List;

public class MedicoController {
    
    private static MedicoPersistence medicoPersistence = new MedicoPersistence();
    private static List<Medico> medicos = medicoPersistence.findAll();

    public static void adicionar(String nome, String cpf, String senha, String especializacao, double valor)
    {
        Medico medico = new Medico(nome,cpf, senha,especializacao, valor);
        medicos.add(medico);
        medicoPersistence.save(medicos);
    }

    public static boolean editar(String nome, String cpf, String senha, String especializacao, double valor, String cpfAtual) {
        Medico medico = procurar(cpfAtual);
        Medico medicoAntigo = medico;
        boolean verificaAlteracoes = false;
    
        if (nome.isEmpty() == false) {
            medico.setNome(nome);
            verificaAlteracoes = true;
        }
    
        if (senha.isEmpty() == false) {
            medico.setSenha(senha);
            verificaAlteracoes = true;
        }
    
        if (cpf.isEmpty() == false) {
            medico.setCpf(cpf);
            verificaAlteracoes = true;
        }
    
        if (especializacao.isEmpty() == false) {
            medico.setEspecializacao(especializacao);
            verificaAlteracoes = true;
        }
    
        if (valor > 0) {
            medico.setValor(valor);
            verificaAlteracoes = true;
        }
    
        if (verificaAlteracoes) {
            medicos.remove(medicoAntigo);
            medicos.add(medico);
            medicoPersistence.save(medicos);
        }
    
        return verificaAlteracoes;
    }
    

    public static void excluir(String cpf){
        Medico medico = procurar(cpf);
        medicos.remove(medico);
        medicoPersistence.save(medicos); 
    }

    public static boolean confereVazia()
    {
        return medicos.isEmpty();
    }

    public static Medico procurar(String cpf)
    {
        for(Medico medico: medicos)
            if(medico.getCpf().matches(cpf) == true)
                return medico;
        return null;
    }
}
