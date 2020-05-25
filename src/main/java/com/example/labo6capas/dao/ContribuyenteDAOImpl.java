package com.example.labo6capas.dao;

import com.example.labo6capas.domain.Contribuyente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO{

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public List<Contribuyente> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM public.contribuyente");
        Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
        List<Contribuyente> resultset = query.getResultList();

        return resultset;
    }

    @Override
    @Transactional
    public void insert(Contribuyente contribuyente) throws DataAccessException {
        entityManager.persist(contribuyente);
    }
}
