package com.undec.academia.service;

import com.undec.academia.dto.AlumnoDTO;
import com.undec.academia.dto.Response;
import com.undec.academia.model.Alumno;
import com.undec.academia.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author etorrielli
 */
@Service
public class AlumnoService {

    static final Logger LOGGER = LoggerFactory.getLogger(AlumnoService.class);

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private LocalidadRepository localidadRepository;
    @Autowired
    private SexoRepository sexoRepository;
    @Autowired
    private FliaRepository fliaRepository;
    @Autowired
    private ColegioRepository colegioRepository;

    public Response findAll() throws Exception {
        Response response = new Response();
        try {
            List<Alumno> alumnoList = alumnoRepository.findAll();
            response.setData(alumnoList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response findOneById(String id) {
        return null;
    }

    public Response update(AlumnoDTO input) {
        return null;
    }

    public Response save(AlumnoDTO input) throws Exception {
        Response response = new Response();
        try {
            Alumno alumno = new Alumno();
            alumno.setAlumnoNombre(input.getAlumnoNombre());
            alumno.setSexoBySexoId(sexoRepository.findById(input.getSexoId()).get());
            alumno.setLocalidadByLocalidadId(localidadRepository.findById(input.getLocalidadId()).get());
            alumno.setColegioByColegioId(colegioRepository.findById(input.getColegioId()).get());
            alumno.setFliaByFliaId(fliaRepository.findById(input.getFliaId()).get());
            alumno.setUsuario("app");
            alumno.setFyh(new Timestamp(System.currentTimeMillis()));
            alumno.setPc("1");
            alumno = alumnoRepository.save(alumno);

            input.setAlumnoId(alumno.getAlumnoId());
            response.setData(input);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response delete(String id) {
        return null;
    }

}