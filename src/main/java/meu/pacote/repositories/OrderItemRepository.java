package meu.pacote.repositories;

import meu.pacote.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //opcional pois ja vai herdar esse comentario da class JpaRepository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> { // o tipo deve ser da classe intermediaria

	//JpaRepository é uma interface do Spring Data JPA que contém métodos
	// para operações básicas de persistência de dados como salvar, deletar, e encontrar entidades
}
