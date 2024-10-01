package br.com.github.kaueopg.sac.persistence;
//Kauê Oliveira Paraízo Garcia - 202262217B

import br.com.github.kaueopg.sac.model.Consulta;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ConsultaPersistence implements Persistence<Consulta>{
    private static final String PATH = DIRECTORY + File.separator + "consultas.json";

    @Override
    public void save(List<Consulta> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        Arquivo.salva(PATH, json);
    }

    @Override
    public List<Consulta> findAll() {
        Gson gson = new Gson();
        String json = Arquivo.le(PATH);

        List<Consulta> consultas = new ArrayList<>();
        if (!json.trim().equals("")) {
            Type tipoLista = new TypeToken<List<Consulta>>() {}.getType();
            consultas = gson.fromJson(json, tipoLista);

            if (consultas == null) {
                consultas = new ArrayList<>();
            }
        }

        return consultas;

    }
}
