package models.br.com.gilpederiva.pojo;

import commons.DataUtils;

import java.io.Serializable;
import java.util.Date;



public class ParcelaFerias implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer indice;
	
	private Date inicio;
	
	private Date fim;
		
	private Integer minDias;
	
	private Integer maxDias;

	private Integer qtdeDiasNaoUteis;
	
	
	
	
	public ParcelaFerias() {
		super();
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Integer getMinDias() {
		return minDias;
	}

	public void setMinDias(Integer minDias) {
		this.minDias = minDias;
	}

	public Integer getMaxDias() {
		return maxDias;
	}

	public void setMaxDias(Integer maxDias) {
		this.maxDias = maxDias;
	}

	public Integer getQtdeDiasNaoUteis() {
		return qtdeDiasNaoUteis;
	}

	public void setQtdeDiasNaoUteis(Integer qtdeDiasNaoUteis) {
		this.qtdeDiasNaoUteis = qtdeDiasNaoUteis;
	}

	public Integer getDiasPeriodo() {
		
		return DataUtils.getDiasPeriodo(inicio, fim);
	}

	@Override
	public String toString() {
		return "ParcelaFerias [indice=" + indice + ", inicio=" + inicio + ", fim=" + fim + ", minDias=" + minDias
				+ ", maxDias=" + maxDias + ", getDiasPeriodo()=" + getDiasPeriodo() + "]";
	}

}
