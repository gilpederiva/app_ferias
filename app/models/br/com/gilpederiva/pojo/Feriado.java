package models.br.com.gilpederiva.pojo;

import java.io.Serializable;
import java.util.Date;

public class Feriado implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	private Date data;
	private String nome;
	private String tipoNome;
	private Integer tipoCodigo;
	
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipoNome() {
		return tipoNome;
	}
	public void setTipoNome(String tipoNome) {
		this.tipoNome = tipoNome;
	}
	public Integer getTipoCodigo() {
		return tipoCodigo;
	}
	public void setTipoCodigo(Integer tipoCodigo) {
		this.tipoCodigo = tipoCodigo;
	}
	
	
	
	@Override
	public String toString() {
		return "Feriado [data=" + data + ", nome=" + nome + ", tipoNome=" + tipoNome + ", tipoCodigo=" + tipoCodigo
				+ "]";
	}

}
