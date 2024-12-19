package tp.bestioles.demo.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.MethodArgumentNotValidException;

import tp.bestioles.demo.dto.ErrorDto;
import tp.bestioles.demo.dto.InvalidEntityErrorDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EntityToCreateHasAnIdException.class, EntityToUpdateHasNoIdException.class})
    public ResponseEntity<ErrorDto> handleBadRequest(RuntimeException ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InvalidEntityErrorDto> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        List<String> globalErrors = ex.getBindingResult().getGlobalErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        List<String> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        InvalidEntityErrorDto invalidEntityErrorDto = new InvalidEntityErrorDto(
                LocalDateTime.now(),
                "Validation failed for the entity",
                request.getDescription(false),
                globalErrors,
                fieldErrors
        );

        return new ResponseEntity<>(invalidEntityErrorDto, HttpStatus.BAD_REQUEST);
    }
}
