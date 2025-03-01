package com.atividade.atividade_vinicius.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Entidade que representa um Usuario.
 *
 * @author Pedro Henrique Panstein
 * @version 1.0
 * @since 2025-02-13
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

    /**
     * O identificador do Usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * O nome do Usuario.
     */
    private String nome;

    /**
     * O e-mail do Usuario.
     */
    private String email;

    /**
     * O telefone do Usua io.
     */
    private String telefone;

    /**
     * Lista de emprestimos do Usuario.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    private List<Emprestimo> emprestimos;
}