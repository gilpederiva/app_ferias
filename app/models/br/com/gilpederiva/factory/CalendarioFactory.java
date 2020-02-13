package models.br.com.gilpederiva.factory;

import commons.DataUtils;
import commons.FeriadoUtils;
import models.br.com.gilpederiva.pojo.Calendario;
import models.br.com.gilpederiva.pojo.CalendarioItem;
import models.br.com.gilpederiva.pojo.Feriado;
import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.List;



public class CalendarioFactory {

	
	
	public static Calendario criaCalendario(List<Feriado> feriados, Integer ano){
				
		Calendario calendario = new Calendario(ano);
						
		DateTime inicio = DataUtils.retornaPrimeiroDiaAno(ano);
		DateTime fim = DataUtils.retornaUltimoDiaAno(ano);
					
		while(DataUtils.dataIgualouAnterior(inicio.toDate(), fim.toDate())) {
			
			CalendarioItem dataItem = new CalendarioItem(inicio.toDate());
			
			if (FeriadoUtils.inFeriado(inicio.toDate(), feriados))
				dataItem.setFeriado(true);
			
			dataItem.setDiaSemana(  DataUtils.diaSemana(inicio.toDate()) );
			
			calendario.addData(dataItem);
			
			inicio = inicio.plus(Period.days(1));			
		}
		
		return calendario;
	}
	
}
