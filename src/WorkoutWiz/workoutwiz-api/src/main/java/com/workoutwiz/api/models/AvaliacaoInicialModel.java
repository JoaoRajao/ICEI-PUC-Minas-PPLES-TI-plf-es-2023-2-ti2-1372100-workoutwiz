package com.workoutwiz.api.models;


public class AvaliacaoInicialModel {
    private final int clienteId;
    private final int treinadorId;
    private final int idade;
    private final String sexo;
    private final String objetivos;
    private final String historicoTreinamento;
    private final String restricoesFisicas;
    private final String nivelCondicionamento;
    private final String preferenciaTreino;
    private final int disponibilidadeTempo;

    public AvaliacaoInicialModel(int clienteId, int treinadorId, int idade, String sexo, String objetivos, String historicoTreinamento, String restricoesFisicas, String nivelCondicionamento, String preferenciaTreino, int disponibilidadeTempo) {
        this.clienteId = clienteId;
        this.treinadorId = treinadorId;
        this.idade = idade;
        this.sexo = sexo;
        this.objetivos = objetivos;
        this.historicoTreinamento = historicoTreinamento;
        this.restricoesFisicas = restricoesFisicas;
        this.nivelCondicionamento = nivelCondicionamento;
        this.preferenciaTreino = preferenciaTreino;
        this.disponibilidadeTempo = disponibilidadeTempo;
    }


    public int getClienteId() { return clienteId; }

    public int getTreinadorId() { return treinadorId; }

    public int getIdade() { return idade; }

    public String getSexo() { return sexo; }

    public String getObjetivos() { return objetivos; }

    public String getHistoricoTreinamento() { return historicoTreinamento; }

    public String getRestricoesFisicas() { return restricoesFisicas; }

    public String getNivelCondicionamento() { return nivelCondicionamento; }

    public String getPreferenciaTreino() { return preferenciaTreino; }

    public int getDisponibilidadeTempo() { return disponibilidadeTempo; }




}
