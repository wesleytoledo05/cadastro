package com.anuncio.cadastro.services;

import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import com.anuncio.cadastro.entidades.Relatorio;
import com.anuncio.cadastro.entidades.Anuncio;
import com.anuncio.cadastro.repositorios.RelatorioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import com.anuncio.cadastro.repositorios.AnuncioRepositorio;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService
{
    @Autowired
    private AnuncioRepositorio anuncioRepo;
    @Autowired
    private RelatorioRepositorio relatorioRepo;
    
    public Anuncio postRelatorio(Anuncio anuncio) throws ParseException {
        anuncioRepo.save(anuncio);

        Relatorio relatorio = new Relatorio();
        relatorio.setTotal_investido(calculaTotalInvestido(anuncio.getData_inicio(), anuncio.getData_termino(), anuncio.getInvestimento_por_dia()));
        relatorio.setQtd_max_clique(relatorio.SomaMaxCliques());
        relatorio.setQtd_max_visualizacao(relatorio.SomaMaxVisualizacao());
        relatorio.setQtd_max_compartilhamento(relatorio.SomaMaxCompartilhamento());
        anuncio.setRelatorio(relatorio);

        relatorioRepo.save(relatorio);
       
        return anuncio;
    }
    
    public static double calculaTotalInvestido(Date getdata_inicio, Date getdata_termino, Double investimento_por_dia) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data_inicio = sdf.parse(sdf.format(getdata_inicio));
        Date data_termino = sdf.parse(sdf.format(getdata_termino));
        long diffEmMil = Math.abs(data_termino.getTime() - data_inicio.getTime());
        long diff = TimeUnit.DAYS.convert(diffEmMil, TimeUnit.MILLISECONDS);
        return diff * investimento_por_dia;
    }
}