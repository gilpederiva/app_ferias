package models.br.com.gilpederiva.factory;

import models.br.com.gilpederiva.pojo.Feriado;
import commons.FeriadoUtils;
import ws.FeriadoService;
import ws.FeriadoWS;

import java.io.IOException;
import java.util.List;



public class FeriadoFactory {
	
	
	

	public static List<Feriado> criaFeriados(Integer ano) throws IOException{
				
		FeriadoService feriadoService = new FeriadoService(ano);
		
		List<FeriadoWS> feriadosWs = feriadoService.getFeriadosWS();
		
		List<Feriado> feriados = FeriadoUtils.converteParaListaFeriados(feriadosWs);
		
		return feriados;		
	}
	
}
