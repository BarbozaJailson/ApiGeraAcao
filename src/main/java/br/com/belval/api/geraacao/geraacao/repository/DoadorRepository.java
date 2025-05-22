package br.com.belval.api.geraacao.geraacao.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.belval.api.geraacao.geraacao.model.Doador;

public interface DoadorRepository extends CrudRepository<Doador, Long> {
}