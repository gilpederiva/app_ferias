package commons;

import models.br.com.gilpederiva.pojo.ParcelaFerias;
import models.br.com.gilpederiva.pojo.Periodo;

import java.util.List;



public class ParcelaFeriasUtils {
			
	
	
	public static void setQuantidadeMaxDias(List<ParcelaFerias> parcelas, Integer indice, Integer maxDias) {
				
		for (ParcelaFerias p: parcelas) {
			if (p.getIndice().equals(indice))
				p.setMaxDias(maxDias);
		}
	}
	

	
	public static Boolean isPeriodoUtilizado(List<ParcelaFerias> parcelas, Periodo periodo, Integer indiceNaoConsiderado) {
		
		for (ParcelaFerias p: parcelas) {
			
			if (!p.getIndice().equals(indiceNaoConsiderado) && p.getInicio() != null && p.getFim() != null) {
					
				if ( DataUtils.between(periodo.getInicioDate(), p.getInicio(), p.getFim()) || 
						DataUtils.between(periodo.getFimDate(), p.getInicio(), p.getFim()) ){
					return true;
				}
			}				
		}
		
		return false;
	}
}
