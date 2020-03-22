package br.com.fiap.cartao.transacao.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import br.com.fiap.cartao.transacao.dto.CreateTransacaoDTO;

@Entity
@Table(name = "TB_TRANSACAO")
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "id_aluno")
    private Integer idAluno;
	
	@Column(name = "valor_compra")
    private BigDecimal valorCompra;
    
	@Column(name = "data_compra")
	@CreatedDate
    private Date dataCompra;

	public Transacao() {
	}

	public Transacao(CreateTransacaoDTO createTransacaoDTO) {
		this.idAluno = createTransacaoDTO.getIdAluno();
		this.valorCompra = createTransacaoDTO.getValorCompra();
		this.dataCompra = Date.from(createTransacaoDTO.getDataCompra().toInstant());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

}
