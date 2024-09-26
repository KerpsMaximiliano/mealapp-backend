package com.alejobeliz.pentabyte.projects.mealapp.repository;

import com.alejobeliz.pentabyte.projects.mealapp.model.plato.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato,Long> {
}