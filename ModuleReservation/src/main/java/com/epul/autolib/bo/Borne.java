package com.epul.autolib.bo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "borne", schema = "autolib", catalog = "")
public class Borne {
    private int idBorne;
    private boolean etatBorne;
    private Station station;

    @Id
    @Column(name = "idBorne")
    public int getIdBorne() {
        return idBorne;
    }

    public void setIdBorne(int idBorne) {
        this.idBorne = idBorne;
    }

    @Basic
    @Column(name = "etatBorne")
    public boolean getEtatBorne() {
        return etatBorne;
    }

    public void setEtatBorne(boolean etatBorne) {
        this.etatBorne = etatBorne;
    }

    @ManyToOne
    @JoinColumn(name = "station", referencedColumnName = "id")
    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borne that = (Borne) o;
        return idBorne == that.idBorne &&
                etatBorne == that.etatBorne &&
                Objects.equals(station, that.station);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBorne, etatBorne);
    }
}
