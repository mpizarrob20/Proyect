package cine.service;

import cine.dao.ReservaDao;
import cine.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maydalis on 25-06-16.
 */
@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaDao reservaDao;

    @Override
    public void insertarReserva(Reserva reserva) {
        reservaDao.insertarReserva(reserva);

    }

    @Override
    public void updateReserva(Reserva reserva) {
        reservaDao.updateReserva(reserva);

    }

    @Override
    public void deleteReserva(Reserva reserva) {
        reservaDao.deleteReserva(reserva);

    }

    @Override
    public List<Reserva> listarReserva() {
        return reservaDao.listarReserva();
    }

    @Override
    public Reserva getReserva(int id) {
        return reservaDao.getReserva(id);
    }
}
