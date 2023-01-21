package net.gerard.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.gerard.web.model.Trabajos;

public interface ITrabajoService {
	
	// EJERCICIO: Método que guarda un objeto tipo Solicitud en la BD (solo disponible para un usuario con perfil USUARIO).
	void guardar(Trabajos trabajo);
	
	// EJERCICIO: Método que elimina una Solicitud de la BD (solo disponible para usuarios con perfil ADMINISTRADOR/SUPERVISOR).
	void eliminar(Integer idTrabajo);
	
	// EJERCICIO: Método que recupera todas las Solicitudes guardadas en la BD (solo disponible para usuarios con perfil ADMINISTRADOR/SUPERVISOR).
	List<Trabajos> buscarTodas();
	
	// EJERCICIO: Método que busca una Solicitud en la BD (solo disponible para usuarios con perfil ADMINISTRADOR/SUPERVISOR).
	Trabajos buscarPorId(Integer idTrabajo);
	
	// EJERCICIO: Método que recupera todas las Solicitudes (con paginación) guardadas en la BD (solo disponible para usuarios con perfil ADMINISTRADOR/SUPERVISOR).
	Page<Trabajos> buscarTodas(Pageable page);
	
	//List<Solicitud> buscarPorIdUsuario(Usuario usuario);
	
	List<Trabajos> findByOrderByFechaFinalDesc();
}
