package com.undec.academia.service;

import com.undec.academia.dto.AlumnoDTO;
import com.undec.academia.dto.Response;
import com.undec.academia.exception.EntityNotFoundException;
import com.undec.academia.model.Alumno;
import com.undec.academia.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public Response findOneById(String id) throws EntityNotFoundException, Exception {
        Response response = new Response();
        try {
            Alumno alumno = alumnoRepository.findById(Integer.parseInt(id)).get();
            response.setData(alumno);

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
            throw new EntityNotFoundException(Alumno.class, "id", id);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response update(AlumnoDTO input) throws Exception {
        Response response = new Response();
        try {
            Alumno alumno = alumnoRepository.findById(input.getAlumnoId()).get();
            alumno.setAlumnoNombre(input.getAlumnoNombre());
            alumno.setSexoBySexoId(sexoRepository.findById(input.getSexoId()).get());
            alumno.setLocalidadByLocalidadId(localidadRepository.findById(input.getLocalidadId()).get());
            alumno.setColegioByColegioId(colegioRepository.findById(input.getColegioId()).get());
            alumno.setFliaByFliaId(fliaRepository.findById(input.getFliaId()).get());
            alumno.setUsuario("app");
            alumno.setFyh(new Timestamp(System.currentTimeMillis()));
            alumno.setPc("1");
            alumnoRepository.save(alumno);

            response.setData(input);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
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

    public Response delete(String id) throws EntityNotFoundException, Exception {
        Response response = new Response();
        try {
            Alumno alumno = alumnoRepository.findById(Integer.parseInt(id)).get();
            alumnoRepository.delete(alumno);

            response.setMessage("Eliminado correctamente.");

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
            throw new EntityNotFoundException(Alumno.class, "id", id);
        } catch (Exception e) {
            LOGGER.error("Error general.");
            throw e;
        }
        return response;
    }

    public Response findAllByColegioId(String colId) {
        Response response = new Response();
        List<Alumno> alumnoList = alumnoRepository.findAllByColegioIdAndFyhNotNull(colegioRepository.findById(Integer.parseInt(colId)).get());
        response.setData(alumnoList);
        return response;
    }

    public Response findAllDatosCompletos(String colId) {
        Response response = new Response();
        Object[][] objectList = alumnoRepository.findAllDatosCompletos(Integer.parseInt(colId));
        List<AlumnoDTO> alumnoDTOList = new ArrayList<>();

        for (Object[] item : objectList) {
            Integer alumnoId = (Integer) item[0];
            String infoAlumno = (String) item[1];
            String colegioNombre = (String) item[2];
            String fliaNombre = (String) item[3];
            AlumnoDTO alumnoDTO = new AlumnoDTO();
            alumnoDTO.setAlumnoId(alumnoId);
            alumnoDTO.setInfoAlumno(infoAlumno);
            alumnoDTO.setColegioNombre(colegioNombre);
            alumnoDTO.setFliaNombre(fliaNombre);
            alumnoDTOList.add(alumnoDTO);
        }
        response.setData(alumnoDTOList);
        return response;
    }

}