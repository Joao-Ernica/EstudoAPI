package meu.pacote.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import meu.pacote.entities.pk.OrderItemPK;

import java.io.Serializable;

@NoArgsConstructor
@Data
@EqualsAndHashCode
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId //usado no id quando se tem ManyToMany
	@EqualsAndHashCode.Include
	private OrderItemPK id = new OrderItemPK(); // intanciar a classe intermediaria (pk)

	private Integer quantidade;

	private Double preco;

	public OrderItem(Order order, Product product, Integer quantidade, Double preco) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	@JsonIgnore // nao entrar em loop infinito
	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
	}
}