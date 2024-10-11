package com.alejobeliz.pentabyte.projects.mealapp.repository;

import com.alejobeliz.pentabyte.projects.mealapp.model.disponibilidadsemanal.DisponibilidadSemanal;
import com.alejobeliz.pentabyte.projects.mealapp.model.plato.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DisponibilidadSemanalRepository extends JpaRepository<DisponibilidadSemanal,Long> {

    @Query("""
    SELECT d.plato
    FROM DisponibilidadSemanal d
    WHERE d.semanaDeInicio = :fechaDeInicio
    AND d.plato.tipoDePlato.nombre = :tipoDePlato
    AND CASE :dia
            WHEN 'lunes' THEN d.lunes
            WHEN 'martes' THEN d.martes
            WHEN 'miercoles' THEN d.miercoles
            WHEN 'jueves' THEN d.jueves
            WHEN 'viernes' THEN d.viernes
        END = true
""")
    List<Plato> getDisponibilidadSemanalByFechaAndTipoDePlatoAndDia(LocalDate fechaDeInicio, String tipoDePlato, String dia);


}

