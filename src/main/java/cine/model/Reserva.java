package cine.model;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by maydalis on 25-06-16.
 */
@Entity
@Table(name = "Reserva")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nombreComprador")
    private String nombreComprador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "idPago", nullable = false)
    private Pago pago;

    @Column(name = "asientosReservado")
    private String asientosReservadosStr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "idPelicula", nullable = false)
    private Pelicula pelicula;

    @Type(type="date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "fechaPelicula")
    private Date fechaPelicula;

    @Transient
    private List<Integer> asientosReservados = new ArrayList<Integer>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public List<Integer> getAsientosReservados() {
        String[] aux = this.asientosReservadosStr.split(";");
        for (String asiento : aux) {
            asientosReservados.add(Integer.parseInt(asiento));
        }
        return asientosReservados;
    }

    public void setAsientosReservados(List<Integer> asientosReservados) {
        String aux = "";
        for (Integer asiento : asientosReservados) {
            aux += asiento + ";";
        }
        aux = aux.substring(0, aux.length() - 1);
        this.asientosReservadosStr = aux;
        this.asientosReservados = asientosReservados;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Date getFechaPelicula() {
        return fechaPelicula;
    }

    public void setFechaPelicula(Date fechaPelicula) {
        this.fechaPelicula = fechaPelicula;
    }

    public void setAsientosReservadosStr(String asientosReservadosStr) {
        this.asientosReservadosStr = asientosReservadosStr;
    }

    public String getAsientosReservadosStr() {
        return asientosReservadosStr;
    }
}
