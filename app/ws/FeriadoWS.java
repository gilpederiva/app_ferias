package ws;

import java.io.Serializable;

public class FeriadoWS implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	public static Integer FERIADO_NACIONAL = 1;
	public static Integer FERIADO_ESTADUAL = 2;
	public static Integer FERIADO_MUNICIPAL = 3;
	
	private String date;
	private String name;
	private String type;
	private String type_code;
	private String link;
	private String description;
	private String raw_description;
	
	
	
	public FeriadoWS() {
		
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getType_code() {
		return type_code;
	}



	public void setType_code(String type_code) {
		this.type_code = type_code;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getRaw_description() {
		return raw_description;
	}



	public void setRaw_description(String raw_description) {
		this.raw_description = raw_description;
	}



	@Override
	public String toString() {
		return "Feriado [date=" + date + ", name=" + name + ", type=" + type + ", type_code=" + type_code + ", link="
				+ link + ", description=" + description + ", raw_description=" + raw_description + "]";
	}

}
