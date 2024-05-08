package meu.pacote.resources.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import meu.pacote.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice // componente de tratamento de exceções global
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // erro capturado, sera enviado para esse metodo
	public ResponseEntity<StandardError> resourcenotFoundexception(ResourceNotFoundException exeception, HttpServletRequest request ){ //  HttpServletRequest Ele é usado para processar a solicitação do cliente no servidor.
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND; //retorna o erro HTTP"404" indicando que nao foi encontrado
		StandardError standardError = new StandardError(Instant.now(),status.value(),error, exeception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}

}
