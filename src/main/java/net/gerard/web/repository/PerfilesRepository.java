package net.gerard.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.gerard.web.model.Perfil;

public interface PerfilesRepository extends JpaRepository<Perfil, Integer> {
}