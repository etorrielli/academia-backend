package com.undec.academia.repository;

import com.undec.academia.model.Alumno;
import com.undec.academia.model.AlumnoCurso;
import com.undec.academia.model.Colegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlumnoCursoRepository extends JpaRepository<AlumnoCurso, Integer> {
}