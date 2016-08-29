package cine.controllers;

import cine.model.Pelicula;
import cine.service.PeliculaService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Created by maydalis on 25-06-16.
 */
@RestController
@RequestMapping(value = "/pelicula")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;


    @RequestMapping(value = "/listPelicula", method = RequestMethod.GET)
    @ResponseBody
    public List<Pelicula> viewAllPelicula(){
        return peliculaService.listarPelicula();
    }

    @RequestMapping(value="/damePelicula", method = RequestMethod.GET )
    @ResponseBody
    public Pelicula getPeliculaById(int id) {
        Pelicula pelicula = peliculaService.getPelicula(id);
        return pelicula;
    }

    @RequestMapping(value = "/view-eliminar")
    public ModelAndView viewEliminarPelicula() {
        List<Pelicula> peliculas = peliculaService.listarPelicula();
        ModelAndView model = new ModelAndView("eliminarPelicula");
        model.addObject("peliculas", peliculas);
        return model;
    }

    @RequestMapping(value = "/deletePelicula", method = RequestMethod.GET )
    @ResponseBody
    public List<Pelicula> deletePelicula(@RequestParam(name = "id") Integer id) {
        Pelicula pelicula = peliculaService.getPelicula(id);
        peliculaService.deletePelicula(pelicula);
        return peliculaService.listarPelicula();
    }

    @RequestMapping(value = "/actualizarPelicula", method = RequestMethod.GET )
    @ResponseBody
    public List<Pelicula> actualizarPelicula(@RequestParam(name = "id") Integer id) {
        Pelicula pelicula = peliculaService.getPelicula(id);
        peliculaService.updatePelicula(pelicula);
        return peliculaService.listarPelicula();
    }

    @RequestMapping(value = "/view-adicionar")
    public ModelAndView viewAdicionarPelicula() {
        ModelAndView model = new ModelAndView("adicionarPelicula");
        return model;
    }

    @RequestMapping(value = "/adicionarpelicula", method = RequestMethod.GET)
    @ResponseBody
    public List<Pelicula> addPelicula(@RequestParam(name = "id") int id,
                                    @RequestParam(name = "nombre") String nombre,
                                    @RequestParam(name = "fecha") Date fecha,
                                    @RequestParam(name = "precio") double precio,
                                    @RequestParam(name = "descripcion") String descripcion,
                                    @RequestParam(name = "asientosLibres") String asientosLibres) {

        Pelicula peliEdit = peliculaService.getPelicula(id);
        Pelicula pelicula = new Pelicula();

        List<Integer> asientosLibresFinal = new ArrayList<Integer>();
        String[] asientosLibr = asientosLibres.split(";");
        for (String asiento : asientosLibr) {
            asientosLibresFinal.add(Integer.parseInt(asiento));
        }

        pelicula.setId(id);
        pelicula.setNombre(nombre);
        pelicula.setFecha(fecha);
        pelicula.setPrecio(precio);
        pelicula.setDescripcion(descripcion);
        pelicula.setAsientos(asientosLibresFinal);
        pelicula.setasientosAOcupar(asientosLibresFinal);

        if(peliEdit != null){
            peliculaService.updatePelicula(pelicula);
        }else{
            peliculaService.insertarPelicula(pelicula);
        }

        return peliculaService.listarPelicula();
    }


   @RequestMapping(value = "/peliculasEncontrados",  method = RequestMethod.GET)
   @ResponseBody
    public List<Pelicula> buscarPeliculas(@RequestParam(name = "fecha") Date fecha) throws ParseException {
        List<Pelicula> peliculas = peliculaService.buscarPelicula(fecha);
        return peliculas;
    }

    @RequestMapping(value = "/detalle",  method = RequestMethod.GET)
    @ResponseBody
    public Pelicula detallePeliculaARservar(@RequestParam(name = "id") int id){
        Pelicula pelicula = peliculaService.getPelicula(id);
        return pelicula;

    }



}
