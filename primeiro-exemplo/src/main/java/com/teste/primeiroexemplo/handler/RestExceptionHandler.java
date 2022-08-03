package com.teste.primeiroexemplo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.teste.primeiroexemplo.error.ErrorMessage;
import com.teste.primeiroexemplo.exception.ResourceNotFoundException;

//vai ser um controlador dentro da aplicação
@ControllerAdvice
public class RestExceptionHandler {
    
    //se o erro for dessa tipo de class executa esse método
    //será chamada em repository
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex){
        ErrorMessage error = new ErrorMessage("Not Found"
            , HttpStatus.NOT_FOUND.value()
            , ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
