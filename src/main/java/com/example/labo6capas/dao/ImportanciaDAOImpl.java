package com.example.labo6capas.dao;

import com.example.labo6capas.domain.Importancia;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO{

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public List<Importancia> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM public.importancia");
        Query query = entityManager.createNativeQuery(sb.toString(), Importancia.class);
        List<Importancia> resultset = query.getResultList();

        return resultset;
    }

    @Override
    public Importancia findOne(Integer codigoImportancia) throws DataAccessException {

        Importancia importancia = entityManager.find(Importancia.class, codigoImportancia);

        return importancia;
    }
}
