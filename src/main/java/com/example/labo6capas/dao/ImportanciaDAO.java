package com.example.labo6capas.dao;

import com.example.labo6capas.domain.Importancia;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ImportanciaDAO {
    List<Importancia> findAll() throws DataAccessException;
    Importancia findOne(Integer codigoImportancia) throws DataAccessException;
}
