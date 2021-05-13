package com.anuncio.cadastro.calculadora;

import java.util.Scanner;

public class Calculadora
{
    public static Scanner entrada;
    
    public static void main(final String[] args) {
        Calculadora.entrada = new Scanner(System.in);
        System.out.print("Quantos reais deseja investir na campanha?  ");
        final double valorInvestido = Calculadora.entrada.nextDouble();
        final double valorVisAnuncioOriginal = regraDeTres(1.0, 30.0, valorInvestido);
        final double valorCliqueAnuncio = regraDeTres(100.0, 12.0, valorVisAnuncioOriginal);
        final double valorCompartilhamento = regraDeTres(20.0, 3.0, valorCliqueAnuncio);
        final double valornovasVisualizacoes = regraDeTres(1.0, 40.0, valorCompartilhamento);
        final double valorSeqCompart = regraDeTres(1.0, 4.0, valorCompartilhamento);
        final double valorVisuPorAnuncio = regraDeTres(1.0, 40.0, valorSeqCompart);
        final double valorSomaVisualizacoes = somaDasVisualizacoes(valorVisAnuncioOriginal, valornovasVisualizacoes, valorVisuPorAnuncio);
        System.out.println("A projecao aproximada da quantidade maxima de pessoas que visualizaram o mesmo anuncio e de: " + valorSomaVisualizacoes + " pessoas.");
    }
    
    public static double somaDasVisualizacoes(final double visualizaramAnuncioOriginal, final double novasVisu, final double visualizacaoPorAnuncioCompartilhado) {
        return visualizaramAnuncioOriginal + novasVisu + visualizacaoPorAnuncioCompartilhado;
    }
    
    public static double regraDeTres(final double x, final double y, final double valorReferencia) {
        return valorReferencia / x * y;
    }
}