package meu.pacote.repositories;

import meu.pacote.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //opcional pois ja vai herdar esse comentario da class JpaRepository
public interface UserRepository extends JpaRepository<User, Long> { // uma interface extendendo outra

	//JpaRepository é uma interface do Spring Data JPA que contém métodos
	// para operações básicas de persistência de dados como salvar, deletar, e encontrar entidades
}
