package com.epul.autolib.domains;

import java.io.Serializable;
import java.util.Objects;

public class EntityReservationPK implements Serializable {

//    @Column(name = "id_oeuvrevente", insertable =false, updatable=false, nullable = false)
//    @Id
    private Integer idOeuvrevente;

//    @Column(name = "id_adherent",insertable =false, updatable=false,  nullable = false)
//    @Id
    private Integer idAdherent;

    public Integer getIdOeuvrevente() {
        return idOeuvrevente;
    }

    public void setIdOeuvrevente(Integer idOeuvrevente) {
        this.idOeuvrevente = idOeuvrevente;
    }

    public Integer getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(Integer idAdherent) {
        this.idAdherent = idAdherent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityReservationPK that = (EntityReservationPK) o;
        return Objects.equals(idOeuvrevente, that.idOeuvrevente) &&
                Objects.equals(idAdherent, that.idAdherent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idOeuvrevente, idAdherent);
    }
}
