package com.atividade.atividade_vinicius.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entidade que representa um autor.
 *
 * @author Pedro Henrique Panstein
 * @version 1.0
 * @since 2025-02-13
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "autor")
public class Autor {
    /**
     * ID do autor. Gera-se automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Nome do autor.
     */
    private String nome;

    /**
     * Livros escritos pelo autor. Caso o autor seja excluIdo, seus livros tambem serao.
     */
    @OneToMany(mappedBy = "autor", cascade = CascadeType.REMOVE)
    private List<Livro> livros;
}
