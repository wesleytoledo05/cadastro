
package com.anuncio.cadastro.repositorios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.anuncio.cadastro.entidades.Anuncio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface AnuncioRepositorio extends JpaRepository<Anuncio, Long>
{
    Optional<Anuncio> findByCliente(String cliente);
    
    @Query("SELECT a FROM Anuncio a WHERE a.data_inicio >= to_date(:data_inicio, 'YYYY/MM/DD') and a.data_termino <= to_date(:data_termino, 'YYYY/MM/DD')")
    Optional<List<Anuncio>> findByData(Date data_inicio, Date data_termino);
}