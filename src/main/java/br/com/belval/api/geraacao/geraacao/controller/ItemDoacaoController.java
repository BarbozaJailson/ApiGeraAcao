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

import br.com.belval.api.geraacao.geraacao.model.ItemDoacao;
import br.com.belval.api.geraacao.geraacao.repository.ItemDoacaoRepository;

																			
@RestController
@RequestMapping
public class ItemDoacaoController {
	
	@Autowired
	private ItemDoacaoRepository repository;
	
	@GetMapping ("/itemdoacao")
	public ResponseEntity<Iterable<ItemDoacao>> obteritemdoacao(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());
	}
	
	@GetMapping("/itemdoacao/{id}")
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
	
	//curl -X POST http://localhost:8080/itemdoacao -H "Content-Type: application/json; Charset=utf-8" -d @novo-Itemdoacao.json

	
	@PostMapping ("/itemdoacao")
	public ResponseEntity <ItemDoacao> criarItemmDoacao(
			@RequestBody ItemDoacao itemdoacao){
		
		
		System.out.println ("item doacao criado ..." + itemdoacao.toString());
		repository.save(itemdoacao);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(itemdoacao);
	}

	
	//Observação: para métodos que não sejam o GET e o POST é necessário colocar o -X(menos xis maiúsculo)
		//curl -X PUT http://localhost:8080/itemdoacao/1 -H "Content-Type: application/json; Charset=utf-8" -d @atualizar-Itemdoacao.json 
	
	@PutMapping ("itemdoacao/{id}")
	public ResponseEntity <Object> atualizarProduto(
			@PathVariable Integer id,
			@RequestBody ItemDoacao itemdoacao ){
		
		Optional <ItemDoacao> itemDoacao =repository.findById(id);
		
		if (itemDoacao.isEmpty()) {
			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Item doacao não encontrado");
		}
		
		itemdoacao.setId(id);
		repository.save(itemdoacao);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(itemdoacao);
	}
	//curl -X DELETE http://localhost:8080/itemdoacao/1
		@DeleteMapping("/itemdoacao/{id}")
		public ResponseEntity <Object> delete(@PathVariable Integer id){
			Optional<ItemDoacao> itemdoacao = repository.findById(id);
			if(itemdoacao.isEmpty()) {
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body("item não encontrado");
			}
			{
				repository.deleteById(id);
				return ResponseEntity
						.status(HttpStatus.OK)
						.body("Item excluido com sucesso");
			}
		}
	 
	 
}
																			