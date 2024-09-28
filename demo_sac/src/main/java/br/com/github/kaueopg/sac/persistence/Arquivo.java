package br.com.github.kaueopg.sac.persistence;

import java.io.*;

public class Arquivo {
    public static void salva(String caminho, String conteudo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            bw.write(conteudo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String le(String caminho) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conteudo.toString();
    }
}