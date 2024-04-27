package meu.pacote.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity // importa o jakarta.persistence, declara que essa classe é uma entidade
@Table(name = "tb_user") // indica que a entidade deve ser mapeada para "tb_user", pois ja existe uma tabela "user" mno h2
public class User implements Serializable {
	private static final long serialVersionUID = 1L; // serialVersionUID é um identificador único para cada classe serializável

	@Id //chave primaria da tabela do bando de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) //cria um numero sequencial do ID para a tabela do banco de dados
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String senha;


	@OneToMany(mappedBy = "client")  // usado para definir "muitos para um" nesse caso, o client (Uzer) so tera um e recebera muitas "Orders"
	private List<Order> order = new ArrayList<>();

	public User(){

	}

	public User(Long id, String nome, String email, String telefone, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@JsonIgnore //para não entrar em loop, ja que o User chama o Order e o Order chama o User
	public List<Order> getOrder() {
		return order;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		User user = (User) o; // converte o objeto o em User
		return id.equals(user.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

}

