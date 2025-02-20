package com.atividade.atividade_vinicius.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

/**
 * Entidade Livro que representa os detalhes de um livro no sistema.
 * <p>
 * Contém informações como título, ISBN, quantidade de exemplares,
 * associação com uma biblioteca e um autor.
 * </p>
 *
 * @author Pedro Henrique Panstein
 * @version 1.0
 * @since 2025-02-13
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Título do livro.
     */
    private String titulo;

    /**
     * ISBN do livro.
     */
    private String isbn;

    /**
     * Quantidade de exemplares disponíveis do livro.
     */
    private Integer quantidadeExemplares;

    /**
     * Biblioteca a qual o livro pertence.
     */
    @ManyToOne
    @JoinColumn(name = "biblioteca_id", nullable = false)
    private Biblioteca biblioteca;

    /**
     * Autor do livro.
     */
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;
}