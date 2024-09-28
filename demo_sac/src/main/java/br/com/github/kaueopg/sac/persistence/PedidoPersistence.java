package br.com.github.kaueopg.sac.persistence;

import br.com.github.kaueopg.sac.model.Pedido;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PedidoPersistence implements Persistence<Pedido>{
    
    private static final String PATH = DIRECTORY + File.separator + "pedidos.json";

    @Override
    public void save(List<Pedido> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        Arquivo.salva(PATH, json);
    }

    @Override
    public List<Pedido> findAll() {
        Gson gson = new Gson();
        String json = Arquivo.le(PATH);

        List<Pedido> pedidos = new ArrayList<>();
        if (!json.trim().equals("")) {
            Type tipoLista = new TypeToken<List<Pedido>>() {}.getType();
            pedidos = gson.fromJson(json, tipoLista);

            if (pedidos == null) {
                pedidos = new ArrayList<>();
            }
        }

        return pedidos;
    }

}