package com.example.labo6capas.services;

import com.example.labo6capas.domain.Contribuyente;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ContribuyenteService {
    List<Contribuyente> findAll() throws DataAccessException;
    void insert(Contribuyente contribuyente) throws DataAccessException;
}
