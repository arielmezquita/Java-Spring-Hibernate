
package com.jamr.medicalsysbusiness.repository.impl;
import com.jamr.medicalsysbusiness.entity.Cita;
import com.jamr.medicalsysbusiness.repository.CitaRepository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CitaRepositoryImpl implements CitaRepository {
    
    private SessionFactory sessionFactory;
  
    
    public CitaRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    @Override
    public void guardar(Cita entity) {
        Session session = sessionFactory.openSession();
        session.persist(entity);
        session.flush();
    }

    @Override
    public void actualizar(Cita entity) {
      
    }

    @Override
    public Cita buscarporId(Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery(Cita.FIND_CITA_BY_ID);
        query.setParameter("cita", id);
        
        return (Cita) query.uniqueResult();
    }

    @Override
    public List<Cita> buscarTodo() {
       List<Cita> cita = new ArrayList<Cita>();
        Transaction trns = null;
        
        Session session = sessionFactory.openSession();
        
        try{
            trns = session.beginTransaction();
            cita = session.createQuery(Cita.FIND_CITA_ALL).list();
        } catch(RuntimeException e){
            e.printStackTrace();
       
        }finally {
        session.flush();
        session.close();
        }
    
        return cita;
    }

}
