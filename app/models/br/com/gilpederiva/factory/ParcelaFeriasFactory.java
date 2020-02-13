package models.br.com.gilpederiva.factory;

import models.br.com.gilpederiva.pojo.ParcelaFerias;

import java.util.ArrayList;
import java.util.List;



public class ParcelaFeriasFactory {
	
	
	public static List<ParcelaFerias> criaParcelasFerias(){
		
		
		ParcelaFerias p1 = new ParcelaFerias();
		p1.setMinDias(14);
		p1.setMaxDias(20);
		p1.setIndice(1);
		p1.setQtdeDiasNaoUteis(0);

		
		ParcelaFerias p2 = new ParcelaFerias();
		p2.setMinDias(5);		
		p2.setIndice(2);
		p2.setQtdeDiasNaoUteis(0);
		
		
		ParcelaFerias p3 = new ParcelaFerias();
		p3.setMinDias(5);		
		p3.setIndice(3);
		p3.setQtdeDiasNaoUteis(0);
					
		List<ParcelaFerias> parcelas = new ArrayList<ParcelaFerias>();
		
		parcelas.add(p1);
		parcelas.add(p2);
		parcelas.add(p3);
		
		return parcelas;						
	}
	

}
