package br.com.belval.api.geraacao.geraacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.belval.api.geraacao.geraacao.model.Doador;

public interface DoadorRepository extends JpaRepository<Doador, Long> {
}