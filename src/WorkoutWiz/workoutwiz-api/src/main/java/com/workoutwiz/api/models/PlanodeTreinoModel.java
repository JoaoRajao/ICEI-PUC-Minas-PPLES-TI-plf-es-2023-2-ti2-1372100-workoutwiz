package com.workoutwiz.api.models;

public class PlanodeTreinoModel {
    private final int clientId;
    private final String data;
    private final int frequencia;
    private final String modalidade;
    private final String ganhoDeMassaMuscular;
    private final String controleDePeso;
    private final String aumentoDaResistencia;
    private final String progressoesDeCarga;
    private final String progressoesDeDificuldade;
    private final int treinadorId;

    public PlanodeTreinoModel(int clientId, String data, int frequencia, String modalidade, String ganhoDeMassaMuscular, String controleDePeso, String aumentoDaResistencia, String progressoesDeCarga, String progressoesDeDificuldade, int treinadorId) {
        this.clientId = clientId;
        this.data = data;
        this.frequencia = frequencia;
        this.modalidade = modalidade;
        this.ganhoDeMassaMuscular = ganhoDeMassaMuscular;
        this.controleDePeso = controleDePeso;
        this.aumentoDaResistencia = aumentoDaResistencia;
        this.progressoesDeCarga = progressoesDeCarga;
        this.progressoesDeDificuldade = progressoesDeDificuldade;
        this.treinadorId = treinadorId;
    }

    public int getClienteId() {
        return clientId;
    }

    public String getData() {
        return data;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public String getModalidade() {
        return modalidade;
    }

    public String getGanhoDeMassaMuscular() {
        return ganhoDeMassaMuscular;
    }

    public String getControleDePeso() {
        return controleDePeso;
    }

    public String getAumentoDaResistencia() {
        return aumentoDaResistencia;
    }

    public String getProgressoesDeCarga() {
        return progressoesDeCarga;
    }

    public String getProgressoesDeDificuldade() {
        return progressoesDeDificuldade;
    }

    public int getTreinadorId() {
        return treinadorId;
    }
}