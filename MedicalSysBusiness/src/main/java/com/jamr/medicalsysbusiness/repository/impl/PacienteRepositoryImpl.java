
package com.jamr.medicalsysbusiness.repository.impl;
import com.jamr.medicalsysbusiness.entity.Paciente;
import com.jamr.medicalsysbusiness.repository.PacienteRepository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class PacienteRepositoryImpl implements PacienteRepository {
    
    private SessionFactory sessionFactory;

    public PacienteRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
   
    @Override
    public void guardar(Paciente entity) {
        Session session = sessionFactory.openSession();
        session.persist(entity);
        session.flush();
    }

    @Override
    public void actualizar(Paciente entity) {
    }

    @Override
    public Paciente buscarporId(Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery(Paciente.FIND_PACIENTE_BY_ID);
        query.setParameter("paciente", id);
        
        return (Paciente) query.uniqueResult();
    }

    @Override
    public List<Paciente> buscarTodo() {
        List<Paciente> paciente = new ArrayList<Paciente>();
        Transaction trns = null;
        
        Session session = sessionFactory.openSession();
        
        try{
            trns = session.beginTransaction();
            paciente = session.createQuery(Paciente.FIND_PACIENTE_ALL).list();
        } catch(RuntimeException e){
            e.printStackTrace();
       
        }finally {
        session.flush();
        session.close();
        }
    
        return paciente;
    }


    
}
