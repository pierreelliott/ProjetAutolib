package com.epul.autolib.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "adherent", schema = "baseoeuvre", catalog = "")
public class Adherent {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_adherent", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "nom_adherent", nullable = false, length = 100)
    private String nom;

    @Basic
    @Column(name = "prenom_adherent", nullable = true, length = 100)
    private String prenom;

    @Basic
    @Column(name = "ville_adherent", nullable = true, length = 100)
    private String ville;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adherent that = (Adherent) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(ville, that.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, ville);
    }
}
