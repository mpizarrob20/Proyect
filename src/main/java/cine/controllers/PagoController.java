package cine.controllers;

import cine.model.Pago;
import cine.service.PagoService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by maydalis on 25-06-16.
 */
@Controller
@RequestMapping(value = "/pago")
public class PagoController {
    @Autowired
    private PagoService pagoService;


    @RequestMapping(value = "/listPago", method = RequestMethod.GET)
    @ResponseBody
    public List<Pago> list() {
        return pagoService.listarPago();
    }

    @RequestMapping(value = "/damePago", method = RequestMethod.GET)
    @ResponseBody
    public Pago getPagoById(int id) {
        Pago pago = pagoService.getPago(id);
        return pago;
    }

    @RequestMapping(value = "/view-eliminarpago")
    public ModelAndView viewEliminarPago() {
        List<Pago> pagos = pagoService.listarPago();
        ModelAndView model = new ModelAndView("eliminarPago");
        model.addObject("pagos", pagos);
        return model;
    }

    @RequestMapping(value = "/deletePago", method = RequestMethod.GET)
    @ResponseBody
    public List<Pago> deletePago(@RequestParam(name = "id") Integer id) {
        Pago pago = pagoService.getPago(id);

        pagoService.deletePago(pago);

        return pagoService.listarPago();
    }

    @RequestMapping(value = "/adicionarPago", method = RequestMethod.GET)
    @ResponseBody
    public List<Pago> addPago(@RequestParam(name = "id") int id, @RequestParam(name = "tipoPago") String tipoPago) {

        Pago pago = new Pago();
        pago.setTipoPago(tipoPago);
        pago.setId(id);
        Pago existePago = pagoService.getPago(id);

        if (existePago == null) {
            pagoService.insertarPago(pago);
        } else {
            pagoService.updatePago(pago);
        }

        return pagoService.listarPago();

    }
}
