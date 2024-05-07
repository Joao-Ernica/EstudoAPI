package meu.pacote.entities.pk;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import meu.pacote.entities.Order;
import meu.pacote.entities.Product;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode //sem os construtores
@Embeddable //que a classe é incorporada por outras classes //como se fosse parte da mesma classe
public class OrderItemPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order; //incorpora

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product; //incorpora

}
