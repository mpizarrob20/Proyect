package cine.service;

import cine.model.Reserva;

import java.util.List;

/**
 * Created by maydalis on 25-06-16.
 */
public interface ReservaService {

    public void insertarReserva(Reserva reserva);
    public void updateReserva(Reserva reserva);
    public void deleteReserva(Reserva reserva);
    public List<Reserva> listarReserva();
    public Reserva getReserva(int id);
}
