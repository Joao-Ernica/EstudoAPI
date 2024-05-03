package meu.pacote.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import meu.pacote.entities.enums.OrderStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id //chave primaria da tabela do bando de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)//cria um numero sequencial do ID para a tabela do banco de dados
	@EqualsAndHashCode.Include
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")// configurar os formatos dos valores Json
	private Instant moment;

	@Enumerated(EnumType.STRING) // das o enum em forma de String para o banco de dados
	private OrderStatus orderStatus;

	@ManyToOne // usado para definir "muitos para um" ou seja, muitas Order para um client (User)
	@JoinColumn(name = "client_id")
	private User client;

	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "id.order") //porque no Orderitem ele so tem o atributo id que o id que tem o order
	private final Set<OrderItem> items = new HashSet<>();

}
