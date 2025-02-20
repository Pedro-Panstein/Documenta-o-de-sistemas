package com.atividade.atividade_vinicius.repository;

import com.atividade.atividade_vinicius.entity.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface responsavel por criar e gerenciar as operacoes de banco de dados para a entidade Biblioteca.
 *
 * @author Pedro Henrique Panstein
 * @version 1.0
 * @since 2025-02-13
 *
 * @see Biblioteca
 */
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer> {
}
