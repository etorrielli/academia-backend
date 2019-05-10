package com.undec.academia.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Sexo {
    private Integer sexoId;
    private String sexoNombre;
    private Collection<Alumno> alumnosBySexoId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sexo_id")
    public Integer getSexoId() {
        return sexoId;
    }

    public void setSexoId(Integer sexoId) {
        this.sexoId = sexoId;
    }

    @Basic
    @Column(name = "sexo_nombre")
    public String getSexoNombre() {
        return sexoNombre;
    }

    public void setSexoNombre(String sexoNombre) {
        this.sexoNombre = sexoNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sexo sexo = (Sexo) o;
        return Objects.equals(sexoId, sexo.sexoId) &&
                Objects.equals(sexoNombre, sexo.sexoNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sexoId, sexoNombre);
    }

    @OneToMany(mappedBy = "sexoBySexoId")
    public Collection<Alumno> getAlumnosBySexoId() {
        return alumnosBySexoId;
    }

    public void setAlumnosBySexoId(Collection<Alumno> alumnosBySexoId) {
        this.alumnosBySexoId = alumnosBySexoId;
    }
}
