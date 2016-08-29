package cine.model;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.io.Serializable;

/**
 * Created by maydalis on 25-06-16.
 */
@Entity
@Table(name = "Pelicula")
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Type(type = "date")
    @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fecha;

    @Column(name = "precio")
    private double precio;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "asientos")
    private String asientosStr;

    @Column(name = "asientosAOcupar")
    private String asientosAOcupadarStr;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pelicula")
    private List<Reserva> reservas;

    @Transient
    private List<Integer> asientos = new ArrayList<Integer>();

    @Transient
    private List<Integer> asientosAOcupar = new ArrayList<Integer>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsientosStr() {
        return asientosStr;
    }

    public void setAsientosStr(String asientosStr) {
        this.asientosStr = asientosStr;
    }

    public String getAsientosOcupadosStr() {
        return asientosAOcupadarStr;
    }

    public void setAsientosOcupadosStr(String asientosOcupadosStr) {
        this.asientosAOcupadarStr = asientosOcupadosStr;
    }


    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Integer> getAsientos() {
        String[] aux = this.asientosStr.split(";");

        for (String asiento : aux) {
            asientos.add(Integer.parseInt(asiento));

        }
        return asientos;
    }

    public void setAsientos(List<Integer> asientos) {
        String aux = "";
        for (Integer asiento : asientos) {
            if (this.asientos.contains(asientos)) {
                this.asientos = asientos;
            } else {
                aux += asiento + ";";
            }
        }
        aux = aux.substring(0, aux.length() - 1);
        this.asientosStr = aux;
        this.asientos = asientos;
    }

    public List<Integer> getasientosAOcupar() {
        String[] aux = this.asientosAOcupadarStr.split(";");
        for (String asiento : aux) {
            asientosAOcupar.add(Integer.parseInt(asiento));
        }
        return asientosAOcupar;
    }

    public void setasientosAOcupar(List<Integer> asientosAOcupar) {
        String aux = "";
        for (Integer asiento : asientosAOcupar) {
            aux += asiento + ";";
        }
        aux = aux.substring(0, aux.length() - 1);
        this.asientosAOcupadarStr = aux;
        this.asientosAOcupar = asientosAOcupar;
    }

    public int contador(int a, int b){
        int z = 0;
        z = a + b;
        return z;
    }
}
