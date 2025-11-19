package com.docencia.personas.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Direccion {

    @Field("calle")
    private String calle;

    @Field("ciudad")
    private String ciudad;

    @Field("codigo_postal")
    private String codigoPostal;

    @Field("pais")
    private String pais;

    public Direccion() {
    }

    public Direccion(String calle, String ciudad, String codigoPostal, String pais) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return calle + ", " + ciudad + " (" + codigoPostal + "), " + pais;
    }
}