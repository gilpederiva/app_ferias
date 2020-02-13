package commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.br.com.gilpederiva.pojo.Feriado;
import org.joda.time.DateTime;
import org.joda.time.Period;



public class FeriasUtils {

	
	/**
	 * TODO refatorar esse código para ser otimizado
	 * @param feriados
	 * @return
	 */
	public static Boolean isDiaInicialValido(Date data, List<Feriado> feriados) {
		
		DateTime datainicial = new DateTime(data);
		
		Integer diaSemana = DataUtils.diaSemana(datainicial.toDate());
		
		List<Integer> diasNaoValidos = new ArrayList<Integer>();
		diasNaoValidos.add(6);
		diasNaoValidos.add(7);
		diasNaoValidos.add(1);
				
		//Não pode começar na sexta, sábado ou domingo
		if (diasNaoValidos.contains(diaSemana))
			return false;
				
		//não pode ser feriado
		if (FeriadoUtils.inFeriado(datainicial.toDate(), feriados))
			return false;
		
		//não pode começar menos de 2 dias de feriado
		if (FeriadoUtils.inFeriado(datainicial.plus(Period.days(2)).toDate(), feriados))
			return false;
		
		//não pode começar menos de 1 dias de feriado
		if (FeriadoUtils.inFeriado(datainicial.plus(Period.days(1)).toDate(), feriados))
			return false;
		
		return true;
	}
	
}
