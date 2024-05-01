package meu.pacote.entities;

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
@Table(name = "tb_Producto")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Double valor;
	private String imgUrl;

	@Getter
	@ManyToMany
	private final Set<Category> categories = new HashSet<>(); // Set para garantir que a coleção não comece valendo null
	//set garante que nao tera elementos duplicados //final porque nao entra no @AllArgsConstructor
}
