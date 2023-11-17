package com.workoutwiz.api.models;

public class PlanejamentoTreinoModel {
    private final String treinoId;
    private final String tempo;
    private final String data;


    public PlanejamentoTreinoModel(String treinoId, String tempo, String data) {
        this.treinoId = treinoId;
        this.data = data;
        this.tempo = tempo;
    }

    public String getTreinoId(){ return treinoId;}
    public String getData(){ return  data;}
    public String getTempo(){ return tempo;}
}
