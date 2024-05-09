package meu.pacote.services.exceptions;

public class ResourceNotFoundException extends RuntimeException { //"extends RuntimeException" usado quando se cria sua propria classe de exception
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) { //passar o id do objeto não encontrado
		super("Resource not found. Id" + id); // chamar o construtor da extends RuntimeException
	}
}
