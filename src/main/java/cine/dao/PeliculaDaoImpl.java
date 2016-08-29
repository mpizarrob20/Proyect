package cine.dao;

import cine.model.Pelicula;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

/**
 * Created by maydalis on 25-06-16.
 */
@Transactional
@Repository
public class PeliculaDaoImpl implements PeliculaDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insertarPelicula(Pelicula pelicula) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(pelicula);

        session.getTransaction().commit();

    }

    @Override
    public void updatePelicula(Pelicula pelicula) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.update(pelicula);

        session.getTransaction().commit();

    }

    @Override
    public void deletePelicula(Pelicula pelicula) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.delete(pelicula);

        session.getTransaction().commit();

    }

    @Override
    public List<Pelicula> listarPelicula() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM Pelicula");
        List<Pelicula> listapelicula = query.list();

        session.getTransaction().commit();
        return listapelicula;

    }

    @Override
    public Pelicula getPelicula(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Pelicula pelicula = (Pelicula) session.get(Pelicula.class, id);

        session.getTransaction().commit();
        return pelicula;
    }

    public List<Pelicula> buscarPelicula(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("from Pelicula where fecha = :fech");
        query.setParameter("fech", fecha);
        List<Pelicula> peliculas = query.list();

        session.getTransaction().commit();
        return peliculas;
    }


}
