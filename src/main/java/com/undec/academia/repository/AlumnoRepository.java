package com.undec.academia.repository;

import com.undec.academia.model.Alumno;
import com.undec.academia.model.Colegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    List<Alumno> findAllByAlumnoNombreAndFyhIsNotNull(String nombre);

    @Query("SELECT a " +
            "FROM Alumno a " +
            "WHERE a.colegioByColegioId = :colegio " +
            "AND a.fyh is not null")
    List<Alumno> findAllByColegio(@Param("colegio") Colegio colegio);

    @Query(value = "SELECT a.alumno_id, " +
            "concat(a.alumno_dni, ' - ', a.alumno_nombre)," +
            "c.colegio_nombre, " +
            "f.flia_nombre " +
            "FROM alumno a, " +
            "colegio c, " +
            "flia f " +
            "WHERE a.colegio_id = c.colegio_id " +
            "AND a.flia_id = f.flia_id " +
            "AND a.colegio_id = :colegioId", nativeQuery = true)
    Object[][] findDatosFull(@Param("colegioId") Integer colegioId);

}