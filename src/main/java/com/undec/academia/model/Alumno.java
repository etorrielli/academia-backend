package com.undec.academia.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Alumno {
    private Integer alumnoId;
    private String alumnoNombre;
    private String alumnoDni;
    private Date alumnoFechaNacimiento;
    private String alumnoTelefono;
    private String alumnoCelular;
    private String alumnoMail;
    private String alumnoCalle;
    private String alumnoNro;
    private String alumnoBarrio;
    private String usuario;
    private String pc;
    private Timestamp fyh;
    private Sexo sexoBySexoId;
    private Localidad localidadByLocalidadId;
    private Flia fliaByFliaId;
    private Colegio colegioByColegioId;
    private Collection<AlumnoCurso> alumnoCursosByAlumnoId;
    private Collection<DetalleAsistencia> detalleAsistenciasByAlumnoId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_id")
    public Integer getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Integer alumnoId) {
        this.alumnoId = alumnoId;
    }

    @Basic
    @Column(name = "alumno_nombre")
    public String getAlumnoNombre() {
        return alumnoNombre;
    }

    public void setAlumnoNombre(String alumnoNombre) {
        this.alumnoNombre = alumnoNombre;
    }

    @Basic
    @Column(name = "alumno_dni")
    public String getAlumnoDni() {
        return alumnoDni;
    }

    public void setAlumnoDni(String alumnoDni) {
        this.alumnoDni = alumnoDni;
    }

    @Basic
    @Column(name = "alumno_fecha_nacimiento")
    public Date getAlumnoFechaNacimiento() {
        return alumnoFechaNacimiento;
    }

    public void setAlumnoFechaNacimiento(Date alumnoFechaNacimiento) {
        this.alumnoFechaNacimiento = alumnoFechaNacimiento;
    }

    @Basic
    @Column(name = "alumno_telefono")
    public String getAlumnoTelefono() {
        return alumnoTelefono;
    }

    public void setAlumnoTelefono(String alumnoTelefono) {
        this.alumnoTelefono = alumnoTelefono;
    }

    @Basic
    @Column(name = "alumno_celular")
    public String getAlumnoCelular() {
        return alumnoCelular;
    }

    public void setAlumnoCelular(String alumnoCelular) {
        this.alumnoCelular = alumnoCelular;
    }

    @Basic
    @Column(name = "alumno_mail")
    public String getAlumnoMail() {
        return alumnoMail;
    }

    public void setAlumnoMail(String alumnoMail) {
        this.alumnoMail = alumnoMail;
    }

    @Basic
    @Column(name = "alumno_calle")
    public String getAlumnoCalle() {
        return alumnoCalle;
    }

    public void setAlumnoCalle(String alumnoCalle) {
        this.alumnoCalle = alumnoCalle;
    }

    @Basic
    @Column(name = "alumno_nro")
    public String getAlumnoNro() {
        return alumnoNro;
    }

    public void setAlumnoNro(String alumnoNro) {
        this.alumnoNro = alumnoNro;
    }

    @Basic
    @Column(name = "alumno_barrio")
    public String getAlumnoBarrio() {
        return alumnoBarrio;
    }

    public void setAlumnoBarrio(String alumnoBarrio) {
        this.alumnoBarrio = alumnoBarrio;
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
        Alumno alumno = (Alumno) o;
        return Objects.equals(alumnoId, alumno.alumnoId) &&
                Objects.equals(alumnoNombre, alumno.alumnoNombre) &&
                Objects.equals(alumnoDni, alumno.alumnoDni) &&
                Objects.equals(alumnoFechaNacimiento, alumno.alumnoFechaNacimiento) &&
                Objects.equals(alumnoTelefono, alumno.alumnoTelefono) &&
                Objects.equals(alumnoCelular, alumno.alumnoCelular) &&
                Objects.equals(alumnoMail, alumno.alumnoMail) &&
                Objects.equals(alumnoCalle, alumno.alumnoCalle) &&
                Objects.equals(alumnoNro, alumno.alumnoNro) &&
                Objects.equals(alumnoBarrio, alumno.alumnoBarrio) &&
                Objects.equals(usuario, alumno.usuario) &&
                Objects.equals(pc, alumno.pc) &&
                Objects.equals(fyh, alumno.fyh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alumnoId, alumnoNombre, alumnoDni, alumnoFechaNacimiento, alumnoTelefono, alumnoCelular, alumnoMail, alumnoCalle, alumnoNro, alumnoBarrio, usuario, pc, fyh);
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "sexoId")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "sexo_id", referencedColumnName = "sexo_id", nullable = false)
    public Sexo getSexoBySexoId() {
        return sexoBySexoId;
    }

    public void setSexoBySexoId(Sexo sexoBySexoId) {
        this.sexoBySexoId = sexoBySexoId;
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "localidadId")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "localidad_id", referencedColumnName = "localidad_id", nullable = false)
    public Localidad getLocalidadByLocalidadId() {
        return localidadByLocalidadId;
    }

    public void setLocalidadByLocalidadId(Localidad localidadByLocalidadId) {
        this.localidadByLocalidadId = localidadByLocalidadId;
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "fliaId")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "flia_id", referencedColumnName = "flia_id", nullable = false)
    public Flia getFliaByFliaId() {
        return fliaByFliaId;
    }

    public void setFliaByFliaId(Flia fliaByFliaId) {
        this.fliaByFliaId = fliaByFliaId;
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "colegioId")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "colegio_id", referencedColumnName = "colegio_id", nullable = false)
    public Colegio getColegioByColegioId() {
        return colegioByColegioId;
    }

    public void setColegioByColegioId(Colegio colegioByColegioId) {
        this.colegioByColegioId = colegioByColegioId;
    }

    @OneToMany(mappedBy = "alumnoByAlumnoId")
    public Collection<AlumnoCurso> getAlumnoCursosByAlumnoId() {
        return alumnoCursosByAlumnoId;
    }

    public void setAlumnoCursosByAlumnoId(Collection<AlumnoCurso> AlumnoCursosByAlumnoId) {
        this.alumnoCursosByAlumnoId = AlumnoCursosByAlumnoId;
    }

    @OneToMany(mappedBy = "alumnoByAlumnoId")
    public Collection<DetalleAsistencia> getDetalleAsistenciasByAlumnoId() {
        return detalleAsistenciasByAlumnoId;
    }

    public void setDetalleAsistenciasByAlumnoId(Collection<DetalleAsistencia> DetalleAsistenciasByAlumnoId) {
        this.detalleAsistenciasByAlumnoId = DetalleAsistenciasByAlumnoId;
    }
}
