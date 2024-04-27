package meu.pacote.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_Order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id //chave primaria da tabela do bando de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//cria um numero sequencial do ID para a tabela do banco de dados
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT") // configurar os formatos dos valores Json
	private Instant moment;

	@ManyToOne // usado para definir "muitos para um" ou seja, muitas Order para um client (User)
	@JoinColumn(name = "client_id")
	private User client;

	public Order() {

	}

	public Order(Long id, Instant moment, User client) {
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		Order order = (Order) o;
		return Objects.equals(id, order.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
