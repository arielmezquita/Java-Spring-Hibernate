
package com.jamr.medicalsysbusiness.repository.impl;

import com.jamr.medicalsysbusiness.entity.Expediente;
import com.jamr.medicalsysbusiness.repository.ExpedienteRepository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class ExpedienteRepositoryImpl implements ExpedienteRepository{

    private SessionFactory sessionFactory;

    public ExpedienteRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void guardar(Expediente entity) {
        Session session = sessionFactory.openSession();
        session.persist(entity);
        session.flush();
    }

    @Override
    public void actualizar(Expediente entity) {
    }

    @Override
    public Expediente buscarporId(Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery(Expediente.FIND_EXPEDIENTE_BY_ID);
        query.setParameter("expediente", id);
      
        return (Expediente) query.uniqueResult();    
    }

    @Override
    public List<Expediente> buscarTodo() {
        List<Expediente> expediente = new ArrayList<Expediente>();
        Transaction trns = null;
        
        Session session = sessionFactory.openSession();
        
        try{
            trns = session.beginTransaction();
            expediente = session.createQuery(Expediente.FIND_EXPEDIENTE_ALL).list();
        } catch(RuntimeException e){
            e.printStackTrace();
       
        }finally {
        session.flush();
        session.close();
        }
    
        return expediente;
    }
    
}
