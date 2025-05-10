package br.com.belval.api.geraacao.geraacao.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.belval.api.geraacao.geraacao.model.ItemDoacao;
import br.com.belval.api.geraacao.geraacao.repository.DoacaoRepository;

																			
@RestController
public class ItemDoacaoController {
	
	@Autowired
	private DoacaoRepository repository;
	
	@GetMapping ("/itemdoacao")
	public ResponseEntity<Iterable<ItemDoacao>> obterProdutos(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());
	}
	
	@GetMapping("/itemdoacao/{id")
	public ResponseEntity<Object> buscarPorId(
			@PathVariable(value = "id") Integer id) {
		
		Optional <ItemDoacao> doacao = repository.findById(id);
		
		if(doacao.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(doacao.get());
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Item Doação não encontrado");
	}
	
	//curl POST http://localhost:8080/produtos -H "Content-Type: application/json; Charset=utf-8" -d @produto-pao.json

	//@PostMapping("/itemdoacao")
	//public ResponseEntity <ItemDoacao>
}
																			