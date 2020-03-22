package br.com.fiap.cartao.transacao.dto;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import br.com.fiap.cartao.transacao.entity.Transacao;

public class TransacaoDTO {

    private Integer id;
    private Integer idAluno;
    private BigDecimal valorCompra;
    private ZonedDateTime dataCompra;
    
    public TransacaoDTO(){}
    
	public TransacaoDTO(Integer id, Integer idAluno, BigDecimal valorCompra, ZonedDateTime dataCompra) {
		this.id = id;
		this.idAluno = idAluno;
		this.valorCompra = valorCompra;
		this.dataCompra = dataCompra;
	}


	public TransacaoDTO(CreateTransacaoDTO transacaoDTO, Integer id) {
		this.id = id;
		this.idAluno = transacaoDTO.getIdAluno();
		this.valorCompra = transacaoDTO.getValorCompra();
		this.dataCompra = transacaoDTO.getDataCompra();
	}

	public TransacaoDTO(Transacao aluno) {
		this.id = aluno.getId();
		this.idAluno = aluno.getIdAluno();
		this.valorCompra = aluno.getValorCompra();
        this.dataCompra = convertToZonedDateTime(aluno.getDataCompra());
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

    private ZonedDateTime convertToZonedDateTime(Date data) {
        if(data != null){
            return ZonedDateTime.ofInstant(data.toInstant(), ZoneOffset.systemDefault());
        } else {
            return null;
        }
    }

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public ZonedDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(ZonedDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}
    
}
