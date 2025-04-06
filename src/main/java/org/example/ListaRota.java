package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

public class ListaRota {
    private LinkedList<Rota> listaRota = new LinkedList<>();

    public ListaRota(LinkedList<Rota> listaRota) {
        this.listaRota = listaRota;
    }

    public ListaRota() {
    }

    public  void readRota(String urlFile) {
        try(BufferedReader br = new BufferedReader(new FileReader(urlFile))){
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");

                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                TipoTransporte tipoTransporte = Rota.stringToTipoTransporte(removerAcentos(campos[2].toLowerCase()));
                String regiao = campos[3];

                listaRota.add(new Rota(id, nome, tipoTransporte, regiao));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public LinkedList<Rota> getListaRota() {
        return listaRota;
    }

    public void listarRotasInicio() {
        for (Rota rota : listaRota) {
            System.out.println(rota);
        }
    }

    public void listarRotasFinal() {
        ListIterator<Rota> iterator = listaRota.listIterator(listaRota.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    public List<Rota> filtrarPorRegiao(String regiao) {
        if (regiao.equals("") || regiao.equals(" ") || regiao.equals("\n") || regiao == null) {
            return new ArrayList<>();
        }

        List<Rota> listaFiltrada = new LinkedList<>();
        listaFiltrada = this.listaRota.stream().filter(r -> r.getRegiao().equalsIgnoreCase(regiao)).toList();
        return listaFiltrada;
    }

    public List<Rota> filtrarPorTipoTransporte(String tipoTransporte) {
        if (tipoTransporte.equals("") || tipoTransporte.equals(" ") || tipoTransporte.equals("\n")) {
            return new ArrayList<>();
        }

        List<Rota> listaFiltrada = new LinkedList<>();
        listaFiltrada = this.listaRota.stream().filter(r -> r.getTipoTransporte().equals(Rota.stringToTipoTransporte(removerAcentos(tipoTransporte.toLowerCase().trim())))).toList();
        return listaFiltrada;
    }

    public static String removerAcentos(String texto) {
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(textoNormalizado).replaceAll("");
    }

    @Override
    public String toString() {
        return "ListaRota{" + listaRota.toString() + "}";
    }
}
