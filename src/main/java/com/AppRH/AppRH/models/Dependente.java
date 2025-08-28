package com.AppRH.AppRH.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cpfDependente;

    @NotEmpty(message = "O nome do dependente não pode ser vazio")
    private String nomeDependente;

    private LocalDate dataNascimentoDependente;

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

    public LocalDate getDataNascimentoDependente() {
        return dataNascimentoDependente;
    }

    public void setDataNascimentoDependente(LocalDate dataNascimentoDependente) {
        this.dataNascimentoDependente = dataNascimentoDependente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
