package models.br.com.gilpederiva.pojo;

import java.io.Serializable;
import java.util.Date;

import commons.DataUtils;
import org.joda.time.DateTime;



public class Periodo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DateTime inicio;	
	private DateTime fim;
		
	
	
	
	public Periodo() {
		
	}
	
	public Periodo(DateTime inicio, DateTime fim) {		
		this.inicio = inicio;
		this.fim = fim;
	}


	public Periodo(Date inicio, Date fim) {		
		this.inicio = new DateTime(inicio);
		this.fim = new DateTime(fim);
	}

	
	public Integer getDiasPeriodo() {
		
		return DataUtils.getDiasPeriodo(inicio, fim);
	}
	
	public DateTime getInicio() {
		return inicio;
	}

	public void setInicio(DateTime inicio) {
		this.inicio = inicio;
	}

	public DateTime getFim() {
		return fim;
	}

	public void setFim(DateTime fim) {
		this.fim = fim;
	}

	public Date getInicioDate() {
		return inicio.toDate();
	}
	
	public Date getFimDate() {
		return fim.toDate();
	}

	@Override
	public String toString() {
		return "Periodo [inicio=" + inicio + ", fim=" + fim + "]";
	}
	
}
