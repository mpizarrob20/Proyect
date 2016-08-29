package cine.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import cine.model.Reserva;

import java.util.List;

/**
 * Created by maydalis on 25-06-16.
 */
@Transactional
@Repository
public class ReservaDaoImpl implements ReservaDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertarReserva(Reserva reserva) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(reserva);

        session.getTransaction().commit();

    }

    @Override
    public void updateReserva(Reserva reserva) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.update(reserva);

        session.getTransaction().commit();

    }

    @Override
    public void deleteReserva(Reserva reserva) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.delete(reserva);

        session.getTransaction().commit();

    }

    @Override
    public List<Reserva> listarReserva() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM Reserva");
        List<Reserva> listareserva = query.list();

        session.getTransaction().commit();
        return listareserva;

    }

    @Override
    public Reserva getReserva(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Reserva reserva = (Reserva) session.get(Reserva.class, id);

        session.getTransaction().commit();
        return reserva;
    }
}


