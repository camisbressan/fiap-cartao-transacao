package br.com.fiap.cartao.transacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.cartao.transacao.entity.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    @Query("from Transacao c where c.idAluno = :idAluno")
	List<Transacao> findAllPorAluno(Integer idAluno);
}
