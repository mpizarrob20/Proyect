package cine.dao;

import java.util.List;
import cine.model.Pago;

/**
 * Created by maydalis on 25-06-16.
 */
public interface PagoDao {

    public void insertarPago(Pago pago);

    public void updatePago(Pago pago);

    public void deletePago(Pago pago);

    public List<Pago> listarPago();

    public Pago getPago(int id);
}
