package cine.dao;

import cine.model.Pago;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maydalis on 25-06-16.
 */
@Transactional
@Repository
public class PagoDaoImpl implements PagoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertarPago(Pago pago) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(pago);

        session.getTransaction().commit();

    }

    @Override
    public void updatePago(Pago pago) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.update(pago);

        session.getTransaction().commit();

    }

    @Override
    public void deletePago(Pago pago) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.delete(pago);

        session.getTransaction().commit();

    }

    @Override
    public List<Pago> listarPago() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM Pago");
        List<Pago> listapago = query.list();

        session.getTransaction().commit();
        return listapago;

    }

    @Override
    public Pago getPago(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Pago pago = (Pago) session.get(Pago.class, id);

        session.getTransaction().commit();
        return pago;
    }
}
