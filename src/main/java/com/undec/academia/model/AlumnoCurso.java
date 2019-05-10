package com.undec.academia.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "alumno_curso", schema = "ae3")
public class AlumnoCurso {
    private Integer AlumnoCursoId;
    private Date AlumnoCursoFechaAlta;
    private Date AlumnoCursoFechaBaja;
    private String AlumnoCursoObservaciones;
    private Byte AlumnoCursoBecado;
    private String usuario;
    private String pc;
    private Timestamp fyh;
    private Alumno alumnoByAlumnoId;
    private Curso cursoByCursoId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_curso_id")
    public Integer getAlumnoCursoId() {
        return AlumnoCursoId;
    }

    public void setAlumnoCursoId(Integer AlumnoCursoId) {
        this.AlumnoCursoId = AlumnoCursoId;
    }

    @Basic
    @Column(name = "alumno_curso_fecha_alta")
    public Date getAlumnoCursoFechaAlta() {
        return AlumnoCursoFechaAlta;
    }

    public void setAlumnoCursoFechaAlta(Date AlumnoCursoFechaAlta) {
        this.AlumnoCursoFechaAlta = AlumnoCursoFechaAlta;
    }

    @Basic
    @Column(name = "alumno_curso_fecha_baja")
    public Date getAlumnoCursoFechaBaja() {
        return AlumnoCursoFechaBaja;
    }

    public void setAlumnoCursoFechaBaja(Date AlumnoCursoFechaBaja) {
        this.AlumnoCursoFechaBaja = AlumnoCursoFechaBaja;
    }

    @Basic
    @Column(name = "alumno_curso_observaciones")
    public String getAlumnoCursoObservaciones() {
        return AlumnoCursoObservaciones;
    }

    public void setAlumnoCursoObservaciones(String AlumnoCursoObservaciones) {
        this.AlumnoCursoObservaciones = AlumnoCursoObservaciones;
    }

    @Basic
    @Column(name = "alumno_curso_becado")
    public Byte getAlumnoCursoBecado() {
        return AlumnoCursoBecado;
    }

    public void setAlumnoCursoBecado(Byte AlumnoCursoBecado) {
        this.AlumnoCursoBecado = AlumnoCursoBecado;
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
        AlumnoCurso that = (AlumnoCurso) o;
        return Objects.equals(AlumnoCursoId, that.AlumnoCursoId) &&
                Objects.equals(AlumnoCursoFechaAlta, that.AlumnoCursoFechaAlta) &&
                Objects.equals(AlumnoCursoFechaBaja, that.AlumnoCursoFechaBaja) &&
                Objects.equals(AlumnoCursoObservaciones, that.AlumnoCursoObservaciones) &&
                Objects.equals(AlumnoCursoBecado, that.AlumnoCursoBecado) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(pc, that.pc) &&
                Objects.equals(fyh, that.fyh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AlumnoCursoId, AlumnoCursoFechaAlta, AlumnoCursoFechaBaja, AlumnoCursoObservaciones, AlumnoCursoBecado, usuario, pc, fyh);
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "alumnoId")
    @JsonIdentityReference(alwaysAsId = true)@ManyToOne
    @JoinColumn(name = "alumno_id", referencedColumnName = "alumno_id", nullable = false)
    public Alumno getAlumnoByAlumnoId() {
        return alumnoByAlumnoId;
    }

    public void setAlumnoByAlumnoId(Alumno alumnoByAlumnoId) {
        this.alumnoByAlumnoId = alumnoByAlumnoId;
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
