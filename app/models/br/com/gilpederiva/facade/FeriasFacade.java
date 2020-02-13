package models.br.com.gilpederiva.facade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.br.com.gilpederiva.factory.CalendarioFactory;
import models.br.com.gilpederiva.factory.FeriadoFactory;
import models.br.com.gilpederiva.factory.ParcelaFeriasFactory;
import models.br.com.gilpederiva.pojo.*;
import commons.DataUtils;
import commons.FeriasUtils;
import commons.ParcelaFeriasUtils;
import commons.PeriodoUtils;
import org.joda.time.DateTime;
import org.joda.time.Period;



public class FeriasFacade {

	private Integer ano;
	
	private List<ParcelaFerias> parcelasFerias;
	
	
	public FeriasFacade(Integer ano) {
		this.ano = ano;
	}
	
	public List<ParcelaFerias> geraParcelasFerias() throws Exception{
		
		valida();
		
		List<Feriado> feriados = FeriadoFactory.criaFeriados(ano);
		Calendario calendario = CalendarioFactory.criaCalendario(feriados, ano);
		this.parcelasFerias = ParcelaFeriasFactory.criaParcelasFerias();

		List<Integer> listaMaxDiasPorPeriodo = new ArrayList<Integer>();	
											
		for (ParcelaFerias parcelaFerias: this.parcelasFerias) {
		
			//Integer quantidadeDiasNaoUteisPeriodo = 0;
			
			for (CalendarioItem calendarioItem: calendario.getDatas()) {

				if (FeriasUtils.isDiaInicialValido(calendarioItem.getData(), feriados)) {
													
					Periodo periodoFerias = new Periodo(calendarioItem.getData(), calendarioItem.getData());

					if (!ParcelaFeriasUtils.isPeriodoUtilizado(this.parcelasFerias, periodoFerias, parcelaFerias.getIndice())) {
																					
						while(periodoFerias.getDiasPeriodo() <= parcelaFerias.getMaxDias()) {
							
							Integer qtdeDiasNaoUteisPeriodoAux = PeriodoUtils.getQuantidadeDiasNaoUteis(periodoFerias, feriados);
									
							if (
									(qtdeDiasNaoUteisPeriodoAux > parcelaFerias.getQtdeDiasNaoUteis()) ||
									(
										qtdeDiasNaoUteisPeriodoAux == parcelaFerias.getQtdeDiasNaoUteis() &&
										parcelaFerias.getDiasPeriodo() > periodoFerias.getDiasPeriodo() 
									) 
								) {

								parcelaFerias.setInicio(periodoFerias.getInicioDate());
								parcelaFerias.setFim(periodoFerias.getFimDate());
								parcelaFerias.setQtdeDiasNaoUteis( qtdeDiasNaoUteisPeriodoAux );
								//quantidadeDiasNaoUteisPeriodo = qtdeDiasNaoUteisPeriodoAux;
							}
							
							periodoFerias.setFim( periodoFerias.getFim().plus(Period.days(1)) );
						}
					}																																									
				}					
			}
									

			Integer qtdeDiasParcelaFerias = DataUtils.getDiasPeriodo(parcelaFerias.getInicio(), parcelaFerias.getFim());

			listaMaxDiasPorPeriodo.add( qtdeDiasParcelaFerias  );

			if (listaMaxDiasPorPeriodo.size() == 1) {
				//seta o segundo
			
				Integer maxDiasSegundoPeriodo = 30 - listaMaxDiasPorPeriodo.get(0) - 5;
				
				ParcelaFeriasUtils.setQuantidadeMaxDias(this.parcelasFerias, 2, maxDiasSegundoPeriodo);
			}
			
			if (listaMaxDiasPorPeriodo.size() == 2) {
				//seta o terceiro

				Integer qtdeDias = 0;
				
				for (Integer i: listaMaxDiasPorPeriodo)
					qtdeDias += i; 
				
				Integer maxDiasTerceiroPeriodo = 30 - qtdeDias;
				
				ParcelaFeriasUtils.setQuantidadeMaxDias(this.parcelasFerias, 3, maxDiasTerceiroPeriodo);
			}

			if (parcelaFerias.getIndice().equals(3) && parcelaFerias.getMaxDias() > qtdeDiasParcelaFerias) {
				
				Integer diasRestantes = parcelaFerias.getMaxDias() - qtdeDiasParcelaFerias;
				DateTime novoFim = new DateTime(parcelaFerias.getFim());
				parcelaFerias.setFim(  novoFim.plus(Period.days(diasRestantes)).toDate() );
			}								
		}
		ordenaPorIndice();
		return this.parcelasFerias;
	}
	
	
	private void valida() throws Exception {
		
		if (this.ano == null)
			throw new Exception("Informe um ano válido em 1900 e 2100");
	}
	
	private void ordenaPorIndice() {
		
		Collections.sort(this.parcelasFerias, (d1, d2) ->{
			return d1.getInicio().before(d2.getInicio()) ? -1 : 1 ;
		});
		
		int i = 1;
		for (ParcelaFerias p: this.parcelasFerias) {
			p.setIndice(i);
			i++;
		}
	}
}
