
package com.jamr.medicalsysbusiness.repository.impl;
import com.jamr.medicalsysbusiness.entity.Medico;
import com.jamr.medicalsysbusiness.repository.MedicoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


@Repository
public class MedicoRepositoryImpl implements MedicoRepository {
    private Logger LOG=Logger.getLogger(MedicoRepositoryImpl.class.getName());

    private SessionFactory sessionFactory;

    
    public MedicoRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
    }
    
    
    @Override
    public void guardar(Medico entity) {
        Session session = sessionFactory.openSession();
        session.persist(entity);
        session.flush();
    }

    @Override
    public void actualizar(Medico entity) {
        //Por Desarollar
    }

    @Override
    public Medico buscarporId(Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery(Medico.FIND_MEDICO_BY_ID);
        query.setParameter("medico", id);
        
        return (Medico) query.uniqueResult();
    }

    @Override
    public List<Medico> buscarTodo() {
        List<Medico> medico = new ArrayList<Medico>();
        Transaction trns = null;
        
        Session session = sessionFactory.openSession();
        
        try{
            trns = session.beginTransaction();
            medico = session.createQuery("from medico").list();
        } catch(RuntimeException e){
            e.printStackTrace();
       
        }finally {
        session.flush();
        session.close();
        }
    
        return medico;
    }


    
}
