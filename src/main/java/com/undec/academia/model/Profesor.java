package com.undec.academia.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Profesor {
    private Integer profesorId;
    private String profesorNombre;
    private String profesorDni;
    private String profesorTelefono;
    private String profesorCelular;
    private String profesorAbreviatura;
    private String usuario;
    private String pc;
    private Timestamp fyh;
    private Collection<ProfesorCurso> ProfesorCursosByProfesorId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
    public Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }

    @Basic
    @Column(name = "profesor_nombre")
    public String getProfesorNombre() {
        return profesorNombre;
    }

    public void setProfesorNombre(String profesorNombre) {
        this.profesorNombre = profesorNombre;
    }

    @Basic
    @Column(name = "profesor_dni")
    public String getProfesorDni() {
        return profesorDni;
    }

    public void setProfesorDni(String profesorDni) {
        this.profesorDni = profesorDni;
    }

    @Basic
    @Column(name = "profesor_telefono")
    public String getProfesorTelefono() {
        return profesorTelefono;
    }

    public void setProfesorTelefono(String profesorTelefono) {
        this.profesorTelefono = profesorTelefono;
    }

    @Basic
    @Column(name = "profesor_celular")
    public String getProfesorCelular() {
        return profesorCelular;
    }

    public void setProfesorCelular(String profesorCelular) {
        this.profesorCelular = profesorCelular;
    }

    @Basic
    @Column(name = "profesor_abreviatura")
    public String getProfesorAbreviatura() {
        return profesorAbreviatura;
    }

    public void setProfesorAbreviatura(String profesorAbreviatura) {
        this.profesorAbreviatura = profesorAbreviatura;
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
        Profesor profesor = (Profesor) o;
        return Objects.equals(profesorId, profesor.profesorId) &&
                Objects.equals(profesorNombre, profesor.profesorNombre) &&
                Objects.equals(profesorDni, profesor.profesorDni) &&
                Objects.equals(profesorTelefono, profesor.profesorTelefono) &&
                Objects.equals(profesorCelular, profesor.profesorCelular) &&
                Objects.equals(profesorAbreviatura, profesor.profesorAbreviatura) &&
                Objects.equals(usuario, profesor.usuario) &&
                Objects.equals(pc, profesor.pc) &&
                Objects.equals(fyh, profesor.fyh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profesorId, profesorNombre, profesorDni, profesorTelefono, profesorCelular, profesorAbreviatura, usuario, pc, fyh);
    }

    @OneToMany(mappedBy = "profesorByProfesorId")
    public Collection<ProfesorCurso> getProfesorCursosByProfesorId() {
        return ProfesorCursosByProfesorId;
    }

    public void setProfesorCursosByProfesorId(Collection<ProfesorCurso> ProfesorCursosByProfesorId) {
        this.ProfesorCursosByProfesorId = ProfesorCursosByProfesorId;
    }
}
