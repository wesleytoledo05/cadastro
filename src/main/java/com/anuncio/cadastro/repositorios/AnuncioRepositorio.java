
package com.anuncio.cadastro.repositorios;

import com.anuncio.cadastro.entidades.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncioRepositorio extends JpaRepository<Anuncio, Long>
{
    Anuncio findByRelatorioId(Long id);
}