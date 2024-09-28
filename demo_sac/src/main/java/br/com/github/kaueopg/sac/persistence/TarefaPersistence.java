package br.com.github.kaueopg.sac.persistence;

import br.com.github.kaueopg.sac.model.Tarefa;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TarefaPersistence implements Persistence<Tarefa>{
    
    private static final String PATH = DIRECTORY + File.separator + "tarefas.json";

    @Override
    public void save(List<Tarefa> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        Arquivo.salva(PATH, json);
    }

    @Override
    public List<Tarefa> findAll() {
        Gson gson = new Gson();
        String json = Arquivo.le(PATH);

        List<Tarefa> tarefas = new ArrayList<>();
        if (!json.trim().equals("")) {
            Type tipoLista = new TypeToken<List<Tarefa>>() {}.getType();
            tarefas = gson.fromJson(json, tipoLista);

            if (tarefas == null) {
                tarefas = new ArrayList<>();
            }
        }

        return tarefas;
    }

}