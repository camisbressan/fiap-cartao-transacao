package br.com.fiap.cartao.transacao.service;

import java.util.List;

import br.com.fiap.cartao.transacao.dto.CreateTransacaoDTO;
import br.com.fiap.cartao.transacao.dto.TransacaoDTO;


public interface TransacaoService {

	List<TransacaoDTO> findAll();

	TransacaoDTO findById(Integer id);

	TransacaoDTO create(CreateTransacaoDTO createTransacaoDTO);

	void delete(Integer id);
	
	List<TransacaoDTO> findAllPorAluno(Integer idAluno);
}
