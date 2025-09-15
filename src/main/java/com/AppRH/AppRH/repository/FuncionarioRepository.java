package com.AppRH.AppRH.repository;

import com.AppRH.AppRH.models.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FuncionarioRepository extends CrudRepository<Funcionario, String> {

    Funcionario findById(long id);

    // Busca
    @Query(value = "select x from Funcionario x where x.nomeFuncionario like %?1%")
    List<Funcionario> finByNomesFuncionarios(String nomeFuncionario);

}
