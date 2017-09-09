
package com.jamr.medicalsysbusiness.repository.impl;
import com.jamr.medicalsysbusiness.entity.Horario;
import com.jamr.medicalsysbusiness.repository.HorarioRepository;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HorarioRepositoryImpl implements HorarioRepository{

    
    private SessionFactory sessionFactory;

    public HorarioRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Horario entity) {
        Session session = sessionFactory.openSession();
        session.persist(entity);
        session.flush();
    }

    @Override
    public void actualizar(Horario entity) {
    
    }

    @Override
    public Horario buscarporId(Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery(Horario.FIND_HORARIO_BY_ID);
        query.setParameter("horario", id);
        
        return (Horario) query.uniqueResult();
        
    }

    @Override
    public List<Horario> buscarTodo() {
        return null;
    }
    
}
