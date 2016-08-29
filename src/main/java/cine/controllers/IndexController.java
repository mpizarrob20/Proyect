package cine.controllers;

import cine.model.Pago;
import cine.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by maydalis on 25-06-16.
 */
@Controller

public class IndexController {
    @Autowired
    private PagoService pagoService;


    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/listadoPelicula")
    public String listadoPelicula() {
        return "listadoPelicula";
    }

    @RequestMapping(value = "/listaPeliculaEncontrada")
    public String listaPeliculaEncontrada() {
        return "listaPeliculaEncontrada";
    }

    @RequestMapping(value = "/listarPago")
    public String listarPago() {
        return "listarPago";
    }

    @RequestMapping(value = "/listadoReservas")
    public String listadoReservas() {
        return "listadoReservas";
    }

    @RequestMapping(value = "/administracion")
    public String administracion() {
        return "administracion";
    }

    @RequestMapping(value = "/subirFichero")
    public String subirFichero() {
        return "subirFichero";
    }





}
