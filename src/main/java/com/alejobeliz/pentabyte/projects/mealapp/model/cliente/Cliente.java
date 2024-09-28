package com.alejobeliz.pentabyte.projects.mealapp.model.cliente;

import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDatosPersonalesDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDiasLaboralesDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity(name = "Cliente")
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "documento")
    private String documento;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name="fecha_alta")
    private LocalDateTime fechaDeAlta;

    @Column(name="fecha_baja")
    private LocalDateTime fechaDeBaja;

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

    public Cliente(String nombre, String apellido, String documento, String correo, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.activo=true;
        this.fechaDeAlta = LocalDateTime.now();
        this.fechaDeBaja = null;
        this.lunes = false;
        this.martes = false;
        this.miercoles = false;
        this.jueves = false;
        this.viernes = false;
    }

    public void modificarDiasLaborales(Cliente cliente, ClienteDiasLaboralesDto diasLaboralesDto) {
        cliente.setLunes(diasLaboralesDto.lunes());
        cliente.setMartes(diasLaboralesDto.martes());
        cliente.setMiercoles(diasLaboralesDto.miercoles());
        cliente.setJueves(diasLaboralesDto.jueves());
        cliente.setViernes(diasLaboralesDto.viernes());
    }

    public void modificarDatosPersonales(Cliente cliente, ClienteDatosPersonalesDto datosPersonalesDto) {
        if (datosPersonalesDto.nombre() != null) {
            cliente.setNombre(datosPersonalesDto.nombre().trim());
        }
        if (datosPersonalesDto.apellido() != null) {
            cliente.setApellido(datosPersonalesDto.apellido().trim());
        }
        if (datosPersonalesDto.documento() != null) {
            cliente.setDocumento(datosPersonalesDto.documento().trim());
        }
    }

    public void desactivarCliente(){
        this.activo=false;
    }

    public void activarCliente(){
        this.activo=true;
    }
}