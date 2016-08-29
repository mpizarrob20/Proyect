package cine.controllers;

import cine.model.Pago;
import cine.model.Pelicula;
import cine.model.Reserva;
import cine.service.PagoService;
import cine.service.PeliculaService;
import cine.service.ReservaService;
import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by maydalis on 25-06-16.
 */
@Controller
@RequestMapping(value = "/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private PagoService pagoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Reserva> list() {
        return reservaService.listarReserva();
    }

    @RequestMapping(value="/dameReserva", method = RequestMethod.GET )
    @ResponseBody
    public Reserva getReservaById(int id) {
        Reserva reserva = reservaService.getReserva(id);
        return reserva;
    }

    @RequestMapping(value = "/viewReservarPelicula")
    public ModelAndView viewReservar(@RequestParam(name = "idPelicula") int id) {
        List<Pago> pago = pagoService.listarPago();
        Pelicula peli = peliculaService.getPelicula(id);
        ModelAndView model = new ModelAndView("reservarPelicula");
        model.addObject("pago", pago);
        model.addObject("peli", peli);
        return model;
    }

    @RequestMapping(value = "/eliminarReserva",  method = RequestMethod.GET)
    @ResponseBody
    public List<Reserva> eliminarReserva(@RequestParam(name = "idPelicula") int id){
        Reserva reserva = reservaService.getReserva(id);
        reservaService.deleteReserva(reserva);
        return reservaService.listarReserva();
    }


    @RequestMapping(value = "/reservaPelicula",  method = RequestMethod.GET)
    @ResponseBody
    public String reservaPelicula(@RequestParam(name = "idPelicula") int id,
                              @RequestParam(name = "nombreComprador") String nombreComprador,
                              @RequestParam(name = "idPago") int idPago,
                              @RequestParam(name = "asientosReservados") String asientosReservados) {


        Pago pago = pagoService.getPago(idPago);
        Reserva reserva = new Reserva();
        Pelicula pelicula = peliculaService.getPelicula(id);

        List<Integer> asientosReservadosFinal = new ArrayList<Integer>();
        String[] asientosR = asientosReservados.split(";");
        for (String asiento : asientosR) {
            asientosReservadosFinal.add(Integer.parseInt(asiento));
        }

        if (peliculaService.validarAsientosDisponibles(pelicula, asientosReservadosFinal) == true) {
            reserva.setNombreComprador(nombreComprador);
            reserva.setFechaPelicula(pelicula.getFecha());
            reserva.setPelicula(pelicula);
            reserva.setPago(pago);
            reserva.setAsientosReservados(asientosReservadosFinal);

            reservaService.insertarReserva(reserva);
            peliculaService.disminuirAsiento(pelicula, asientosReservadosFinal);

            return "La" + reserva + "fue creada satisfactoriamente";
        } else {
            List<Integer> asientosOcupados = peliculaService.devolverAsientosOcupados(pelicula, asientosReservadosFinal);

            return "Lo sentimos los asientos se encuentran Ocupados";
        }

    }
}
