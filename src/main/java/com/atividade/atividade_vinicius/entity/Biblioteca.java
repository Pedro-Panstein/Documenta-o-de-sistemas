package com.atividade.atividade_vinicius.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Entidade que representa uma biblioteca.
 *
 * @author Pedro Henrique Panstein
 * @version 1.0
 * @since 2025-02-13
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "biblioteca")
public class Biblioteca {

    /**
     * Identificador unico da biblioteca.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nome da biblioteca.
     */
    private String nome;

    /**
     * Endere o da biblioteca.
     */
    private String endereco;
}