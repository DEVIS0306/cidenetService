package com.cidenet.devis.model;

public enum Pais {

        COLOMBIA("COL", "COLOMBIA"),
         USA("USA","ESTADOS UNIDOS");

        private String tipoId;
         private String descripcion;

    private Pais(String tipoId, String descripcion) {
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
