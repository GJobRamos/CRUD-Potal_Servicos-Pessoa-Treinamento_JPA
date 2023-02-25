package br.com.ntt.jpa.config.controllerHandler;

import br.com.ntt.jpa.exception.PessoaNaoEncontradaException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(PessoaNaoEncontradaException.class)
    public ResponseEntity<StandardError> pessoaNaoEncontradaHandler(PessoaNaoEncontradaException ex, HttpServletRequest request) {
        StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> pessoaSemNome(MethodArgumentNotValidException ex, HttpServletRequest request) {
        StandardError standardError = new StandardError(HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(standardError);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<StandardError> conteudoUnico(SQLIntegrityConstraintViolationException ex, HttpServletRequest request) {
        StandardError standardError = new StandardError(HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage(), LocalDateTime.now());
        return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(standardError);
    }
}
