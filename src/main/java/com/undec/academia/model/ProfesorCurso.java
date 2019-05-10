package com.undec.academia.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "profesor_curso", schema = "ae3")
public class ProfesorCurso {
    private Integer ProfesorCursoId;
    private Date ProfesorCursoFechaAlta;
    private Date ProfesorCursoFechaBaja;
    private String ProfesorCursoObservaciones;
    private String usuario;
    private String pc;
    private Timestamp fyh;
    private Profesor profesorByProfesorId;
    private Curso cursoByCursoId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_curso_id")
    public Integer getProfesorCursoId() {
        return ProfesorCursoId;
    }

    public void setProfesorCursoId(Integer ProfesorCursoId) {
        this.ProfesorCursoId = ProfesorCursoId;
    }

    @Basic
    @Column(name = "profesor_curso_fecha_alta")
    public Date getProfesorCursoFechaAlta() {
        return ProfesorCursoFechaAlta;
    }

    public void setProfesorCursoFechaAlta(Date ProfesorCursoFechaAlta) {
        this.ProfesorCursoFechaAlta = ProfesorCursoFechaAlta;
    }

    @Basic
    @Column(name = "profesor_curso_fecha_baja")
    public Date getProfesorCursoFechaBaja() {
        return ProfesorCursoFechaBaja;
    }

    public void setProfesorCursoFechaBaja(Date ProfesorCursoFechaBaja) {
        this.ProfesorCursoFechaBaja = ProfesorCursoFechaBaja;
    }

    @Basic
    @Column(name = "profesor_curso_observaciones")
    public String getProfesorCursoObservaciones() {
        return ProfesorCursoObservaciones;
    }

    public void setProfesorCursoObservaciones(String ProfesorCursoObservaciones) {
        this.ProfesorCursoObservaciones = ProfesorCursoObservaciones;
    }

    @Basic
    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "pc")
    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    @Basic
    @Column(name = "fyh")
    public Timestamp getFyh() {
        return fyh;
    }

    public void setFyh(Timestamp fyh) {
        this.fyh = fyh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfesorCurso that = (ProfesorCurso) o;
        return Objects.equals(ProfesorCursoId, that.ProfesorCursoId) &&
                Objects.equals(ProfesorCursoFechaAlta, that.ProfesorCursoFechaAlta) &&
                Objects.equals(ProfesorCursoFechaBaja, that.ProfesorCursoFechaBaja) &&
                Objects.equals(ProfesorCursoObservaciones, that.ProfesorCursoObservaciones) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(pc, that.pc) &&
                Objects.equals(fyh, that.fyh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProfesorCursoId, ProfesorCursoFechaAlta, ProfesorCursoFechaBaja, ProfesorCursoObservaciones, usuario, pc, fyh);
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "profesorId")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "profesor_id", referencedColumnName = "profesor_id", nullable = false)
    public Profesor getProfesorByProfesorId() {
        return profesorByProfesorId;
    }

    public void setProfesorByProfesorId(Profesor profesorByProfesorId) {
        this.profesorByProfesorId = profesorByProfesorId;
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
}
