
package com.jamr.medicalsysbusiness.repository.impl;
import com.jamr.medicalsysbusiness.entity.Especialidad;
import com.jamr.medicalsysbusiness.entity.Procedimiento;
import com.jamr.medicalsysbusiness.repository.ProcedimientoRepository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class ProcedimientoRepositoryImpl implements ProcedimientoRepository {

    
    private SessionFactory sessionFactory;

    public ProcedimientoRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void guardar(Procedimiento entity) {
        Session session = sessionFactory.openSession();
        session.persist(entity);
        session.flush();
    }

    @Override
    public void actualizar(Procedimiento entity) {

        
    }

    @Override
    public Procedimiento buscarporId(Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery(Procedimiento.FIND_PROCEDIMIENTO_BY_ID);
        query.setParameter("procedimiento", id);
        
        return (Procedimiento) query.uniqueResult();
    }

    @Override
    public List<Procedimiento> buscarTodo() {
        List<Procedimiento> procedimiento = new ArrayList<Procedimiento>();
        Transaction trns = null;
        
        Session session = sessionFactory.openSession();
        
        try{
            trns = session.beginTransaction();
            procedimiento = session.createQuery(Procedimiento.FIND_PROCEDIMIENTO_ALL).list();
        } catch(RuntimeException e){
            e.printStackTrace();
       
        }finally {
        session.flush();
        session.close();
        }
    
        return procedimiento;
    }
    
}
