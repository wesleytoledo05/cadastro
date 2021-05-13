
package com.anuncio.cadastro.entidades;

import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "anuncio")
public class Anuncio
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    private String nome_anuncio;
    private String cliente;
    public Date data_inicio;
    public Date data_termino;
    private double investimento_por_dia;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relatorio", nullable = true)
    private Relatorio relatorio;
    
    public Relatorio getRelatorio() {
        return this.relatorio;
    }
    
    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome_anuncio() {
        return this.nome_anuncio;
    }
    
    public void setNome_anuncio(String nome_anuncio) {
        this.nome_anuncio = nome_anuncio;
    }
    
    public String getCliente() {
        return this.cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public Date getData_inicio() {
        return this.data_inicio;
    }
    
    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }
    
    public Date getData_termino() {
        return this.data_termino;
    }
    
    public void setData_termino(Date data_termino) {
        this.data_termino = data_termino;
    }
    
    public double getInvestimento_por_dia() {
        return this.investimento_por_dia;
    }
    
    public void setInvestimento_por_dia(double investimento_por_dia) {
        this.investimento_por_dia = investimento_por_dia;
    }    
}