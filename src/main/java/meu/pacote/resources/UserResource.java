package meu.pacote.resources;

import meu.pacote.entities.User;
import meu.pacote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
// Significa que essa classe vai ser responsável por pegar as informações que vêm de uma solicitação da web
@RequestMapping("Users")
// nome da solicitaçao do web, quando for chamada essa solicitaçao vai vir para essa classe
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping // sempre que alguém acessa o URL “/usuarios” ira usar o "getUsuarios"
	public ResponseEntity<List<User>> findALL() { //ResponseEntity<User> é um tipo especial do Spring que permite retornar dados junto com informações de status HTTP
		// <User> uma classe que representa um usuário em seu sistema
		List<User> list = userService.findALL();
		return ResponseEntity.ok().body(list); // ResponseEntity.ok() retorna com sucesso a resposta, .body(u) retorna o corpo da resposta o usuario u
	}

	@GetMapping("{id}")// quando colocar /users/1 colocara a pessoa com id 1
	public User findById(@PathVariable Long id) {
		try {
			return userService.findById(id);
		}catch (NoSuchElementException e){
			return
					null;

		}
	}

}
