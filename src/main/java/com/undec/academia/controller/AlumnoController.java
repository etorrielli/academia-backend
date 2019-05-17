package com.undec.academia.controller;

import com.undec.academia.dto.AlumnoDTO;
import com.undec.academia.dto.Response;
import com.undec.academia.exception.EntityNotFoundException;
import com.undec.academia.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author etorrielli
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping()
    public ResponseEntity<Response> list() throws Exception {
        Response response = alumnoService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable String id) throws EntityNotFoundException, Exception {
        Response response = alumnoService.findOneById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Response> put(@RequestBody AlumnoDTO input) throws Exception {
        Response response = alumnoService.update(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> post(@RequestBody AlumnoDTO input) throws Exception {
        Response response = alumnoService.save(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable String id) throws EntityNotFoundException, Exception {
        Response response = alumnoService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Response> listByNombre(@PathVariable String nombre) throws Exception{
        Response response = alumnoService.findAllByNombre(nombre);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/colegio/{id}")
    public ResponseEntity<Response> listByColegio(@PathVariable String id) throws Exception{
        Response response = alumnoService.findAllByColegio(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/full/colegio/{id}")
    public ResponseEntity<Response> listFullByColegio(@PathVariable String id) throws Exception{
        Response response = alumnoService.findDatosFull(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}