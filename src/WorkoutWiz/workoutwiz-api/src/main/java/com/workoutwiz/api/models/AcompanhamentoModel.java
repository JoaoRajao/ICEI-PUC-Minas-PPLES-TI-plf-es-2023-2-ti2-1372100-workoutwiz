package com.workoutwiz.api.models;

public class AcompanhamentoModel {
    private final int treinoId;
    private final int  pesosLevantados;
    private final int distanciasPercorridas;
    private final int temposAlcancados;
    private final int taxaProgresso;

    public AcompanhamentoModel(int treinoId, int pesosLevantados, int distanciasPercorridas, int temposAlcancados, int taxaProgresso) {
        this.treinoId = treinoId;
        this.pesosLevantados = pesosLevantados;
        this.distanciasPercorridas = distanciasPercorridas;
        this.temposAlcancados = temposAlcancados;
        this.taxaProgresso = taxaProgresso;
    }

    public int getTreinoId() {
        return treinoId;
    }

    public int getPesosLevantados() {
        return pesosLevantados;
    }

    public int getDistanciasPercorridas() {
        return distanciasPercorridas;
    }

    public int getTemposAlcancados() { return temposAlcancados; }

    public int getTaxaProgresso() { return taxaProgresso; }

}

