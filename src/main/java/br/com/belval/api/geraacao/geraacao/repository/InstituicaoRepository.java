package br.com.belval.api.geraacao.geraacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.belval.api.geraacao.geraacao.model.Instituicao;
	
public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer> {
		
		//select * from instituicao where descricao like "%descricao%"
		//List<Instituicao> findByDescricaoContainingIgnoreCase(String descricao);

}


