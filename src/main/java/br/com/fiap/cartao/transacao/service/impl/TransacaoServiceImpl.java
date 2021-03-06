package br.com.fiap.cartao.transacao.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.cartao.transacao.dto.CreateTransacaoDTO;
import br.com.fiap.cartao.transacao.dto.TransacaoDTO;
import br.com.fiap.cartao.transacao.entity.Transacao;
import br.com.fiap.cartao.transacao.repository.TransacaoRepository;
import br.com.fiap.cartao.transacao.service.TransacaoService;

@Service
public class TransacaoServiceImpl implements TransacaoService {

	private TransacaoRepository transacaoRepository;

	public TransacaoServiceImpl(TransacaoRepository transacaoRepository) {
		this.transacaoRepository = transacaoRepository;
	}

	@Override
	public List<TransacaoDTO> findAll() {
		List<Transacao> transacoesList = transacaoRepository.findAll();
		return transacoesList.stream().map(TransacaoDTO::new).collect(Collectors.toList());
	}

	@Override
	public TransacaoDTO findById(Integer id) {
		return new TransacaoDTO(
				transacaoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
	}

	@Override
	public TransacaoDTO create(CreateTransacaoDTO createTransacaoDTO) {
		Transacao transacao = new Transacao(createTransacaoDTO);
		transacao.setDataCompra(new Date());
		return new TransacaoDTO(transacaoRepository.save(transacao));
	}

	@Override
	public void delete(Integer id) {
		transacaoRepository.deleteById(id);
	}
	
	@Override
	public List<TransacaoDTO> findAllPorAluno(Integer idAluno) {
		List<Transacao> transacoesList = transacaoRepository.findAllPorAluno(idAluno);
		return transacoesList.stream().map(TransacaoDTO::new).collect(Collectors.toList());
	}

}
