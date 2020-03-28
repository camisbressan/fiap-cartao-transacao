package br.com.fiap.cartao.transacao.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fiap.cartao.transacao.dto.CreateTransacaoDTO;
import br.com.fiap.cartao.transacao.dto.TransacaoDTO;
import br.com.fiap.cartao.transacao.entity.Transacao;
import br.com.fiap.cartao.transacao.repository.TransacaoRepository;
import br.com.fiap.cartao.transacao.service.TransacaoService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TransacaoServiceImplTest {

	@Test
	public void testFindAll() {
		TransacaoRepository transacaoRepository = mock(TransacaoRepository.class);
		List<Transacao> transacaoList = new ArrayList<Transacao>();
		transacaoList.add(new Transacao());
		transacaoList.add(new Transacao());
		transacaoList.add(new Transacao());
		when(transacaoRepository.findAll()).thenReturn(transacaoList);

		TransacaoService transacaoService = new TransacaoServiceImpl(transacaoRepository);

		assertEquals(transacaoService.findAll().size(), 3);
	}

	@Test
	public void testFindAllPorAluno() {
		TransacaoRepository transacaoRepository = mock(TransacaoRepository.class);
		List<Transacao> transacaoList = new ArrayList<Transacao>();
		transacaoList.add(new Transacao());
		transacaoList.add(new Transacao());
		transacaoList.add(new Transacao());
		when(transacaoRepository.findAllPorAluno(1)).thenReturn(transacaoList);

		TransacaoService transacaoService = new TransacaoServiceImpl(transacaoRepository);

		assertEquals(transacaoService.findAllPorAluno(1).size(), 3);
	}
	
	@Test
	public void testFindById() {
		TransacaoRepository transacaoRepository = mock(TransacaoRepository.class);
		Transacao transacao = gerarTransacao();
		Optional<Transacao> transacaoOptional = Optional.of(transacao);

		when(transacaoRepository.findById(1)).thenReturn(transacaoOptional);
		TransacaoService transacaoService = new TransacaoServiceImpl(transacaoRepository);

		assertEquals(transacaoService.findById(1).getId(), transacao.getId());
		assertEquals(transacaoService.findById(1).getIdAluno(), transacao.getIdAluno());
		assertEquals(transacaoService.findById(1).getValorCompra(), transacao.getValorCompra());
	}

	@Test
	public void testCreate() {
		TransacaoRepository transacaoRepository = mock(TransacaoRepository.class);
		when(transacaoRepository.save(Mockito.any(Transacao.class))).thenReturn(gerarTransacao());

		TransacaoService transacaoService = new TransacaoServiceImpl(transacaoRepository);
		TransacaoDTO transacaoRetorno = transacaoService.create(gerarCreateTransacaoDTO());

		assertNotNull(transacaoRetorno);
		assertEquals(transacaoRetorno.getIdAluno(), gerarTransacao().getIdAluno());
		assertEquals(transacaoRetorno.getValorCompra(), gerarTransacao().getValorCompra());
	}

	@Test
	public void testDelete() {
		TransacaoRepository transacaoRepository = mock(TransacaoRepository.class);
		transacaoRepository.deleteById(any());
		verify(transacaoRepository, times(1)).deleteById(any());
	}

	public Transacao gerarTransacao() {
		Transacao transacao = new Transacao();
		transacao.setId(999999999);
		transacao.setIdAluno(999999999);
		transacao.setValorCompra(new BigDecimal("123456"));
		transacao.setDataCompra(new Date());
		return transacao;
	}

	public CreateTransacaoDTO gerarCreateTransacaoDTO() {
		CreateTransacaoDTO transacao = new CreateTransacaoDTO();
		transacao.setIdAluno(999999999);
		transacao.setValorCompra(new BigDecimal("123456"));
		transacao.setDataCompra(ZonedDateTime.ofInstant(new Date().toInstant(), ZoneOffset.systemDefault()));
		return transacao;
	}

}
