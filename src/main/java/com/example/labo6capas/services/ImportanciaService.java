package com.example.labo6capas.services;

import com.example.labo6capas.domain.Importancia;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ImportanciaService {
    List<Importancia> findAll() throws DataAccessException;
    Importancia findOne(Integer codigoImportancia) throws DataAccessException;
}
