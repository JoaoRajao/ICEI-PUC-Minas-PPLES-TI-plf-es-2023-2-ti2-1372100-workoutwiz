package com.workoutwiz.api.models;

public class PlanodeTreinoModel {
    private final int treinoID;
    private final int clienteID;
    private final Date data;
    private final int frequencia;
    private final String modalidade;
    private final String ganhoDeMassaMuscular;
    private final String controleDePeso;
    private final String aumentoDaResistencia;
    private final String progressoesDeCarga;
    private final String progressoesDeDificuldade;
    private final int treinadorID;

    public PlanodeTreinoModel(int treinoID, int clienteID, Date data, int frequencia,
                              String modalidade, String ganhoDeMassaMuscular, String controleDePeso,
                              String aumentoDaResistencia, String progressoesDeCarga,
                              String progressoesDeDificuldade, int treinadorID) {
        this.treinoID = treinoID;
        this.clienteID = clienteID;
        this.data = data;
        this.frequencia = frequencia;
        this.modalidade = modalidade;
        this.ganhoDeMassaMuscular = ganhoDeMassaMuscular;
        this.controleDePeso = controleDePeso;
        this.aumentoDaResistencia = aumentoDaResistencia;
        this.progressoesDeCarga = progressoesDeCarga;
        this.progressoesDeDificuldade = progressoesDeDificuldade;
        this.treinadorID = treinadorID;
    }

    public int getTreinoID() {
        return treinoID;
    }

    public int getClienteID() {
        return clienteID;
    }

    public Date getData() {
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

    public int getTreinadorID() {
        return treinadorID;
    }
}
