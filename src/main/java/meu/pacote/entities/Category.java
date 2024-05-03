package meu.pacote.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
@Table(name = "tb_category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	@Getter//para ter apenas get com o lombok
	@JsonIgnoreProperties("categories") //evitar o loop infinito
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore
	private final Set<Product> products = new HashSet<>(); //final porque nao entra no @AllArgsConstructor

}
