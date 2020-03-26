package br.com.fiap.cartao.transacao.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.cartao.transacao.client.AlunoClient;
import br.com.fiap.cartao.transacao.dto.AlunoDTO;
import br.com.fiap.cartao.transacao.dto.TransacaoDTO;
import br.com.fiap.cartao.transacao.service.TransacaoService;
import br.com.fiap.cartao.transacao.util.GeneratePdfReport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "Extrato")
@RequestMapping("extrato")
public class ExtratoController {

	@Autowired
	private TransacaoService transacaoService;

	@ApiOperation(value = "Gera um extrato em PDF de todas as transações")
	@GetMapping(produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> extratoTodasTransacoes() {

		List<TransacaoDTO> transacoes = transacaoService.findAll();
		
		ByteArrayInputStream bis = GeneratePdfReport.extratoTodasTransacoes(transacoes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=extratotransacoes.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	@ApiOperation(value = "Gera um extrato em PDF de todas as transações de um aluno")
	@GetMapping(value = "/aluno/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> extratoTransacoesPorAluno(@PathVariable(value = "id") Integer idAluno) throws Exception {
		try {
			List<TransacaoDTO> transacoes = transacaoService.findAllPorAluno(idAluno);
			AlunoDTO aluno = AlunoClient.consultaAluno(idAluno);
			ByteArrayInputStream bis = GeneratePdfReport.extratoTransacoesPorAluno(transacoes, aluno);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=extratotransacoesporaluno.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		} catch (Exception e) {
			throw new Exception("Não foi possível gerar o extrato");
		}

	}

}
