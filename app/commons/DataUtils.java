package commons;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class DataUtils {

	
	
	public static Date convertToDate(String datasStr) throws Exception {
				
		return new SimpleDateFormat("dd/MM/yyyy").parse(datasStr);  
	}
	
	public static Integer diaSemana(Date data) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		return dayOfWeek;
	}
	
	
	public static DateTime retornaPrimeiroDiaAno(Integer ano) {
								
		return new DateTime(ano, 1, 1, 0, 0, 0);
	}
	
	
	public static DateTime retornaUltimoDiaAno(Integer ano) {
		
		return new DateTime(ano, 12, 31, 0, 0, 0);
	}	

	
	
	public static Integer getDiasPeriodo(Date inicio, Date fim) {
		if (inicio == null || fim == null)
			return 0;
		
		DateTime inicioDt = new DateTime(inicio);
		DateTime fimDt = new DateTime(fim);
		
		return Days.daysBetween(inicioDt, fimDt).getDays() + 1;
	}
		
	
	
	public static Integer getDiasPeriodo(DateTime inicio, DateTime fim) {
		if (inicio == null || fim == null)
			return 0;
		
		return Days.daysBetween(inicio, fim).getDays() + 1;
	}
	
	
	public static boolean between(Date date, Date inicio, Date fim) {
				
	    if (date != null && inicio != null && fim != null) {
	        return (dataIgualouPosterior(date, inicio) && dataIgualouAnterior(date, fim));

	    }
	    return false;
	}

	public static boolean dataIgualouPosterior(Date data1, Date date2)
	{
	    if (data1.equals(date2))
	        return true;

	    return (data1.after(date2));

	}
	public static boolean dataIgualouAnterior(Date data1, Date date2)
	{
	    if (data1.equals(date2))
	        return true;

	    return (data1.before(date2));

	}
}
