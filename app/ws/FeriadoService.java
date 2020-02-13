package ws;

import com.google.gson.Gson;
import play.libs.WS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FeriadoService {
	
	
	private String urlWs  = "https://api.calendario.com.br/?ano=%s&estado=ms&cidade=dourados&token=YW5kcmVtbmFzY2ltZW50b0B1ZmdkLmVkdS5iciZoYXNoPTIyNTM3MTM0Mg&json=true";
	private List<FeriadoWS> feriadosWS = new ArrayList<FeriadoWS>();
	private Integer ano;

	public FeriadoService(Integer ano) throws IOException {
		this.ano = ano;
		
		String url = String.format(urlWs, this.ano);
		WS.HttpResponse resposta =  WS.url(url).get();

		Gson gson = new Gson();
		FeriadoWS[] feriadosWS = gson.fromJson(resposta.getJson(), FeriadoWS[].class);

		this.feriadosWS = Arrays.asList(feriadosWS);
	}
	
	
	
	public List<FeriadoWS> getFeriadosWS() {
		return feriadosWS;
	}
	public void setFeriadosWS(List<FeriadoWS> feriadosWS) {
		this.feriadosWS = feriadosWS;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
}
