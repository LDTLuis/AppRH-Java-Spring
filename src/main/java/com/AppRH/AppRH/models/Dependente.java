package com.AppRH.AppRH.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Dependente {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String cpfDependente;

    @NotEmpty
    private String nomeDependente;

    @NotEmpty
    private String dataNascimentoDependente;

    @ManyToOne
    private Funcionario funcionario;

    public String getCpfDependente() {
        return cpfDependente;
    }

    public void setCpfDependente(String cpfDependente) {
        this.cpfDependente = cpfDependente;
    }

    public String getNomeDependente() {
        return nomeDependente;
    }

    public void setNomeDependente(String nomeDependente) {
        this.nomeDependente = nomeDependente;
    }

    public String getDataNascimentoDependente() {
        return dataNascimentoDependente;
    }

    public void setDataNascimentoDependente(String dataNascimentoDependente) {
        this.dataNascimentoDependente = dataNascimentoDependente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
