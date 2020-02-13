package commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.br.com.gilpederiva.pojo.Feriado;
import ws.FeriadoWS;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.Period;



public class FeriadoUtils {
	
		
	public static Boolean feriadoPermitido(Feriado feriado) {
		
		List<Integer> codigosPermitidos = new ArrayList<Integer>();
		
		//TODO deixar mais flexível os feriados que podem ser considerados
		codigosPermitidos.add(FeriadoWS.FERIADO_NACIONAL);
		codigosPermitidos.add(FeriadoWS.FERIADO_ESTADUAL);
		codigosPermitidos.add(FeriadoWS.FERIADO_MUNICIPAL);
		
		if (codigosPermitidos.contains(feriado.getTipoCodigo()))
			return true;
		
		return false;		
	}
	
	
	public static Boolean feriadoNoDomingo(Feriado feriado) {
	
		Integer diaSemana = DataUtils.diaSemana(feriado.getData());
					
		if (diaSemana.equals(1))
			return true;
		
		return false;		
	}
	
	
	
	public static Boolean inFeriado(Date data, List<Feriado> feriados) {

		for (Feriado feriado: feriados) {
			if (DateUtils.isSameDay(feriado.getData(),data))
				return true;
		}
		
		return false;
	}
	
	
	
	public static Boolean isDiaNaoUtil(DateTime data, List<Feriado> feriados) {
		
		Integer diaSemana = DataUtils.diaSemana(data.toDate());
		
		if (inFeriado(data.toDate(), feriados) || diaSemana.equals(1))
			return true;
		
		return false;
		
	}
	
	
	public static Integer getQuantidadeDiasNaoUteis(DateTime inicio, DateTime fim, List<Feriado> feriados) {
		
		Integer quantidade = 0;
		
		while ( !inicio.isAfter(fim)  ) {			
			if (FeriadoUtils.isDiaNaoUtil(inicio, feriados))
				quantidade += 1;	
			
			inicio = inicio.plus(Period.days(1));
		}			
		return quantidade;		
	}
	
	
	public static List<Feriado> converteParaListaFeriados(List<FeriadoWS> feriadosWS) {
		
		List<Feriado> feriados = new ArrayList<Feriado>();
		
		for (FeriadoWS f: feriadosWS) {
			
			Feriado feriado = convertoParaFeriado(f); 
			
			if ( FeriadoUtils.isFeriadoValido(feriado) )				
				feriados.add(feriado);									
		}
		
		return feriados;		
	}
	
	
	public static Feriado convertoParaFeriado(FeriadoWS feriadoWS) {
		
		try {
			Feriado feriado = new Feriado();
			
			feriado.setData( DataUtils.convertToDate(feriadoWS.getDate()));
			feriado.setNome( feriadoWS.getName() );
			feriado.setTipoNome( feriadoWS.getType() );		
			feriado.setTipoCodigo( Integer.valueOf(feriadoWS.getType_code()));
			
			return feriado;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Boolean isFeriadoValido(Feriado feriado) {
				
		if (feriado != null && FeriadoUtils.feriadoPermitido(feriado) && !FeriadoUtils.feriadoNoDomingo(feriado))
			return true;
		
		return false;
	}	
	

}
