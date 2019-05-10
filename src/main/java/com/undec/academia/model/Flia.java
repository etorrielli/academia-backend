package com.undec.academia.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Flia {
    private Integer fliaId;
    private String fliaNombre;
    private Collection<Alumno> alumnosByFliaId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flia_id")
    public Integer getFliaId() {
        return fliaId;
    }

    public void setFliaId(Integer fliaId) {
        this.fliaId = fliaId;
    }

    @Basic
    @Column(name = "flia_nombre")
    public String getFliaNombre() {
        return fliaNombre;
    }

    public void setFliaNombre(String fliaNombre) {
        this.fliaNombre = fliaNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flia flia = (Flia) o;
        return Objects.equals(fliaId, flia.fliaId) &&
                Objects.equals(fliaNombre, flia.fliaNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fliaId, fliaNombre);
    }

    @OneToMany(mappedBy = "fliaByFliaId")
    public Collection<Alumno> getAlumnosByFliaId() {
        return alumnosByFliaId;
    }

    public void setAlumnosByFliaId(Collection<Alumno> alumnosByFliaId) {
        this.alumnosByFliaId = alumnosByFliaId;
    }
}
