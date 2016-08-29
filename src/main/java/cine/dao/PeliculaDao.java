package cine.dao;

import cine.model.Pelicula;

import java.util.Date;
import java.util.List;

/**
 * Created by maydalis on 25-06-16.
 */
public interface PeliculaDao {

    public void insertarPelicula(Pelicula pelicula);

    public void updatePelicula(Pelicula pelicula);

    public void deletePelicula(Pelicula pelicula);

    public List<Pelicula> listarPelicula();

    public Pelicula getPelicula(int id);

    public List<Pelicula> buscarPelicula(Date fecha);
}
