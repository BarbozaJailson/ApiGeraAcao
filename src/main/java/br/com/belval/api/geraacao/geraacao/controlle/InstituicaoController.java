package br.com.belval.api.geraacao.geraacao.controlle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.belval.api.geraacao.geraacao.model.Instituicao;
import br.com.belval.api.geraacao.geraacao.repository.InstituicaoRepository;

@RestController
public class InstituicaoController {
	
	@Autowired
	private InstituicaoRepository repository;
	
	/**
	 * Retorna todas as instituicao
	 * @return
	 */
	@GetMapping("/instituicao")
	public ResponseEntity<Iterable<Instituicao>> obterInstituicao(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());
	}
	
	@GetMapping("/instituicao/{id}")
	public ResponseEntity<Object> buscarPorId(
			@PathVariable(value = "id") Integer id){
		
		Optional<Instituicao> instituicao = repository.findById(id);
		
		if(instituicao.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(instituicao.get());
		}
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Instituicao não ancontrada!");
		
	}
	
	// ls -lart
	//curl -X POST http://localhost:8080/instituicao -H "Content-Type: application/json; Charset=utf-8" -d @nova-intituicao.json

			@PostMapping("/instituicao")
			public ResponseEntity<Instituicao> criarProduto(
					@RequestBody Instituicao instituicao){
				
				//produto.setId(proxId++);
				
				System.out.println("Instituicao criada..." + instituicao.toString());
				repository.save(instituicao);
				
				return ResponseEntity
						.status(HttpStatus.CREATED)
						.body(instituicao);
			}
			
			//Observação: para métodos que não sejam o GET e o POST é necessário colocar o -X(menos xis maiúsculo)
			//curl -X PUT http://localhost:8080/instituicao/1 -H "Content-Type: application/json; Charset=utf-8" -d @instituicao-mortadela2.json
			
			@PutMapping("/instituicao/{id}")
			public ResponseEntity<Object>atualizarInstituicao(
					@PathVariable Integer id,
					Instituicao prod){
				
				Optional<Instituicao> instituicao = repository.findById(id);
				
				if(instituicao.isEmpty()) {
					return ResponseEntity
							.status(HttpStatus.NOT_FOUND)
							.body("Instituiçãoo não encontrada!");
				}
				prod.setId(id);
				repository.save(prod);
				
				return ResponseEntity
						.status(HttpStatus.OK)
						.body("Instituição atualizada com sucesso");
			}
			
}
