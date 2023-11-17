package com.workoutwiz.api.models;

public class AprimoramentoModel {
    private final int aprimoramentoID;
    private final int treinoID;
    private final String execucoesDosMovimentos;
    private final String descricaoDaExecucao;
    private final String dicasDeSeguranca;
    private final String feedback;

    public AprimoramentoModel(int aprimoramentoID, int treinoID, String execucoesDosMovimentos,
                              String descricaoDaExecucao, String dicasDeSeguranca, String feedback) {
        this.aprimoramentoID = aprimoramentoID;
        this.treinoID = treinoID;
        this.execucoesDosMovimentos = execucoesDosMovimentos;
        this.descricaoDaExecucao = descricaoDaExecucao;
        this.dicasDeSeguranca = dicasDeSeguranca;
        this.feedback = feedback;
    }

    public int getAprimoramentoID() {
        return aprimoramentoID;
    }

    public int getTreinoID() {
        return treinoID;
    }

    public String getExecucoesDosMovimentos() {
        return execucoesDosMovimentos;
    }

    public String getDescricaoDaExecucao() {
        return descricaoDaExecucao;
    }

    public String getDicasDeSeguranca() {
        return dicasDeSeguranca;
    }

    public String getFeedback() {
        return feedback;
    }
}
