package net.gerard.web.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.gerard.web.model.Trabajos;
import net.gerard.web.repository.TrabajoRepository;
import net.gerard.web.service.ITrabajoService;

@Service
public class TrabajoServiceJpa implements ITrabajoService {

	@Autowired
	private TrabajoRepository repoTrabajo;
	
	@Override
	public void guardar(Trabajos trabajo) {
		repoTrabajo.save(trabajo);
	}

	@Override
	public void eliminar(Integer idTrabajo) {
		repoTrabajo.deleteById(idTrabajo);

	}

	@Override
	public List<Trabajos> buscarTodas() {
		return repoTrabajo.findAll();
	}

	@Override
	public Trabajos buscarPorId(Integer idTrabajo) {
		Optional<Trabajos> optional = repoTrabajo.findById(idTrabajo);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Page<Trabajos> buscarTodas(Pageable page) {
		return repoTrabajo.findAll(page);
	}

	@Override
	public List<Trabajos> findByOrderByFechaFinalDesc() {
		
		return repoTrabajo.findByOrderByFechaFinalDesc();
	}

}
