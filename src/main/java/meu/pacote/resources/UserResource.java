package meu.pacote.resources;

import meu.pacote.entities.User;
import meu.pacote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
			return userService.findById(id);
		}

	@PostMapping // post serve para inserir dados //diferente do get que serve para pegar os dados
	public ResponseEntity<User> insert(@RequestBody User obj) { //@RequestBody converter o corpo de uma requisição HTTP em um objeto Java.
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder //constroi uma URI
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);// criado e um código de status HTTP 201, usado para indicar o sucesso na criação
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable long id) { //Void porque nao vai retornar nada
		userService.delete(id);
		return ResponseEntity.noContent().build(); //codigo HTTP que nao tem resposta é o 204

	}

	@PutMapping("{id}") //usado para atualizar um recurso existente na web
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = userService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
