package com.epul.autolib.domains;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "oeuvrevente", schema = "baseoeuvre", catalog = "")
public class Oeuvrevente {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_oeuvrevente", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "titre_oeuvrevente", nullable = false, length = 200)
    private String titre;

    @Basic
    @Column(name = "etat_oeuvrevente", nullable = false, length = 1)
    private String etat;

    @Basic
    @Column(name = "prix_oeuvrevente", nullable = false, precision = 0)
    private Double prix;

    @Basic
    @Column(name = "id_proprietaire", insertable =false, updatable=false, nullable = true)
    private Integer idProprietaire;

    @ManyToOne
    @JoinColumn(name = "id_proprietaire", referencedColumnName = "id_proprietaire")
    private Proprietaire proprietaire;

    @OneToMany(mappedBy = "oeuvre")
    private Collection<Reservation> reservations;



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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oeuvrevente that = (Oeuvrevente) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(titre, that.titre) &&
                Objects.equals(etat, that.etat) &&
                Objects.equals(prix, that.prix) &&
                Objects.equals(proprietaire, that.proprietaire);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, titre, etat, prix, proprietaire);
    }

    public Integer getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Integer idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }
}
