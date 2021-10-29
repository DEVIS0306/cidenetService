package com.cidenet.devis.model;

public enum Dominio {
    USA("USA","cidenet.com.us"),
    COLOMBIA("COLOMBIA","cidenet.com.co");


    private String tipoId;
    private String descripcion;


    Dominio(String tipoId, String descripcion) {
        this.tipoId = tipoId;
        this.descripcion = descripcion;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
