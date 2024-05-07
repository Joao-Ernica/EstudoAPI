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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Table(name = "tb_producto")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;

	private String nome;
	private String descricao;
	private Double valor;
	private String imgUrl;

	@ManyToMany //Relação muitos para muitos, ou seja, prudutos podem ter muitas categorias e vice versa
	@Setter(AccessLevel.NONE)
	@JoinTable(
			name = "tb_product_category",
			joinColumns = @JoinColumn(name = "product_id"), // nome da coluna que faz parte da "tb_product_category"
			inverseJoinColumns = @JoinColumn(name = "category_id") //nome da coluna da outra classe do ManytoMany
	)
	private final Set<Category> categories = new HashSet<>(); // Set para garantir que a coleção não comece valendo null

	@OneToMany(mappedBy = "id.product") //ja que a classe .PK tem o atributo id que ele sim tem o atributo product
	private final Set<OrderItem> items = new HashSet<>();//set garante que nao tera elementos duplicados //final porque nao entra no @AllArgsConstructor

	public Set<Order> getOrderns(){ //encontra os valores Order dentro do Orderitem e retorna quando é chamado
		Set<Order> set = new HashSet<>();
		for(OrderItem x : items){
			set.add(x.getOrder());
		}
		return set;
	}
}

