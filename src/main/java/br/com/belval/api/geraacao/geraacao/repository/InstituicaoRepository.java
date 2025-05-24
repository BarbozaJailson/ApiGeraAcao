package br.com.belval.api.geraacao.geraacao.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.belval.api.geraacao.geraacao.model.Instituicao;
	
public interface InstituicaoRepository extends CrudRepository<Instituicao, Integer> {
		
		//select * from instituicao where descricao like "%descricao%"
		//List<Instituicao> findByDescricaoContainingIgnoreCase(String descricao);

}


