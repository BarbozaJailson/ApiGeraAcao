





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
import org.springframework.web.bind.annotation.RestController;

import br.com.belval.api.geraacao.geraacao.model.Doador;
import br.com.belval.api.geraacao.geraacao.repository.DoadorRepository;
 
@RestController
public class DoadorController {
 
    @Autowired
    private DoadorRepository repository;
    
    //curl http://localhost:8080/doadores
    
    //curl -X DELETE http://localhost:8080/doadores/7
    
 
    //curl -X POST http://localhost:8080/doadores -H "Content-Type: application/json; Charset=utf-8" -d @novo-Doador.json
    
  //Observação: para métodos que não sejam o GET e o POST é necessário colocar o -X(menos xis maiúsculo)
  	//curl -X PUT http://localhost:8080/doadores/4 -H "Content-Type: application/json; Charset=utf-8" -d @atualizar-Doador.json
    
    
    @GetMapping("/doadores")
    public ResponseEntity<Iterable<Doador>> obterDoadores() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(repository.findAll());
    }
 
    @GetMapping("/doadores/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {
    	
        Optional<Doador> doador = repository.findById(id);
 
        if (doador.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(doador.get());
        }
 
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Doador não encontrado.");
    }
 
    @PostMapping("/doadores")
    public ResponseEntity<Doador> criarDoador(@RequestBody Doador doador) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(repository.save(doador));
    }
    @PutMapping("/doadores/{id}")
    public ResponseEntity<?> atualizarDoador(@PathVariable Long id, @RequestBody Doador doadorAtualizado) {
        Optional<Doador> doadorExistente = repository.findById(id);
     
        if (doadorExistente.isPresent()) {
            Doador doador = doadorExistente.get();
            doador.setNome(doadorAtualizado.getNome());
            doador.setIdade(doadorAtualizado.getIdade());
            doador.setImagem(doadorAtualizado.getImagem());
            doador.setCep(doadorAtualizado.getCep());
     
            repository.save(doador);
            return ResponseEntity.ok(doador);
        }
     
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("Doador não encontrado.");
    }
    
    @DeleteMapping("/doadores/{id}")
    public ResponseEntity<String> deletarDoador(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity
    				.status(HttpStatus.OK)
    				.body("Ok.");
    				
        }
        return ResponseEntity
        		.status(HttpStatus.NOT_FOUND)
        		.body("nao encontrado.");
    }
    
    
}

