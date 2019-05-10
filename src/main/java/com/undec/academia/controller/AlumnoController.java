package com.undec.academia.controller;

import com.undec.academia.dto.AlumnoDTO;
import com.undec.academia.dto.Response;
import com.undec.academia.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Response> get(@PathVariable String id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> put(@PathVariable String id, @RequestBody AlumnoDTO input) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Response> post(@RequestBody AlumnoDTO input) throws Exception{
        Response response = alumnoService.save(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable String id) {
        return null;
    }

}