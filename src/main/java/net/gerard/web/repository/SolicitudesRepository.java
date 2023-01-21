package net.gerard.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.gerard.web.model.Solicitud;

public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {
}