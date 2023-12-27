package com.workoutwiz.api.models;

public class ObjetivosModel {
    private final int clienteId;
    private final String descricao;

    public ObjetivosModel(int clienteId, String descricao) {
        this.clienteId = clienteId;
        this.descricao = descricao;
    }

    public int getClienteId() {
        return clienteId;
    }

    public String getDescricao() {
        return descricao;
    }
}