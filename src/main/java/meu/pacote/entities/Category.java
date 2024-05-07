package meu.pacote.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Table(name = "tb_category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;

	private String nome;

	@Setter(AccessLevel.NONE)//para ter apenas get com o lombok
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore  //evitar o loop infinito
	private final Set<Product> products = new HashSet<>(); //final porque nao entra no @AllArgsConstructor

}
