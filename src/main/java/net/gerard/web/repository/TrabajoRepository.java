package net.gerard.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import net.gerard.web.model.Trabajos;

@EnableJpaRepositories
public interface TrabajoRepository extends JpaRepository<Trabajos, Integer> {
	List<Trabajos> findByOrderByFechaFinalDesc();
}