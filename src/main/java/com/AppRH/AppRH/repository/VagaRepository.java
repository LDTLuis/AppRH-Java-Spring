package com.AppRH.AppRH.repository;

import com.AppRH.AppRH.models.Vaga;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VagaRepository extends CrudRepository<Vaga, String> {

    Vaga findByCodigo(long codigo);

    List<Vaga> findByNome(String nome);

    // Busca
    @Query(value = "select x from Vaga x where x.nome like %?1%")
    List<Vaga> finByVagas(String nome);

}
