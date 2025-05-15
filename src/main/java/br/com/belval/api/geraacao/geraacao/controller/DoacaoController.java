package br.com.belval.api.geraacao.geraacao.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.belval.api.geraacao.geraacao.model.Doacao;
import br.com.belval.api.geraacao.geraacao.repository.DoacaoRepository;

@RestController
@RequestMapping
public class DoacaoController {

	@Autowired
	private DoacaoRepository doacaoRepository;
	
	@GetMapping("/doacoes")
	public ResponseEntity <Object> getAll(){
		Iterable<Doacao> doacao = new ArrayList<>();
		try {
			doacao = doacaoRepository.findAll();
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(doacao);
		}catch(Exception e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Doacao não encontrada");
		}
	}
	
	@GetMapping("/doacoes/{id}")
	public ResponseEntity <Object> getById(@PathVariable Integer id){
		Optional<Doacao> doacao = doacaoRepository.findById(id);
		if(doacao.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Doacao não encontrada");
		}
		{
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(doacao);
		}
	}
	
	//curl POST http://localhost:8080/doacoes -H "Content-Type: application/json; Charset=utf-8" -d @nova-doacao.json
	@PostMapping("/doacoes")
	public ResponseEntity <Object> save(@RequestBody Doacao doacao){
		try {
			Doacao doac = doacaoRepository.save(doacao);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(doac);
		}catch(Exception e) {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro ao salvar doação");
		}
	}
	
	//Observação: para métodos que não sejam o GET e o POST é necessário colocar o -X(menos xis maiúsculo)
	//curl -X PUT http://localhost:8080/doacoes/1 -H "Content-Type: application/json; Charset=utf-8" -d @atualiza-doacao.json
	@PutMapping("/doacoes/{id}")
	public ResponseEntity <Object> update(@PathVariable Integer id, @RequestBody Doacao doacao){
		Optional<Doacao> doac = doacaoRepository.findById(id);
		if(doac.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Doacao não encontrada");
		}
		{
			doacao.setId(id);
			doacaoRepository.save(doacao);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(doacao);
		}
	}
	
	
	public ResponseEntity <Object> delete(@PathVariable Integer id){
		Optional<Doacao> doac = doacaoRepository.findById(id);
		if(doac.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Doacao não encontrada");
		}
		{
			doacaoRepository.deleteById(id);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("Doação exclida com sucesso");
		}
	}
	
}
