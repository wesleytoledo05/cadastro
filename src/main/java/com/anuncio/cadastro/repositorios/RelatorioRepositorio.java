package com.anuncio.cadastro.repositorios;

import com.anuncio.cadastro.entidades.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatorioRepositorio extends JpaRepository<Relatorio, Long>
{
}