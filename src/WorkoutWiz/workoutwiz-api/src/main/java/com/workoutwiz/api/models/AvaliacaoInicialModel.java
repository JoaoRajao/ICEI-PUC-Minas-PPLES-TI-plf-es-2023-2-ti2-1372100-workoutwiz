package com.workoutwiz.api.models;

public class AvaliacaoInicialModel {
    private final int clienteId;
    private final int treinadorId;
    private final String objetivos;
    private final String historicoTreinamento;
    private final String restricoesFisicas;
    private final String nivelCondicionamento;
    private final String preferenciaTreino;
    private final String disponibilidadeTempo;

    public AvaliacaoInicialModel(int clienteId, int treinadorId, String objetivos, String historicoTreinamento, String restricoesFisicas, String nivelCondicionamento, String preferenciaTreino, String disponibilidadeTempo) {
        this.clienteId = clienteId;
        this.treinadorId = treinadorId;
        this.objetivos = objetivos;
        this.historicoTreinamento = historicoTreinamento;
        this.restricoesFisicas = restricoesFisicas;
        this.nivelCondicionamento = nivelCondicionamento;
        this.preferenciaTreino = preferenciaTreino;
        this.disponibilidadeTempo = disponibilidadeTempo;
    }

    public int getClienteId() { return clienteId; }

    public int getTreinadorId() { return treinadorId; }

    public String getObjetivos() { return objetivos; }

    public String getHistoricoTreinamento() { return historicoTreinamento; }

    public String getRestricoesFisicas() { return restricoesFisicas; }

    public String getNivelCondicionamento() { return nivelCondicionamento; }

    public String getPreferenciaTreino() { return preferenciaTreino; }

    public String getDisponibilidadeTempo() { return disponibilidadeTempo; }

    @Override
    public String toString() {
        return "AvaliacaoInicialModel{" +
                "clienteId=" + clienteId +
                ", treinadorId=" + treinadorId +
                ", objetivos='" + objetivos + '\'' +
                ", historicoTreinamento='" + historicoTreinamento + '\'' +
                ", restricoesFisicas='" + restricoesFisicas + '\'' +
                ", nivelCondicionamento='" + nivelCondicionamento + '\'' +
                ", preferenciaTreino='" + preferenciaTreino + '\'' +
                ", disponibilidadeTempo='" + disponibilidadeTempo + '\'' +
                '}';
    }

}
