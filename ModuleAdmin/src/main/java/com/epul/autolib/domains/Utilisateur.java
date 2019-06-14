package com.epul.autolib.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "utilisateur", schema = "baseoeuvre", catalog = "")
public class Utilisateur {

    @Id
    @Column(name = "numutil", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "nomutil", nullable = false, length = 100)
    private String nomUtil;

    @Basic
    @Column(name = "motpasse", nullable = false, length = 100)
    private String motPasse;

    @Basic
    @Column(name = "role", nullable = false, length = 100)
    private String role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomUtil() {
        return nomUtil;
    }

    public void setNomUtil(String nomUtil) {
        this.nomUtil = nomUtil;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nomUtil, that.nomUtil) &&
                Objects.equals(motPasse, that.motPasse) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nomUtil, motPasse, role);
    }
}
