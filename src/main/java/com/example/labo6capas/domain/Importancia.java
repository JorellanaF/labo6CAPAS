package com.example.labo6capas.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="public", name="importancia")
public class Importancia {

    @Id
    @GeneratedValue(generator = "importancia_c_importancia_seq", strategy = GenerationType.AUTO)
    @Column(name = "c_importancia")
    private Integer codigoImportancia;

    @Column(name = "s_importancia")
    private String importancia;

    public Importancia() {
    }

    public Integer getCodigoImportancia() {
        return codigoImportancia;
    }

    public void setCodigoImportancia(Integer codigoImportancia) {
        this.codigoImportancia = codigoImportancia;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

}
