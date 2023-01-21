package net.gerard.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.gerard.web.model.Educacion;

public interface EducacionRepository extends JpaRepository<Educacion, Integer> {
	List<Educacion> findByOrderByFechaFinalDesc();
}
