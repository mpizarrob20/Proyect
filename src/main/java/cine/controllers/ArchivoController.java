package cine.controllers;

import cine.model.Archivo;
import cine.service.ArchivoService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by May on 7/22/2016.
 */
@Controller
@RequestMapping(value = "/archivo")
public class ArchivoController {

    @Autowired
    private ArchivoService archivoService;


    @RequestMapping(value = "/listFotos", method = RequestMethod.GET)
    @ResponseBody
    public List<Archivo> listFotos() {
        return archivoService.listarArchivo();
    }


    @RequestMapping(value = "/guardarArchivo", method = RequestMethod.POST)
    @ResponseBody
    public String guardarArchivo(@RequestParam(name = "subirFormulario") MultipartFile[] subirFormulario,
                                 @RequestParam(name = "nombre") String nombre,
                                 @RequestParam(name = "descripcion") String descripcion,
                                 Model map) throws Exception {


        String archivo = null;
        String directorio = "D:/IdeaProjects/Cine/src/main/webapp/resources/img";

        byte[] fot = null;

        if (subirFormulario != null && subirFormulario.length > 0) {
            for (MultipartFile form : subirFormulario) {
                if (form.getOriginalFilename().contains(".jpg")) {
                    archivo = form.getOriginalFilename();
                    fot = form.getBytes();
                    form.transferTo(new File(directorio + form.getOriginalFilename()));
                }
            }
        }
        Archivo arch = new Archivo();
        arch.setNombre(nombre);
        arch.setRuta(directorio);
        arch.setDescripcion(descripcion);

        archivoService.insertarArchivo(arch);

        return "resultado";
    }


}


