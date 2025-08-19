package com.AppRH.AppRH.Repository;

import com.AppRH.AppRH.models.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, String> {

    Funcionario findById(long id);

    Funcionario findByNomeFuncionario(String nomeFuncionario);

}
