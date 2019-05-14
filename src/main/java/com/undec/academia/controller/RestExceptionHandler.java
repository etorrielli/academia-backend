package com.undec.academia;

import com.undec.academia.dto.Response;
import com.undec.academia.exception.CustomException;
import com.undec.academia.exception.EntityNotFoundException;
import com.undec.academia.exception.ServiceCallException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.io.FileNotFoundException;
import java.io.IOException;

@ControllerAdvice(basePackages = "com.undec.academia.controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    //Excepciones de BD/////////////////////////////////////////////////////////////////////////////
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        Response response = new Response();
        response.setStatus(100);
        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Response response = new Response();
        response.setStatus(101);
        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        Response response = new Response();
        response.setStatus(102);
        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Excepciones runtime JAVA///////////////////////////////////////////////////////////////////////
    @ExceptionHandler(FileNotFoundException.class)
    protected ResponseEntity<Object> handleFileNotFound(FileNotFoundException ex) {
        Response response = new Response();
        response.setStatus(203);
        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(IOException.class)
    protected ResponseEntity<Object> handleIO(IOException ex) {
        Response response = new Response();
        response.setStatus(204);
        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<Object> handleCustom(CustomException ex) {
        Response response = new Response();
        response.setStatus(206);
        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(ServiceCallException.class)
    protected ResponseEntity<Object> handleServiceCallException(ServiceCallException ex) {
        Response response = new Response();
        response.setStatus(207);
        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception ex) {
        Response response = new Response();
        response.setStatus(999);
        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
