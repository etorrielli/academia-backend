package com.undec.academia.repository;

import com.undec.academia.model.Alumno;
import com.undec.academia.model.Colegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    List<Alumno> findAllByAlumnoNombre(String nombre);

    @Query("SELECT a " +
            "FROM  Alumno a " +
            "WHERE a.colegioByColegioId = :colId " +
            "AND a.fyh is not null")
    List<Alumno> findAllByColegioIdAndFyhNotNull(@Param("colId") Colegio colId);

    @Query(value = "" +
            "SELECT a.alumno_id, " +
            "concat(a.alumno_dni,' - ',a.alumno_nombre), " +
            "c.colegio_nombre, " +
            "f.flia_nombre " +
            "FROM Alumno a, " +
            "Colegio c, " +
            "Flia f  " +
            "WHERE a.colegio_id = c.colegio_id " +
            "AND a.flia_id = f.flia_id " +
            "AND a.colegio_id = :colId " +
            "AND a.fyh is not null", nativeQuery = true)
    Object[][] findAllDatosCompletos(@Param("colId") Integer colId);

}