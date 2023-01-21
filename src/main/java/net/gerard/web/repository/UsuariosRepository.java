package net.gerard.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.gerard.web.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
	Usuario findByUsername(String username);
}