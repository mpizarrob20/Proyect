package cine.dao;

import cine.model.Archivo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by May on 7/22/2016.
 */
@Transactional
@Repository
public class ArchivoDaoImpl implements ArchivoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insertarArchivo(Archivo archivo) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(archivo);

        session.getTransaction().commit();

    }

    @Override
    public void updateArchivo(Archivo archivo) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.update(archivo);

        session.getTransaction().commit();


    }

    @Override
    public void deleteArchivo(Archivo archivo) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.delete(archivo);

        session.getTransaction().commit();


    }

    @Override
    public List<Archivo> listarArchivo() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM archivosubir");
        List<Archivo> listaarchivos = query.list();

        session.getTransaction().commit();
        return listaarchivos;

    }

    @Override
    public Archivo getArchivo(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Archivo archivo = (Archivo) session.get(Archivo.class, id);

        session.getTransaction().commit();
        return archivo;
    }


}
