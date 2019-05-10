package com.undec.academia.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipo_asignacion", schema = "ae3")
public class TipoAsignacion {
    private Integer TipoAsignacionId;
    private String TipoAsignacionNombre;
    private Collection<Curso> cursosByTipoAsignacionId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_asignacion_id")
    public Integer getTipoAsignacionId() {
        return TipoAsignacionId;
    }

    public void setTipoAsignacionId(Integer TipoAsignacionId) {
        this.TipoAsignacionId = TipoAsignacionId;
    }

    @Basic
    @Column(name = "tipo_asignacion_nombre")
    public String getTipoAsignacionNombre() {
        return TipoAsignacionNombre;
    }

    public void setTipoAsignacionNombre(String TipoAsignacionNombre) {
        this.TipoAsignacionNombre = TipoAsignacionNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoAsignacion that = (TipoAsignacion) o;
        return Objects.equals(TipoAsignacionId, that.TipoAsignacionId) &&
                Objects.equals(TipoAsignacionNombre, that.TipoAsignacionNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TipoAsignacionId, TipoAsignacionNombre);
    }

    @OneToMany(mappedBy = "tipoAsignacionByTipoAsignacionId")
    public Collection<Curso> getCursosByTipoAsignacionId() {
        return cursosByTipoAsignacionId;
    }

    public void setCursosByTipoAsignacionId(Collection<Curso> cursosByTipoAsignacionId) {
        this.cursosByTipoAsignacionId = cursosByTipoAsignacionId;
    }
}
