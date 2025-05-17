package br.com.belval.api.geraacao.geraacao.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.belval.api.geraacao.geraacao.model.Usuario;
import br.com.belval.api.geraacao.geraacao.repository.UsuarioRepository;

@RestController
@RequestMapping
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	public ResponseEntity<Iterable<Usuario>> obterProdutos() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(usuarioRepository.findAll());
	}
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Object> buscarPorId(
	       @PathVariable(value = "id")Integer id) {
	    	   
	   Optional<Usuario> usuario = usuarioRepository.findById(id);
	   
	   if (usuario.isPresent()) {
		   return ResponseEntity
				   .status(HttpStatus.OK)
				   .body(usuario.get());
	   }
   		   
	   return ResponseEntity
			   .status(HttpStatus.NOT_FOUND)
			   .body("usuarioRepository não encontrado!");
	   
	
	}
	
	
	//curl -X POST http://localhost:8080/usuarios -H "Content-Type: application/json; Charset=utf-8" -d @novo-usuario.json
	//curl -X PUT http://localhost:8080/usuarios/1 -H "Content-Type: application/json; Charset=utf-8" -d @atualizar-usuario.json

	
	@PostMapping("/usuarios")
	public ResponseEntity<Object> criarUsuario(@RequestBody Usuario usuario) {
		
	try {
		
		usuarioRepository.save(usuario);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(usuario);
	}catch(Exception e) {
		
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Erro ao criar usuario"+ e.getMessage());
	}
}
	@PutMapping("/usuarios/{id}")
    public ResponseEntity<Object> atualizarProduto( 
            @PathVariable Integer id,
            @RequestBody Usuario user) {
    	
    	Optional<Usuario> usuario = usuarioRepository.findById(id);
 	   
 	   if (usuario.isEmpty()) {
 		   
 		  return ResponseEntity
 	 			   .status(HttpStatus.NOT_FOUND)
 	 			   .body("Usuario não encontrado!");
 	   } 
 		  
 		 user.setId(id);
 		 usuarioRepository.save(user);
 		  
 		   return ResponseEntity
 				   .status(HttpStatus.OK)
 				   .body(usuario.get());
 		  
 		   
 	   }
	
	@DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }

        usuarioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}	

