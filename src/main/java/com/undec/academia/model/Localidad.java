package com.undec.academia.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Localidad {
    private Integer localidadId;
    private String localidadNombre;
    private Collection<Alumno> alumnosByLocalidadId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "localidad_id")
    public Integer getLocalidadId() {
        return localidadId;
    }

    public void setLocalidadId(Integer localidadId) {
        this.localidadId = localidadId;
    }

    @Basic
    @Column(name = "localidad_nombre")
    public String getLocalidadNombre() {
        return localidadNombre;
    }

    public void setLocalidadNombre(String localidadNombre) {
        this.localidadNombre = localidadNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localidad localidad = (Localidad) o;
        return Objects.equals(localidadId, localidad.localidadId) &&
                Objects.equals(localidadNombre, localidad.localidadNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localidadId, localidadNombre);
    }

    @OneToMany(mappedBy = "localidadByLocalidadId")
    public Collection<Alumno> getAlumnosByLocalidadId() {
        return alumnosByLocalidadId;
    }

    public void setAlumnosByLocalidadId(Collection<Alumno> alumnosByLocalidadId) {
        this.alumnosByLocalidadId = alumnosByLocalidadId;
    }
}
