package testeSpeedy.teste.rest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testeSpeedy.teste.rest.api.model.UsuarioModel;
import testeSpeedy.teste.rest.api.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	public List<UsuarioModel> listAllUser() {
        return usuarioRepository.findAll();
    }

	public void saveUser(UsuarioModel usuarioModel) {
        usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel getUser(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    public void deleteUser(Integer id) {
    	usuarioRepository.deleteById(id);
    }
}
