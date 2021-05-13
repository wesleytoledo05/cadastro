
package com.anuncio.cadastro.entidades;

import javax.persistence.Transient;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "relatorio")
public class Relatorio
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    private double total_investido;
    private Double qtd_max_visualizacao;
    private Double qtd_max_clique;
    private Double qtd_max_compartilhamento;
    @Transient
    private double qtd_vis_anuncio_original;
    @Transient
    private double qtd_clique_anuncio_original;
    @Transient
    private double qtd_compartilhamento_original;
    @Transient
    private double qtd_novas_visualizacoes;
    @Transient
    private double qtd_seq_compartilhamento;
    @Transient
    private double qtd_visu_por_anuncio;
    
    public Double getQtd_max_visualizacao() {
        return this.qtd_max_visualizacao;
    }
    
    public void setQtd_max_visualizacao(Double qtd_max_visualizacao) {
        this.qtd_max_visualizacao = qtd_max_visualizacao;
    }
    
    public Double getQtd_max_clique() {
        return this.qtd_max_clique;
    }
    
    public void setQtd_max_clique(Double qtd_max_clique) {
        this.qtd_max_clique = qtd_max_clique;
    }
    
    public Double getQtd_max_compartilhamento() {
        return this.qtd_max_compartilhamento;
    }
    
    public void setQtd_max_compartilhamento(Double qtd_max_compartilhamento) {
        this.qtd_max_compartilhamento = qtd_max_compartilhamento;
    }
    
    public double getQtd_vis_anuncio_original() {
        return this.qtd_vis_anuncio_original = regraDeTres(1.0, 30.0, this.getTotal_investido());
    }
    
    public void setQtd_vis_anuncio_original(double qtd_vis_anuncio_original) {
        this.qtd_vis_anuncio_original = qtd_vis_anuncio_original;
    }
    
    public double getQtd_clique_anuncio_original() {
        return this.qtd_clique_anuncio_original = regraDeTres(100.0, 12.0, this.getQtd_vis_anuncio_original());
    }
    
    public void setQtd_clique_anuncio_original(double qtd_clique_anuncio_original) {
        this.qtd_clique_anuncio_original = qtd_clique_anuncio_original;
    }
    
    public double getQtd_compartilhamento_original() {
        return this.qtd_compartilhamento_original = regraDeTres(20.0, 3.0, this.getQtd_clique_anuncio_original());
    }
    
    public void setQtd_compartilhamento_original(double qtd_compartilhamento_original) {
        this.qtd_compartilhamento_original = qtd_compartilhamento_original;
    }
    
    public double getQtd_novas_visualizacoes() {
        return this.qtd_novas_visualizacoes = regraDeTres(1.0, 40.0, this.getQtd_compartilhamento_original());
    }
    
    public void setQtd_novas_visualizacoes(double qtd_novas_visualizacoes) {
        this.qtd_novas_visualizacoes = qtd_novas_visualizacoes;
    }
    
    public double getQtd_seq_compartilhamento() {
        return this.qtd_seq_compartilhamento = regraDeTres(1.0, 4.0, this.getQtd_compartilhamento_original());
    }
    
    public void setQtd_seq_compartilhamento(double qtd_seq_compartilhamento) {
        this.qtd_seq_compartilhamento = qtd_seq_compartilhamento;
    }
    
    public double getQtd_visu_por_anuncio() {
        return this.qtd_visu_por_anuncio = regraDeTres(1.0, 40.0, this.getQtd_seq_compartilhamento());
    }
    
    public void setQtd_visu_por_anuncio(double qtd_visu_por_anuncio) {
        this.qtd_visu_por_anuncio = qtd_visu_por_anuncio;
    }
    
    public double getTotal_investido() {
        return this.total_investido;
    }
    
    public void setTotal_investido(double total_investido) {
        this.total_investido = total_investido;
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Double SomaMaxCliques() {
        return this.getQtd_clique_anuncio_original();
    }
    
    public Double SomaMaxCompartilhamento() {
        return this.getQtd_compartilhamento_original() + this.getQtd_seq_compartilhamento();
    }
    
    public Double SomaMaxVisualizacao() {
        return this.qtd_max_visualizacao = this.getQtd_vis_anuncio_original() + this.getQtd_novas_visualizacoes() + this.getQtd_visu_por_anuncio();
    }
    
    private static double regraDeTres(double x, double y, double valorReferencia) {
        return valorReferencia / x * y;
    }
}