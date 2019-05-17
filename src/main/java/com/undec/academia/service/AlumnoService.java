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

    public Response findAllByNombre(String nombre) throws Exception {
        Response response = new Response();
        try {
            List<Alumno> alumnoList = alumnoRepository.findAllByAlumnoNombreAndFyhIsNotNull(nombre);
            response.setData(alumnoList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response findAllByColegio(String id) throws Exception {
        Response response = new Response();
        try {
            List<Alumno> alumnoList = alumnoRepository.findAllByColegio(colegioRepository.findById(Integer.parseInt(id)).get());
            response.setData(alumnoList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response findDatosFull(String id) throws Exception {
        Response response = new Response();
        try {
            Object[][] objectList = alumnoRepository.findDatosFull(Integer.parseInt(id));
            List<AlumnoDTO> alumnoDTOList = wrapperObjetToAlumnoDTO(objectList);
            response.setData(alumnoDTOList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    protected List<AlumnoDTO> wrapperObjetToAlumnoDTO(Object[][] objectList){
        List<AlumnoDTO> alumnoDTOList = new ArrayList<>();

        for (Object[] item : objectList) {
            AlumnoDTO alumnoDTO = new AlumnoDTO();
            alumnoDTO.setAlumnoId((Integer)item[0]);
            alumnoDTO.setDatosFull((String)item[1]);
            alumnoDTO.setColegioNombre((String)item[2]);
            alumnoDTO.setFliaNombre((String)item[3]);
            alumnoDTOList.add(alumnoDTO);
        }

        return alumnoDTOList;
    }

}