package com.example.labo6capas.services;

import com.example.labo6capas.dao.ContribuyenteDAO;
import com.example.labo6capas.domain.Contribuyente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {

    @Autowired
    ContribuyenteDAO contribuyenteDAO;

    @Autowired
    ImportanciaService importanciaService;

    @Override
    @Transactional
    public void insert(Contribuyente contribuyente) throws DataAccessException {
        Date fecha_ingreso = new Date();
        contribuyente.setFechaIngreso(fecha_ingreso);
        contribuyente.setImportancia(importanciaService.findOne(contribuyente.getCodigoImportancia()));
        contribuyenteDAO.insert(contribuyente);
    }

    @Override
    public List<Contribuyente> findAll() throws DataAccessException {
        return contribuyenteDAO.findAll();
    }
}
