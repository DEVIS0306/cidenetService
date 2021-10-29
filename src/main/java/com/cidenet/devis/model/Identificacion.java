package com.cidenet.devis.model;

public enum Identificacion {

    CEDULA_CIUDADANIA("CC","CEDULA"),
    CEDULA_EXTRANJERIA("CE", "CEDULA EXTRANJERIA"),
    PASAPORTE("PASAPORTE","PASAPORTE"),
    PERMISO_ESPECIAL("PP","PERMISO EMPESIAL");

    private String tipoId;
    private String descripcion;

    Identificacion(String tipoId, String descripcion) {
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
