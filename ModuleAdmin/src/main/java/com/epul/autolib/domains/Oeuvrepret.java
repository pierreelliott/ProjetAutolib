package com.epul.autolib.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "oeuvrepret", schema = "baseoeuvre", catalog = "")
public class Oeuvrepret {

    @Id
    @Column(name = "id_oeuvrepret", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "titre_oeuvrepret", nullable = false, length = 200)
    private String titre;

    @Basic
    @Column(name = "id_proprietaire", insertable =false, updatable=false, nullable = true)
    private Integer idProprietaire;

    @ManyToOne
    @JoinColumn(name = "id_proprietaire", referencedColumnName = "id_proprietaire")
    private Proprietaire proprietaire;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Integer idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oeuvrepret that = (Oeuvrepret) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(titre, that.titre) &&
                Objects.equals(idProprietaire, that.idProprietaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titre, idProprietaire);
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }
}
