package com.undec.academia.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Curso {
    private Integer cursoId;
    private String cursoNombre;
    private String cursoAbreviatura;
    private String cursoDescripcion;
    private Double cursoPrecio;
    private Double cursoInscripcion;
    private Integer cursoDiaClase;
    private Integer cursoHoraClase;
    private Byte cursoActivo;
    private String usuario;
    private String pc;
    private Timestamp fyh;
    private Collection<AlumnoCurso> alumnoCursosByCursoId;
    private Collection<Asistencia> asistenciasByCursoId;
    private TipoAsignacion tipoAsignacionByTipoAsignacionId;
    private Collection<ProfesorCurso> profesorCursosByCursoId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    @Basic
    @Column(name = "curso_nombre")
    public String getCursoNombre() {
        return cursoNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }

    @Basic
    @Column(name = "curso_abreviatura")
    public String getCursoAbreviatura() {
        return cursoAbreviatura;
    }

    public void setCursoAbreviatura(String cursoAbreviatura) {
        this.cursoAbreviatura = cursoAbreviatura;
    }

    @Basic
    @Column(name = "curso_descripcion")
    public String getCursoDescripcion() {
        return cursoDescripcion;
    }

    public void setCursoDescripcion(String cursoDescripcion) {
        this.cursoDescripcion = cursoDescripcion;
    }

    @Basic
    @Column(name = "curso_precio")
    public Double getCursoPrecio() {
        return cursoPrecio;
    }

    public void setCursoPrecio(Double cursoPrecio) {
        this.cursoPrecio = cursoPrecio;
    }

    @Basic
    @Column(name = "curso_inscripcion")
    public Double getCursoInscripcion() {
        return cursoInscripcion;
    }

    public void setCursoInscripcion(Double cursoInscripcion) {
        this.cursoInscripcion = cursoInscripcion;
    }

    @Basic
    @Column(name = "curso_dia_clase")
    public Integer getCursoDiaClase() {
        return cursoDiaClase;
    }

    public void setCursoDiaClase(Integer cursoDiaClase) {
        this.cursoDiaClase = cursoDiaClase;
    }

    @Basic
    @Column(name = "curso_hora_clase")
    public Integer getCursoHoraClase() {
        return cursoHoraClase;
    }

    public void setCursoHoraClase(Integer cursoHoraClase) {
        this.cursoHoraClase = cursoHoraClase;
    }

    @Basic
    @Column(name = "curso_activo")
    public Byte getCursoActivo() {
        return cursoActivo;
    }

    public void setCursoActivo(Byte cursoActivo) {
        this.cursoActivo = cursoActivo;
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
        Curso curso = (Curso) o;
        return Objects.equals(cursoId, curso.cursoId) &&
                Objects.equals(cursoNombre, curso.cursoNombre) &&
                Objects.equals(cursoAbreviatura, curso.cursoAbreviatura) &&
                Objects.equals(cursoDescripcion, curso.cursoDescripcion) &&
                Objects.equals(cursoPrecio, curso.cursoPrecio) &&
                Objects.equals(cursoInscripcion, curso.cursoInscripcion) &&
                Objects.equals(cursoDiaClase, curso.cursoDiaClase) &&
                Objects.equals(cursoHoraClase, curso.cursoHoraClase) &&
                Objects.equals(cursoActivo, curso.cursoActivo) &&
                Objects.equals(usuario, curso.usuario) &&
                Objects.equals(pc, curso.pc) &&
                Objects.equals(fyh, curso.fyh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursoId, cursoNombre, cursoAbreviatura, cursoDescripcion, cursoPrecio, cursoInscripcion, cursoDiaClase, cursoHoraClase, cursoActivo, usuario, pc, fyh);
    }

    @OneToMany(mappedBy = "cursoByCursoId")
    public Collection<AlumnoCurso> getAlumnoCursosByCursoId() {
        return alumnoCursosByCursoId;
    }

    public void setAlumnoCursosByCursoId(Collection<AlumnoCurso> AlumnoCursosByCursoId) {
        this.alumnoCursosByCursoId = AlumnoCursosByCursoId;
    }

    @OneToMany(mappedBy = "cursoByCursoId")
    public Collection<Asistencia> getAsistenciasByCursoId() {
        return asistenciasByCursoId;
    }

    public void setAsistenciasByCursoId(Collection<Asistencia> asistenciasByCursoId) {
        this.asistenciasByCursoId = asistenciasByCursoId;
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "tipoAsignacionId")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "tipo_asignacion_id", referencedColumnName = "tipo_asignacion_id")
    public TipoAsignacion getTipoAsignacionByTipoAsignacionId() {
        return tipoAsignacionByTipoAsignacionId;
    }

    public void setTipoAsignacionByTipoAsignacionId(TipoAsignacion TipoAsignacionByTipoAsignacionId) {
        this.tipoAsignacionByTipoAsignacionId = TipoAsignacionByTipoAsignacionId;
    }

    @OneToMany(mappedBy = "cursoByCursoId")
    public Collection<ProfesorCurso> getProfesorCursosByCursoId() {
        return profesorCursosByCursoId;
    }

    public void setProfesorCursosByCursoId(Collection<ProfesorCurso> ProfesorCursosByCursoId) {
        this.profesorCursosByCursoId = ProfesorCursosByCursoId;
    }
}
