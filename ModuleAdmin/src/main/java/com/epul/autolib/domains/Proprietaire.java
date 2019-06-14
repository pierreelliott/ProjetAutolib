package com.epul.autolib.domains;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "proprietaire", schema = "baseoeuvre", catalog = "")
public class Proprietaire {
    private Integer id;
    private String nom;
    private String prenom;
    private Collection<Oeuvrepret> oeuvrepretsByIdProprietaire;
    private Collection<Oeuvrevente> oeuvreventesByIdProprietaire;

    @Id
    @Column(name = "id_proprietaire", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom_proprietaire", nullable = false, length = 100)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom_proprietaire", nullable = true, length = 100)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proprietaire that = (Proprietaire) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nom, prenom);
    }

    @OneToMany(mappedBy = "proprietaire")
    public Collection<Oeuvrepret> getOeuvrepretsByIdProprietaire() {
        return oeuvrepretsByIdProprietaire;
    }

    public void setOeuvrepretsByIdProprietaire(Collection<Oeuvrepret> oeuvrepretsByIdProprietaire) {
        this.oeuvrepretsByIdProprietaire = oeuvrepretsByIdProprietaire;
    }

    @OneToMany(mappedBy = "proprietaire")
    public Collection<Oeuvrevente> getOeuvreventesByIdProprietaire() {
        return oeuvreventesByIdProprietaire;
    }

    public void setOeuvreventesByIdProprietaire(Collection<Oeuvrevente> oeuvreventesByIdProprietaire) {
        this.oeuvreventesByIdProprietaire = oeuvreventesByIdProprietaire;
    }
}
