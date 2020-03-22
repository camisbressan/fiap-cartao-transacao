package br.com.fiap.cartao.transacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cartao.transacao.dto.CreateTransacaoDTO;
import br.com.fiap.cartao.transacao.dto.TransacaoDTO;
import br.com.fiap.cartao.transacao.service.impl.TransacaoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Transacao")
@RequestMapping("transacao")
public class TransacaoController {

	private final TransacaoServiceImpl service;

	public TransacaoController(TransacaoServiceImpl service) {
		this.service = service;
	}

	@ApiOperation(value = "Lista todas as transações")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Transações listadas com sucesso"),
			@ApiResponse(code = 401, message = "Você não tem autorização"),
			@ApiResponse(code = 403, message = "É proibido acessar esse recurso"),
			@ApiResponse(code = 404, message = "O recurso não foi encontrado") })
	@GetMapping
	public List<TransacaoDTO> getAll() {
		return service.findAll();
	}

	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Obtém uma transação")
	@ApiResponses({ @ApiResponse(code = 200, message = "Transação encontrada"),
			@ApiResponse(code = 401, message = "Você não tem autorização"),
			@ApiResponse(code = 403, message = "É proibido acessar esse recurso"),
			@ApiResponse(code = 404, message = "O recurso não foi encontrado") })
	@GetMapping("{id}")
	public TransacaoDTO findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@ApiOperation(value = "Cria uma transação")
	@ApiResponses({ @ApiResponse(code = 201, message = "Transação criada com sucesso"),
			@ApiResponse(code = 401, message = "Você não tem autorização"),
			@ApiResponse(code = 403, message = "É proibido acessar esse recurso"),
			@ApiResponse(code = 404, message = "O recurso não foi encontrado") })
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TransacaoDTO create(@RequestBody @Valid CreateTransacaoDTO createTransacaoDTO) {
		return service.create(createTransacaoDTO);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Exclui uma transação")
	@ApiResponses({ @ApiResponse(code = 204, message = "Exclusão com sucesso de uma transação"),
			@ApiResponse(code = 401, message = "Você não tem autorização"),
			@ApiResponse(code = 403, message = "É proibido acessar esse recurso"),
			@ApiResponse(code = 404, message = "O recurso não foi encontrado") })
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	
	@ApiOperation(value = "Lista todas as transações de um aluno")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Transações listadas com sucesso"),
			@ApiResponse(code = 401, message = "Você não tem autorização"),
			@ApiResponse(code = 403, message = "É proibido acessar esse recurso"),
			@ApiResponse(code = 404, message = "O recurso não foi encontrado") })
	@GetMapping("/aluno/{id}")
	public List<TransacaoDTO> getAllPorAluno(@PathVariable ("id") Integer idAluno) {
		return service.findAllPorAluno(idAluno);
	}
}
