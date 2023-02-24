package estudo.spring.crud.infra;

import estudo.spring.crud.domain.appointment.validationAppointment;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandling {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handlingErroNotFoundUSer() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handlingError400(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DataErrorValidation::new).toList());
    }

    @ExceptionHandler(validationAppointment.class)
    public ResponseEntity error403(validationAppointment ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    private record DataErrorValidation(String field, String message) {
        public DataErrorValidation(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }

    }

}
