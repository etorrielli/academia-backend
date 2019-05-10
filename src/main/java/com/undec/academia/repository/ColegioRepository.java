package com.undec.academia.repository;

import com.undec.academia.model.Colegio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColegioRepository extends JpaRepository<Colegio, Integer> {
}