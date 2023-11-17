package com.workoutwiz.api.models;

public class ExerciciosModel {
    private final int exercicioID;
    private final int treinoID;
    private final String nomeDoExercicio;
    private final int numeroDeRepeticoes;
    private final int peso;

    public ExerciciosModel(int exercicioID, int treinoID, String nomeDoExercicio, int numeroDeRepeticoes, int peso) {
        this.exercicioID = exercicioID;
        this.treinoID = treinoID;
        this.nomeDoExercicio = nomeDoExercicio;
        this.numeroDeRepeticoes = numeroDeRepeticoes;
        this.peso = peso;
    }

    public int getExercicioID() {
        return exercicioID;
    }

    public int getTreinoID() {
        return treinoID;
    }

    public String getNomeDoExercicio() {
        return nomeDoExercicio;
    }

    public int getNumeroDeRepeticoes() {
        return numeroDeRepeticoes;
    }

    public int getPeso() {
        return peso;
    }
}
