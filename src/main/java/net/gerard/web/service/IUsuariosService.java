package net.gerard.web.service;

import java.util.List;
import net.gerard.web.model.Usuario;

public interface IUsuariosService {
	void guardar(Usuario usuario);
	void eliminar(Integer idUsuario);
	List<Usuario> buscarTodos();
	Usuario buscarPorUsername(String username);
}