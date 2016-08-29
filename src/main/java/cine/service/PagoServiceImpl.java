package cine.service;

import cine.dao.PagoDao;
import cine.model.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maydalis on 25-06-16.
 */
@Service
public class PagoServiceImpl implements PagoService {
    @Autowired
    private PagoDao pagoDao;

    @Override
    public void insertarPago(Pago pago) {
        pagoDao.insertarPago(pago);

    }

    @Override
    public void updatePago(Pago pago) {
        pagoDao.updatePago(pago);

    }

    @Override
    public void deletePago(Pago pago) {
        pagoDao.deletePago(pago);

    }

    @Override
    public List<Pago> listarPago() {
        return pagoDao.listarPago();

    }

    @Override
    public Pago getPago(int id) {
        return pagoDao.getPago(id);
    }
}
