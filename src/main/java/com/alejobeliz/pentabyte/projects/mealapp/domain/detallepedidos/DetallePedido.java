package com.alejobeliz.pentabyte.projects.mealapp.domain.detallepedidos;

import com.alejobeliz.pentabyte.projects.mealapp.domain.pedidosdia.PedidosDia;
import com.alejobeliz.pentabyte.projects.mealapp.domain.plato.Plato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "DetallePedido")
@Table(name = "detalles_pedidos")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "pedido_dia_id")
    private PedidosDia pedidosDia;

    @ManyToOne
    @JoinColumn(name = "plato_id")
    private Plato plato;
}
