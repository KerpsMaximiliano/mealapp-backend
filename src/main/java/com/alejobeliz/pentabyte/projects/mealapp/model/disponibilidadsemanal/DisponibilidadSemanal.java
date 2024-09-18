package com.alejobeliz.pentabyte.projects.mealapp.model.disponibilidadsemanal;


import com.alejobeliz.pentabyte.projects.mealapp.model.plato.Plato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "DisponibilidadSemanal")
@Table(name = "disponibilidad_semanal")
public class DisponibilidadSemanal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  @Column(name = "semana_inicio")
    private LocalDate semanaDeInicio;

    @ManyToOne
    @JoinColumn(name = "plato_id")
    private Plato plato;

    @Column(name = "lunes")
    private Boolean lunes;

    @Column(name = "martes")
    private Boolean martes;

    @Column(name = "miercoles")
    private Boolean miercoles;

    @Column(name = "jueves")
    private Boolean jueves;

    @Column(name = "viernes")
    private Boolean viernes;
}