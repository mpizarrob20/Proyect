package cine.service;

import cine.dao.PeliculaDao;
import cine.model.Pelicula;
import com.sun.org.apache.xerces.internal.impl.dv.util.ByteListImpl;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by maydalis on 25-06-16.
 */
@Service
public class PeliculaServiceImpl implements PeliculaService {
    @Autowired
    private PeliculaDao peliculaDao;

    @Override
    public void insertarPelicula(Pelicula pelicula) {
        peliculaDao.insertarPelicula(pelicula);

    }

    @Override
    public void updatePelicula(Pelicula pelicula) {
        peliculaDao.updatePelicula(pelicula);

    }

    @Override
    public void deletePelicula(Pelicula pelicula) {
        peliculaDao.deletePelicula(pelicula);

    }

    @Override
    public List<Pelicula> listarPelicula() {
        return peliculaDao.listarPelicula();
    }

    @Override
    public Pelicula getPelicula(int id) {
        return peliculaDao.getPelicula(id);
    }

    public List<Pelicula> buscarPelicula(Date fecha) {
        return peliculaDao.buscarPelicula(fecha);
    }

    @Override
    public boolean validarAsientosDisponibles(Pelicula pelicula, List<Integer> asientosAReservar) {
        List<Integer> pelicula1 = pelicula.getasientosAOcupar();
        if (pelicula1.retainAll(asientosAReservar)) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void disminuirAsiento(Pelicula pelicula, List<Integer> asientos) {
        List<Integer> peliculaDisminuir = pelicula.getasientosAOcupar();
        List<Integer> listPelicula = new ArrayList<Integer>();
        for (Integer asientosLibres : peliculaDisminuir) {
            for (Integer asientosAReservar : asientos) {
                if (asientosAReservar == asientosLibres) {
                    listPelicula.add(asientosAReservar);

                }
            }
        }

        peliculaDisminuir.removeAll(listPelicula);
        pelicula.setasientosAOcupar(peliculaDisminuir);
        peliculaDao.updatePelicula(pelicula);
    }

    @Override
    public List<Integer> devolverAsientosOcupados(Pelicula pelicula, List<Integer> asientosAReservar){
        List<Integer> pelicula1 = pelicula.getAsientos();
        List<Integer> listOcupados = new ArrayList<Integer>();
        for(Integer libres: pelicula1){
            for(Integer areservar : asientosAReservar){
                if(libres == areservar){
                    listOcupados.add(areservar);
                }
            }
        }
        return listOcupados;
    }

}
