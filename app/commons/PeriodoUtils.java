package commons;

import models.br.com.gilpederiva.pojo.Feriado;
import models.br.com.gilpederiva.pojo.Periodo;
import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.List;



public class PeriodoUtils {
	
	public static Integer getQuantidadeDiasNaoUteis(Periodo periodo, List<Feriado> feriados) {
		
		DateTime inicio = new DateTime(periodo.getInicio());
		DateTime fim = new DateTime(periodo.getFim());
		
		Integer quantidade = 0;
		
		while ( DataUtils.dataIgualouAnterior(inicio.toDate(), fim.toDate()) ) {
			if (FeriadoUtils.isDiaNaoUtil(inicio, feriados))
				quantidade += 1;	
			
			inicio = inicio.plus(Period.days(1));
		}			
		return quantidade;		
	}
	
}
