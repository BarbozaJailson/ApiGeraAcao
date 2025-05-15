package br.com.belval.api.geraacao.geraacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.belval.api.geraacao.geraacao.model.Doador;
import br.com.belval.api.geraacao.geraacao.repository.DoadorRepository;

@RestController
@RequestMapping("/doadores")
public class DoadorController {

    @Autowired
    private DoadorRepository doadorRepository;

    @GetMapping
    public List<Doador> listarTodos() {
        return doadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Doador> buscarPorId(@PathVariable Long id) {
        return doadorRepository.findById(id);
    }

    @PostMapping
    public Doador criar(@RequestBody Doador doador) {
        return doadorRepository.save(doador);
    }

    @PutMapping("/{id}")
    public Doador atualizar(@PathVariable Long id, @RequestBody Doador doadorAtualizado) {
        return doadorRepository.findById(id).map(doador -> {
            doador.setNome(doadorAtualizado.getNome());
            doador.setIdade(doadorAtualizado.getIdade());
            doador.setImagem(doadorAtualizado.getImagem());
            doador.setCep(doadorAtualizado.getCep());
            return doadorRepository.save(doador);
        }).orElseGet(() -> {
            doadorAtualizado.setIdDoador(id);
            return doadorRepository.save(doadorAtualizado);
        });
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        doadorRepository.deleteById(id);
    }
}

