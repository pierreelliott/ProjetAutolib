package com.epul.autolib.bo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "station", schema = "autolib", catalog = "")
public class Station {
    private int id;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String adresse;
    private Integer numero;
    private String ville;
    private Integer codePostal;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "latitude")
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "adresse")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "numero")
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "ville")
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Basic
    @Column(name = "code_postal")
    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station that = (Station) o;
        return id == that.id &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(adresse, that.adresse) &&
                Objects.equals(numero, that.numero) &&
                Objects.equals(ville, that.ville) &&
                Objects.equals(codePostal, that.codePostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, latitude, longitude, adresse, numero, ville, codePostal);
    }

    @Transient
    public String getCoordonnees() {
        return latitude.setScale(2, BigDecimal.ROUND_HALF_EVEN) + "° N, "
                + longitude.setScale(2, BigDecimal.ROUND_HALF_EVEN) + "° O";
    }
}
