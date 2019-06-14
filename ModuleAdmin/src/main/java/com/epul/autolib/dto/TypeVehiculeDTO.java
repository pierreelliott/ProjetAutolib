package com.epul.autolib.dto;

import com.epul.autolib.bo.TypeVehicule;

import javax.persistence.*;
import java.util.Objects;

public class TypeVehiculeDTO {
    private int idTypeVehicule;
    private String categorie;
    private String typeVehicule;

    private int nbVehiculesLibres;
    private int nbVehiculesReserves;
    private int nbVehiculesUtilises;

    public TypeVehiculeDTO() {

    }

    public TypeVehiculeDTO(TypeVehicule typeVehicule) {
        this.idTypeVehicule = typeVehicule.getIdTypeVehicule();
        this.categorie = typeVehicule.getCategorie();
        this.typeVehicule = typeVehicule.getTypeVehicule();
    }

    public int getIdTypeVehicule() {
        return idTypeVehicule;
    }

    public void setIdTypeVehicule(int idTypeVehicule) {
        this.idTypeVehicule = idTypeVehicule;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public int getNbVehiculesLibres() {
        return nbVehiculesLibres;
    }

    public void setNbVehiculesLibres(int nbVehiculesLibres) {
        this.nbVehiculesLibres = nbVehiculesLibres;
    }

    public int getNbVehiculesReserves() {
        return nbVehiculesReserves;
    }

    public void setNbVehiculesReserves(int nbVehiculesReserves) {
        this.nbVehiculesReserves = nbVehiculesReserves;
    }

    public int getNbVehiculesUtilises() {
        return nbVehiculesUtilises;
    }

    public void setNbVehiculesUtilises(int nbVehiculesUtilises) {
        this.nbVehiculesUtilises = nbVehiculesUtilises;
    }
}
