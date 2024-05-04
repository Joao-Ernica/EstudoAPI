package meu.pacote.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor //gera um construtor sem argumentos para uma classe.
@AllArgsConstructor // gera um construtor com todos os campos para uma classe
@Data //combinação de varias anotações que são: @Getter @Setter @ToString @EqualsAndHashCode:
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //excluir todos que nao tenham
@Builder //gera um padrão de construtor para sua classe.
@Entity // importa o jakarta.persistence, declara que essa classe é uma entidade
@Table(name = "tb_user")// indica que a entidade deve ser mapeada para "tb_user", pois ja existe uma tabela "user" mno h2
public class User implements Serializable {
	private static final long serialVersionUID = 1L; // serialVersionUID é um identificador único para cada classe serializável

	@Id //chave primaria da tabela do bando de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)//cria um numero sequencial do ID para a tabela do banco de dados
	@EqualsAndHashCode.Include // indica que somente esse atributo recebera @EqualsAndHashCode
	private Long id;

	private String nome;
	private String email;
	private String telefone;

	@JsonIgnore //evitar que a senha seja exposta no Json
	private String senha;

	@OneToMany(mappedBy = "client")
	// usado para definir "muitos para um" nesse caso, o client (Uzer) so tera um e recebera muitas "Orders"
	@Setter(AccessLevel.NONE)//para ter apenas get com o lombok
	private List<Order> order = new ArrayList<>();

	@JsonIgnore //para não entrar em loop, ja que o User chama o Order e o Order chama o User
	public List<Order> getOrder() {
		return order;
	}

	public static User of() {
		return User.builder().build();
	}

}

