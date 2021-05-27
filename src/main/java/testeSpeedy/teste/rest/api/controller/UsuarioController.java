package testeSpeedy.teste.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import testeSpeedy.teste.rest.api.model.UsuarioModel;
import testeSpeedy.teste.rest.api.service.UsuarioService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("")
    public List<UsuarioModel> list() {
        return usuarioService.listAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> get(@PathVariable Integer id) {
        try {
        	UsuarioModel usuario = usuarioService.getUser(id);
            return new ResponseEntity<UsuarioModel>(usuario, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UsuarioModel>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody UsuarioModel usuario) {
    	usuarioService.saveUser(usuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UsuarioModel usuario, @PathVariable Integer id) {
        try {
        	UsuarioModel existUser = usuarioService.getUser(id);
        	usuario.setId(id);            
        	usuarioService.saveUser(usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

    	usuarioService.deleteUser(id);
    }

}
