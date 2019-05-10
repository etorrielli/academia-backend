package com.undec.academia.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Colegio {
    private Integer colegioId;
    private String colegioNombre;
    private Collection<Alumno> alumnosByColegioId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "colegio_id")
    public Integer getColegioId() {
        return colegioId;
    }

    public void setColegioId(Integer colegioId) {
        this.colegioId = colegioId;
    }

    @Basic
    @Column(name = "colegio_nombre")
    public String getColegioNombre() {
        return colegioNombre;
    }

    public void setColegioNombre(String colegioNombre) {
        this.colegioNombre = colegioNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colegio colegio = (Colegio) o;
        return Objects.equals(colegioId, colegio.colegioId) &&
                Objects.equals(colegioNombre, colegio.colegioNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colegioId, colegioNombre);
    }

    @OneToMany(mappedBy = "colegioByColegioId")
    public Collection<Alumno> getAlumnosByColegioId() {
        return alumnosByColegioId;
    }

    public void setAlumnosByColegioId(Collection<Alumno> alumnosByColegioId) {
        this.alumnosByColegioId = alumnosByColegioId;
    }
}
