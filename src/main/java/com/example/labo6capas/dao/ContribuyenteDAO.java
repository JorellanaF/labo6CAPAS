package com.example.labo6capas.dao;

import com.example.labo6capas.domain.Contribuyente;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ContribuyenteDAO {
    List<Contribuyente> findAll() throws DataAccessException;
    void insert(Contribuyente contribuyente) throws DataAccessException;
}
