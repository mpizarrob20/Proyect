package cine.service;

import cine.model.Pelicula;

import java.util.Date;
import java.util.List;

/**
 * Created by maydalis on 25-06-16.
 */
public interface PeliculaService {

    public void insertarPelicula(Pelicula pelicula);
    public void updatePelicula(Pelicula pelicula);
    public void deletePelicula(Pelicula pelicula);
    public List<Pelicula> listarPelicula();
    public Pelicula getPelicula(int id);
    public List<Pelicula> buscarPelicula(Date fecha);
    public boolean validarAsientosDisponibles(Pelicula pelicula, List<Integer> asientosAReservar);
    public void disminuirAsiento(Pelicula pelicula, List<Integer> asientos);
    public List<Integer> devolverAsientosOcupados(Pelicula pelicula, List<Integer> asientosAReservar);
}
