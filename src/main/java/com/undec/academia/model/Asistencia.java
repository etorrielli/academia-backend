package com.undec.academia.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Asistencia {
    private Integer asistenciaId;
    private String diaNombre;
    private Date diaFecha;
    private String asistenciaObservaciones;
    private Curso cursoByCursoId;
    private Collection<DetalleAsistencia> DetalleAsistenciasByAsistenciaId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asistencia_id")
    public Integer getAsistenciaId() {
        return asistenciaId;
    }

    public void setAsistenciaId(Integer asistenciaId) {
        this.asistenciaId = asistenciaId;
    }

    @Basic
    @Column(name = "dia_nombre")
    public String getDiaNombre() {
        return diaNombre;
    }

    public void setDiaNombre(String diaNombre) {
        this.diaNombre = diaNombre;
    }

    @Basic
    @Column(name = "dia_fecha")
    public Date getDiaFecha() {
        return diaFecha;
    }

    public void setDiaFecha(Date diaFecha) {
        this.diaFecha = diaFecha;
    }

    @Basic
    @Column(name = "asistencia_observaciones")
    public String getAsistenciaObservaciones() {
        return asistenciaObservaciones;
    }

    public void setAsistenciaObservaciones(String asistenciaObservaciones) {
        this.asistenciaObservaciones = asistenciaObservaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asistencia that = (Asistencia) o;
        return Objects.equals(asistenciaId, that.asistenciaId) &&
                Objects.equals(diaNombre, that.diaNombre) &&
                Objects.equals(diaFecha, that.diaFecha) &&
                Objects.equals(asistenciaObservaciones, that.asistenciaObservaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asistenciaId, diaNombre, diaFecha, asistenciaObservaciones);
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cursoId")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "curso_id", nullable = false)
    public Curso getCursoByCursoId() {
        return cursoByCursoId;
    }

    public void setCursoByCursoId(Curso cursoByCursoId) {
        this.cursoByCursoId = cursoByCursoId;
    }

    @OneToMany(mappedBy = "asistenciaByAsistenciaId")
    public Collection<DetalleAsistencia> getDetalleAsistenciasByAsistenciaId() {
        return DetalleAsistenciasByAsistenciaId;
    }

    public void setDetalleAsistenciasByAsistenciaId(Collection<DetalleAsistencia> DetalleAsistenciasByAsistenciaId) {
        this.DetalleAsistenciasByAsistenciaId = DetalleAsistenciasByAsistenciaId;
    }
}
