package com.workoutwiz.api.models;

public class FeedBackModel {
    private final String clientId;
    private final String name;
    private final String publico;
    private final String text;

    public FeedBackModel(String clientId, String name, String publico, String text) {
        this.clientId = clientId;
        this.name = name;
        this.publico = publico;
        this.text = text;
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

    public String getText() {
        return text;
    }
}
