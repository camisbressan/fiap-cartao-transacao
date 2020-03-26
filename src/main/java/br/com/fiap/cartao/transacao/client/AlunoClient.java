package br.com.fiap.cartao.transacao.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.cartao.transacao.dto.AlunoDTO;

@Component
public class AlunoClient {

	public static AlunoDTO consultaAluno(Integer idAluno) {

		final String uri = "http://localhost:8080/alunos/";
		RestTemplate restTemplate = new RestTemplate();

		AlunoDTO aluno = restTemplate.getForObject(uri + idAluno, AlunoDTO.class);
		
		return aluno;

	}
}
