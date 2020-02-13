package models.br.com.gilpederiva.pojo;

import java.io.Serializable;
import java.util.Date;

public class CalendarioItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date data;	
	
	private Boolean feriado;
	
	private Integer diaSemana;

	
	
	
	
	public CalendarioItem(Date data) {
		this.data = data;
		this.feriado = false;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Boolean getFeriado() {
		return feriado;
	}

	public void setFeriado(Boolean feriado) {
		this.feriado = feriado;
	}

	public Integer getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}

	@Override
	public String toString() {
		return "DataItem [data=" + data + ", feriado=" + feriado + ", diaSemana=" + diaSemana + "]";
	}
		
}
