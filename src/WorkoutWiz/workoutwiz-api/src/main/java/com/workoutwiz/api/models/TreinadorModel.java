package com.workoutwiz.api.models;

public class TreinadorModel {
    private final int treinadorId;
    private final String nome;
    private final String especialidade;
    private final String usuario;
    private final String senha;

    public TreinadorModel(int treinadorId, String nome, String especialidade, String senha, String usuario) {
        this.treinadorId = treinadorId;
        this.nome = nome;
        this.especialidade = especialidade;
        this.senha = senha;
        this.usuario = usuario;
    }

    public int getTreinadorId() {
        return treinadorId;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getSenha() {
        return senha;
    }

    public String getUsuario() {
        return usuario;
    }
}