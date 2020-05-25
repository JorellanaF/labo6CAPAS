package com.example.labo6capas.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "contribuyente")
public class Contribuyente {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_importancia")
    private Importancia importancia;

    @Transient
    private Integer codigoImportancia;

    @Id
    @GeneratedValue(generator = "contribuyente_c_contribuyente_seq", strategy = GenerationType.AUTO)
    @Column(name = "c_contribuyente")
    private Integer codigoContribuyente;

    @Column(name = "s_nombre")
    @Size(message="Este campo no debe tener mas de 30 caracteres", max=30)
    @NotEmpty(message="Este campo no puede estar vacio")
    private String nombre;

    @Column(name = "s_apellido")
    @Size(message="Este campo no debe tener mas de 30 caracteres", max=30)
    @NotEmpty(message="Este campo no puede estar vacio")
    private String apellido;

    @Column(name = "s_nit")
    @Size(message="Este campo no debe tener mas de 14 caracteres", max=14)
    @NotEmpty(message="Este campo no puede estar vacio")
    private String nit;

    @Column(name = "f_fecha_ingreso")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date fechaIngreso;

    public Contribuyente() {
    }

    public Importancia getImportancia() {
        return importancia;
    }

    public void setImportancia(Importancia importancia) {
        this.importancia = importancia;
    }

    public Integer getCodigoImportancia() {
        return codigoImportancia;
    }

    public void setCodigoImportancia(Integer codigoImportancia) {
        this.codigoImportancia = codigoImportancia;
    }

    public Integer getCodigoContribuyente() {
        return codigoContribuyente;
    }

    public void setCodigoContribuyente(Integer codigoContribuyente) {
        this.codigoContribuyente = codigoContribuyente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
