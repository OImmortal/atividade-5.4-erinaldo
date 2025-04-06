package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Rota {

    private int idRota;
    private String nomeRota;
    private TipoTransporte tipoTransporte;
    private String Regiao;

    public Rota() {}

    public Rota(int idRota, String nomeRota, TipoTransporte tipoTransporte, String regiao) {
        this.idRota = idRota;
        this.nomeRota = nomeRota;
        this.tipoTransporte = tipoTransporte;
        Regiao = regiao;
    }

    public int getIdRota() {
        return idRota;
    }

    public void setIdRota(int idRota) {
        this.idRota = idRota;
    }

    public String getNomeRota() {
        return nomeRota;
    }

    public void setNomeRota(String nomeRota) {
        this.nomeRota = nomeRota;
    }

    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }

    public static TipoTransporte stringToTipoTransporte(String tipoTransporte) {
        if (tipoTransporte == null) return TipoTransporte.Onibus;

        switch (tipoTransporte.toLowerCase()) {
            case "onibus":
                return TipoTransporte.Onibus;
            case "metro":
                return TipoTransporte.Metro;
            case "trem":
                return TipoTransporte.Trem;
            default:
                return TipoTransporte.Onibus;
        }
    }


    public void setTipoTransporte(TipoTransporte tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public String getRegiao() {
        return Regiao;
    }

    public void setRegiao(String regiao) {
        Regiao = regiao;
    }

    @Override
    public String toString() {
        return "Rota{" +
                "idRota=" + idRota +
                ", nomeRota='" + nomeRota + '\'' +
                ", tipoTransporte=" + tipoTransporte +
                ", Regiao='" + Regiao + '\'' +
                '}';
    }
}
