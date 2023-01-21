package net.gerard.web.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.gerard.web.model.Educacion;
import net.gerard.web.repository.EducacionRepository;
import net.gerard.web.service.IEducacionService;

@Service
@Primary
public class EducacionServiceJpa implements IEducacionService {

	@Autowired
	private EducacionRepository repoEducacion;

	@Override
	public void guardar(Educacion educacion) {
		repoEducacion.save(educacion);
	}

	@Override
	public void eliminar(Integer idEducacion) {
		repoEducacion.deleteById(idEducacion);

	}

	@Override
	public List<Educacion> buscarTodas() {
		return repoEducacion.findAll();
	}

	@Override
	public Educacion buscarPorId(Integer idEducacion) {
		Optional<Educacion> optional = repoEducacion.findById(idEducacion);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Page<Educacion> buscarTodas(Pageable page) {
		return repoEducacion.findAll(page);
	}

	@Override
	public List<Educacion> findByOrderByFechaFinalDesc() {
		return repoEducacion.findByOrderByFechaFinalDesc();
	}
}