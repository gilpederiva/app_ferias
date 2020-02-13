package models.br.com.gilpederiva.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Calendario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer ano;
	
	private List<CalendarioItem> datas;

	
		
	public Calendario(Integer ano) {
		this.ano = ano;
		this.datas = new ArrayList<CalendarioItem>();
	}

	
	public void addData(CalendarioItem data) {
		datas.add(data);
	}
	

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public List<CalendarioItem> getDatas() {
		return datas;
	}

	public void setDatas(List<CalendarioItem> datas) {
		this.datas = datas;
	}


	@Override
	public String toString() {
		return "Calendario [ano=" + ano + ", datas=" + datas + "]";
	}
		
}
