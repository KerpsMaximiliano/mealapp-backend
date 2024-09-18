package com.alejobeliz.pentabyte.projects.mealapp.model.plato;

import com.alejobeliz.pentabyte.projects.mealapp.model.tipodeplato.TipoDePlato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Plato")
@Table(name = "platos")
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "cantidad_maxima")
    private Integer cantidadMaxima;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "cantidad_veces_pedido")
    private Integer cantidadDeVecesPedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_plato_id")
    private TipoDePlato tipoDePlato;
}
