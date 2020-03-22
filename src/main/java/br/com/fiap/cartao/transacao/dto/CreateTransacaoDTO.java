package br.com.fiap.cartao.transacao.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class CreateTransacaoDTO {

    private Integer idAluno;
    private BigDecimal valorCompra;
    private ZonedDateTime dataCompra;
    
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
