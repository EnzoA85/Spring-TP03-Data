package tp.bestioles.demo.exception;

import jakarta.persistence.EntityNotFoundException;
import tp.bestioles.demo.dto.ErrorDto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(
            LocalDateTime.now(), 
            ex.getMessage(),
            request.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

    @ExceptionHandler(EntityToCreateHasAnIdException.class)
    public ResponseEntity<ErrorDto> handleEntityToCreateHasAnId(EntityToCreateHasAnIdException ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(
            LocalDateTime.now(), 
            ex.getMessage(),
            request.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(EntityToUpdateHasNoIdException.class)
    public ResponseEntity<ErrorDto> handleEntityToUpdateHasNoId(EntityToUpdateHasNoIdException ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(
            LocalDateTime.now(), 
            ex.getMessage(),
            request.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleGeneralException(Exception ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(
            LocalDateTime.now(), 
            ex.getMessage(),
            request.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }
}
