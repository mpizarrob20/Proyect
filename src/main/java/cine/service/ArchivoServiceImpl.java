package cine.service;

import cine.dao.ArchivoDao;
import cine.model.Archivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by May on 7/22/2016.
 */
@Service
public class ArchivoServiceImpl implements ArchivoService {

    @Autowired
    private ArchivoDao archivoDao;

    @Override
    public void insertarArchivo(Archivo archivo) {
        archivoDao.insertarArchivo(archivo);
    }

    @Override
    public void updateArchivo(Archivo archivo) {
        archivoDao.updateArchivo(archivo);

    }

    @Override
    public void deleteArchivo(Archivo archivo) {
        archivoDao.deleteArchivo(archivo);
    }

    @Override
    public List<Archivo> listarArchivo() {
        return archivoDao.listarArchivo();
    }

    @Override
    public Archivo getArchivo(int id) {
        return archivoDao.getArchivo(id);
    }
}
