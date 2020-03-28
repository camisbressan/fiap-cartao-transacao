package br.com.fiap.cartao.transacao.controller;
/**
 * 
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.fiap.cartao.transacao.dto.TransacaoDTO;
import br.com.fiap.cartao.transacao.entity.Transacao;
import br.com.fiap.cartao.transacao.service.TransacaoService;

@RunWith(SpringRunner.class)
@SpringBootTest
*/
public class TransacaoControllerTest {
/**
	@MockBean
	private TransacaoService transacaoService;

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Before
	private void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	public String gerarToken() throws Exception {
		
		String username = "fiapcartaotransacao";
		String password = "password";

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/authenticate")
						.content("{\"usuario\":\"" + username + "\", \"senha\":\"" + password + "\"}"))
				.andExpect(status().isOk()).andReturn();

		String response = result.getResponse().getContentAsString();
		response = response.replace("{\"access_token\": \"", "");
		String token = response.replace("\"}", "");
		return token;
	}

	@Test
	public void testFindAll() throws Exception {

		List<TransacaoDTO> transacaoDTOList = new ArrayList<TransacaoDTO>();
		transacaoDTOList.add(new TransacaoDTO(gerarTransacao()));

		given(transacaoService.findAll()).willReturn(transacaoDTOList);

		mockMvc.perform(get("/transacao").header("Authorization", "Bearer " + gerarToken())).andExpect(status().isOk())
				.andExpect(content().json(
						"[{'id': 999999999, 'idAluno': 999999999,'valorCompra': 123456, 'dataCompra': '2020-03-27T21:29:00.265Z'}]"));

		verify(transacaoService, times(1)).findAll();
	}

	@Test
	public void testFindAllPorAluno() throws Exception {

		List<TransacaoDTO> transacaoDTOList = new ArrayList<TransacaoDTO>();
		transacaoDTOList.add(new TransacaoDTO(gerarTransacao()));

		given(transacaoService.findAllPorAluno(999999999)).willReturn(transacaoDTOList);

		mockMvc.perform(get("/transacao").header("Authorization", "Bearer " + gerarToken())).andExpect(status().isOk()).andExpect(content()
				.json("[{'id': 999999999, 'idAluno': 999999999,'valorCompra': 123456, 'dataCompra': '2020-03-27T21:29:00.265Z'}]"));

		verify(transacaoService, times(1)).findAllPorAluno(999999999);
	}

	@Test
	public void testFindById() throws Exception {

		TransacaoDTO transacaoDTOList = new TransacaoDTO(gerarTransacao());

		given(transacaoService.findById(999999999)).willReturn(transacaoDTOList);

		mockMvc.perform(get("/transacao/{id}", 999999999).header("Authorization", "Bearer " + gerarToken())).andExpect(status().isOk()).andExpect(content().json(
				"{ \"id\": 999999999, \"idAluno\": 999999999, \"valorCompra\": 123456, \"dataCompra\": \"2020-03-27T21:29:00.265Z\" }"));

		verify(transacaoService, times(1)).findById(999999999);
	}

	@Test
	public void testCreate() throws Exception {

		mockMvc.perform(post("/transacao").header("Authorization", "Bearer " + gerarToken()).contentType(MediaType.APPLICATION_JSON).content(
				"{ \"id\": 999999999, \"idAluno\": 999999999, \"valorCompra\": 123456, \"dataCompra\": \"2020-03-27T21:29:00.265Z\" }"))
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void testDelete() throws Exception {
		TransacaoDTO transacao = gerarTransacaoDTO();

		doNothing().when(transacaoService).delete(transacao.getId());

		mockMvc.perform(delete("/transacao/{id}", transacao.getId()).header("Authorization", "Bearer " + gerarToken())).andExpect(status().is2xxSuccessful());

		verify(transacaoService, times(1)).delete(transacao.getId());
	}

	public Transacao gerarTransacao() {
		Transacao transacao = new Transacao();
		transacao.setId(999999999);
		transacao.setIdAluno(999999999);
		transacao.setValorCompra(new BigDecimal("123456"));
		transacao.setDataCompra(new Date());
		return transacao;
	}

	public TransacaoDTO gerarTransacaoDTO() {
		TransacaoDTO transacao = new TransacaoDTO();
		transacao.setIdAluno(999999999);
		transacao.setValorCompra(new BigDecimal("123456"));
		transacao.setDataCompra(ZonedDateTime.ofInstant(new Date().toInstant(), ZoneOffset.systemDefault()));
		return transacao;

	}
*/
}