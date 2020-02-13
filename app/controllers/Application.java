package controllers;

import models.br.com.gilpederiva.facade.FeriasFacade;
import models.br.com.gilpederiva.pojo.ParcelaFerias;
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.Util;

import java.util.List;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void resultado(@Required(message = "Ano é requerido") Integer ano){


        if (validation.hasErrors()){
            retornaParaIndice();
        }

        try{
            FeriasFacade feriasFacade = new FeriasFacade(ano);
            List<ParcelaFerias> parcelasFerias = feriasFacade.geraParcelasFerias();

            render(parcelasFerias);
        }catch (Exception e){
            e.printStackTrace();
            validation.addError("", "Erro ao gerar o Parcela de Férias. Causa: "+e.getMessage());
            retornaParaIndice();
        }
    }

    @Util
    public static void retornaParaIndice(){
        validation.keep();
        params.flash();
        index();
    }

}