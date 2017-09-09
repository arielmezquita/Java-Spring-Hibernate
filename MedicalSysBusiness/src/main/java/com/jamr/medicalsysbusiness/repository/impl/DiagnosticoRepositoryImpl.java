
package com.jamr.medicalsysbusiness.repository.impl;

import com.jamr.medicalsysbusiness.entity.Diagnostico;
import com.jamr.medicalsysbusiness.repository.DiagnosticoRepository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class DiagnosticoRepositoryImpl implements DiagnosticoRepository {

    private SessionFactory sessionFactory;

    public DiagnosticoRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
  
    @Override
    public void guardar(Diagnostico entity) {
        Session session = sessionFactory.openSession();
        session.persist(entity);
        session.flush();
    }

    @Override
    public void actualizar(Diagnostico entity) {
  
    }

    @Override
    public Diagnostico buscarporId(Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery(Diagnostico.FIND_DIAGNOSTICO_BY_ID);
        query.setParameter("diagnostico", id);
        
        return (Diagnostico) query.uniqueResult();
    }

    @Override
    public List<Diagnostico> buscarTodo() {
       List<Diagnostico> diagnostico = new ArrayList<Diagnostico>();
        Transaction trns = null;
        
        Session session = sessionFactory.openSession();
        
        try{
            trns = session.beginTransaction();
            diagnostico = session.createQuery(Diagnostico.FIND_DIAGNOSTICO_ALL).list();
        } catch(RuntimeException e){
            e.printStackTrace();
       
        }finally {
        session.flush();
        session.close();
        }
    
        return diagnostico;
    }


}
