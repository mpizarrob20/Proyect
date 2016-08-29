package cine.dao;

import java.util.List;
import cine.model.Reserva;
/**
 * Created by maydalis on 25-06-16.
 */
public interface ReservaDao {

    public void insertarReserva(Reserva reserva);

    public void updateReserva(Reserva reserva);

    public void deleteReserva(Reserva reserva);

    public List<Reserva> listarReserva();

    public Reserva getReserva(int id);
}
