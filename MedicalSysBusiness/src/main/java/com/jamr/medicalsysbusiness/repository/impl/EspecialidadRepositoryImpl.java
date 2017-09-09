
package com.jamr.medicalsysbusiness.repository.impl;

import com.jamr.medicalsysbusiness.entity.Especialidad;
import com.jamr.medicalsysbusiness.repository.EspecialidadRepository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class EspecialidadRepositoryImpl implements EspecialidadRepository {

    
    private SessionFactory sessionFactory;

    public EspecialidadRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    

    @Override
    public void guardar(Especialidad entity) {
        Session session = sessionFactory.openSession();
        session.persist(entity);
        session.flush();
    }

    @Override
    public void actualizar(Especialidad entity) {
    
    }

    @Override
    public Especialidad buscarporId(Long id) {  
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery(Especialidad.FIND_ESPECIALIDAD_BY_ID);
        query.setParameter("especialidadid", id);
      
        return (Especialidad) query.uniqueResult();    
    }

    @Override
    public List<Especialidad> buscarTodo() {
       List<Especialidad> especialidad = new ArrayList<Especialidad>();
        Transaction trns = null;
        
        Session session = sessionFactory.openSession();
        
        try{
            trns = session.beginTransaction();
            especialidad = session.createQuery(Especialidad.FIND_ESPECIALIDAD_ALL).list();
        } catch(RuntimeException e){
            e.printStackTrace();
       
        }finally {
        session.flush();
        session.close();
        }
    
        return especialidad;
    }
}
