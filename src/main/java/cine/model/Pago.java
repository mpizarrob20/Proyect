package cine.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by maydalis on 25-06-16.
 */
@Entity
@Table(name = "Pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "tipoPago")
    private String tipoPago;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pago")
    private List<Reserva> reservas;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;this.tipoPago = tipoPago;
    }
}
