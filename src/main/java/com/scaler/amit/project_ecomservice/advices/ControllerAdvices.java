package com.scaler.amit.project_ecomservice.advices;

import com.scaler.amit.project_ecomservice.dtos.ExceptionDto;
import com.scaler.amit.project_ecomservice.exceptions.InsufficientStockException;
import com.scaler.amit.project_ecomservice.exceptions.InvalidDataException;
import com.scaler.amit.project_ecomservice.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException ex){
        ExceptionDto exceptionDto = new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        ex.printStackTrace();
        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException ex){
        ExceptionDto exceptionDto = new ExceptionDto(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidDataException.class)
    ResponseEntity<ExceptionDto> handleInvalidException(InvalidDataException ex){
        ExceptionDto exceptionDto = new ExceptionDto(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsufficientStockException.class)
    ResponseEntity<ExceptionDto> handleInsufficientException(InsufficientStockException ex){
        ExceptionDto exceptionDto = new ExceptionDto(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
