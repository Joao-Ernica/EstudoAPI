package meu.pacote.resources;

import meu.pacote.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Significa que essa classe vai ser responsável por pegar as informações que vêm de uma solicitação da web
@RequestMapping(value = "/users")
// nome da solicitaçao do web, quando for chamada essa solicitaçao vai vir para essa classe
public class UserResource {

	@GetMapping // sempre que alguém acessa o URL “/usuarios” com uma solicitação GET, o método getUsers()
	public ResponseEntity<User> findALL() { //ResponseEntity<User> é um tipo especial do Spring que permite retornar dados junto com informações de status HTTP
		// <User> uma classe que representa um usuário em seu sistema
		User u = new User(1L, "Joao", "Jp.erniaca@outlook.com", "99999999", "senha");
		return ResponseEntity.ok().body(u); //  ResponseEntity.ok() retorna com sucesso a resposta, .body(u) retorna o corpo da resposta o usuario u
	}
}
