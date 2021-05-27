package testeSpeedy.teste.rest.api.repository;

import testeSpeedy.teste.rest.api.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

}
