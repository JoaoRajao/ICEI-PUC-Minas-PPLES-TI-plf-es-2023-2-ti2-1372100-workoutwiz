package com.workoutwiz.api.models;

public class FeedBackModel {
    private final String clientId;
    private final String name;
    private final String publico;
    private final String texto;
    private final Integer mediaSatisfacao;

    public FeedBackModel(String clientId, String name, String publico, String texto , Integer mediaSatisfacao ) {
        this.clientId = clientId;
        this.name = name;
        this.publico = publico;
        this.texto = texto;
        this.mediaSatisfacao = mediaSatisfacao;
    }

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getPublico() {
        return publico;
    }

    public String getTexto() {
        return texto;
    }

    public Integer getMediaSatisfacao() { return mediaSatisfacao;}
}
