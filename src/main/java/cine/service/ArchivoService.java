package cine.service;

import cine.model.Archivo;

import java.util.List;

/**
 * Created by May on 7/22/2016.
 */
public interface ArchivoService {
    public void insertarArchivo(Archivo archivo);

    public void updateArchivo(Archivo archivo);

    public void deleteArchivo(Archivo archivo);

    public List<Archivo> listarArchivo();

    public Archivo getArchivo(int id);
}
