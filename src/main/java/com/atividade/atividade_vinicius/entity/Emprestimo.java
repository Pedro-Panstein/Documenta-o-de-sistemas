package com.atividade.atividade_vinicius.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Entidade que representa um emprestimo de um usuario em uma biblioteca.
 *
 * @author Pedro Henrique Panstein
 * @version 1.0
 * @since 2025-02-13
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emprestimo")
public class Emprestimo {

    /**
     * Identificador do emprestimo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Usuario que realizou o emprestimo.
     */
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    /**
     * Livro que foi emprestado.
     */
    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    /**
     * Data em que o emprestimo foi realizado.
     */
    private LocalDate dataEmprestimo;

    /**
     * Data em que o emprestimo deve ser devolvido.
     */
    private LocalDate dataDevolucao;
}