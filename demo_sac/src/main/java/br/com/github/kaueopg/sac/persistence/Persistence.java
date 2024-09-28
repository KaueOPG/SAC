package br.com.github.kaueopg.sac.persistence;

import java.util.List;

public interface Persistence<T> {

    String DIRECTORY = "dados";
    public void save(List<T> itens);
    public List<T> findAll();
    
}