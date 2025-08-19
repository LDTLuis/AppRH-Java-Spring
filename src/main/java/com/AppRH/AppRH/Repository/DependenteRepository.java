package com.AppRH.AppRH.Repository;

import com.AppRH.AppRH.models.Dependente;
import com.AppRH.AppRH.models.Funcionario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DependenteRepository extends CrudRepository<Dependente, String> {

    Iterable<Dependente> findByFuncionario(Funcionario funcionario);

    Dependente findByCpfDependente(String cpfDependente);
    Dependente findById(long id);

    List<Dependente> findByNomeDependente(String nomeDependente);


}

