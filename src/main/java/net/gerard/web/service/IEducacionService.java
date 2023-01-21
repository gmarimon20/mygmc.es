package net.gerard.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.gerard.web.model.Educacion;

public interface IEducacionService {
	void guardar(Educacion educacion);

	void eliminar(Integer idEducacion);

	List<Educacion> buscarTodas();

	Educacion buscarPorId(Integer idEducacion);

	Page<Educacion> buscarTodas(Pageable page);

	List<Educacion> findByOrderByFechaFinalDesc();
}