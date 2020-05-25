package com.example.labo6capas.services;

import com.example.labo6capas.dao.ImportanciaDAO;
import com.example.labo6capas.domain.Importancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class ImportanciaServiceImpl implements ImportanciaService {

    @Autowired
    ImportanciaDAO importanciaDAO;

    @Override
    public List<Importancia> findAll() throws DataAccessException {
        return importanciaDAO.findAll();
    }

    @Override
    public Importancia findOne(Integer codigoImportancia) throws DataAccessException {
        return importanciaDAO.findOne(codigoImportancia);
    }
}
