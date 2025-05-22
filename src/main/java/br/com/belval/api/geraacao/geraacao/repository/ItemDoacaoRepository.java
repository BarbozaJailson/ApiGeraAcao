package br.com.belval.api.geraacao.geraacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.belval.api.geraacao.geraacao.model.ItemDoacao;


public interface ItemDoacaoRepository extends JpaRepository<ItemDoacao, Integer> {
}
