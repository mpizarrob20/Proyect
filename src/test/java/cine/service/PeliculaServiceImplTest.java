package cine.service;

import cine.model.Pelicula;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by May on 24/08/2016.
 */
public class PeliculaServiceImplTest {
    Pelicula pelicula = new Pelicula();

    @Autowired
    private PeliculaService peliculaService;
    @Test
    public void getPelicula() throws Exception {
        int id = 1;
        String nombre = "thor";

        double precio = 2.5;
        String descripcion = "lalalal";
        String asientosLibres = "5,6,8,";

        pelicula.setId(id);
        pelicula.setNombre(nombre);
        //pelicula.setFecha(fecha);
        pelicula.setPrecio(precio);
        pelicula.setDescripcion(descripcion);
        pelicula.setAsientosStr(asientosLibres);



        assertEquals(pelicula, peliculaService.getPelicula(id) );


    }

}