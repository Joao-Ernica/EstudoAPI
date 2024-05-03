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
@Table(name = "tb_producto")
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
	@ManyToMany //Relação muitos para muitos, ou seja, prudutos podem ter muitas categorias e vice versa
	@Setter(AccessLevel.NONE)
	@JoinTable(
			name = "tb_product_category",
			joinColumns = @JoinColumn(name = "product_id"), // nome da coluna que faz parte da "tb_product_category"
			inverseJoinColumns = @JoinColumn(name = "category_id") //nome da coluna da outra classe do ManytoMany
	)
	private final Set<Category> categories = new HashSet<>(); // Set para garantir que a coleção não comece valendo null

	//set garante que nao tera elementos duplicados //final porque nao entra no @AllArgsConstructor
}
