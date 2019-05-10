package com.undec.academia.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "detalle_asistencia", schema = "ae3")
public class DetalleAsistencia {
    private Integer DetalleAsistenciaId;
    private String presente;
    private String DetalleAsistenciaObservaciones;
    private Asistencia asistenciaByAsistenciaId;
    private Alumno alumnoByAlumnoId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_asistencia_id")
    public Integer getDetalleAsistenciaId() {
        return DetalleAsistenciaId;
    }

    public void setDetalleAsistenciaId(Integer DetalleAsistenciaId) {
        this.DetalleAsistenciaId = DetalleAsistenciaId;
    }

    @Basic
    @Column(name = "presente")
    public String getPresente() {
        return presente;
    }

    public void setPresente(String presente) {
        this.presente = presente;
    }

    @Basic
    @Column(name = "detalle_asistencia_observaciones")
    public String getDetalleAsistenciaObservaciones() {
        return DetalleAsistenciaObservaciones;
    }

    public void setDetalleAsistenciaObservaciones(String DetalleAsistenciaObservaciones) {
        this.DetalleAsistenciaObservaciones = DetalleAsistenciaObservaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleAsistencia that = (DetalleAsistencia) o;
        return Objects.equals(DetalleAsistenciaId, that.DetalleAsistenciaId) &&
                Objects.equals(presente, that.presente) &&
                Objects.equals(DetalleAsistenciaObservaciones, that.DetalleAsistenciaObservaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DetalleAsistenciaId, presente, DetalleAsistenciaObservaciones);
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "asistenciaId")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "asistencia_id", referencedColumnName = "asistencia_id", nullable = false)
    public Asistencia getAsistenciaByAsistenciaId() {
        return asistenciaByAsistenciaId;
    }

    public void setAsistenciaByAsistenciaId(Asistencia asistenciaByAsistenciaId) {
        this.asistenciaByAsistenciaId = asistenciaByAsistenciaId;
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "alumnoId")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "alumno_id", referencedColumnName = "alumno_id", nullable = false)
    public Alumno getAlumnoByAlumnoId() {
        return alumnoByAlumnoId;
    }

    public void setAlumnoByAlumnoId(Alumno alumnoByAlumnoId) {
        this.alumnoByAlumnoId = alumnoByAlumnoId;
    }
}
