package com.workoutwiz.api.models;

public class ExerciciosModel {
    private final String nomeDoExercicio;
    private final int numeroDeRepeticoes;
    private final int peso;

    public ExerciciosModel(String nomeDoExercicio, int numeroDeRepeticoes, int peso) {
        this.nomeDoExercicio = nomeDoExercicio;
        this.numeroDeRepeticoes = numeroDeRepeticoes;
        this.peso = peso;
    }

    public String getNomeDoExercicio() { return nomeDoExercicio; }

    public int getNumeroDeRepeticoes() { return numeroDeRepeticoes; }

    public int getPeso() { return peso; }
}
