package meu.pacote.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
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

}
