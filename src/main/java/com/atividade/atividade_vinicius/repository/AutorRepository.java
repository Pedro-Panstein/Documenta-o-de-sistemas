package com.atividade.atividade_vinicius.repository;

import com.atividade.atividade_vinicius.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface responsAvel por criar e gerenciar as operacoes de banco de dados para a entidade Autor.
 *
 * @author Pedro Henrique Panstein
 * @version 1.0
 * @see Autor
 * @since 2025-02-13
 */
public interface AutorRepository extends JpaRepository<Autor, Integer> {
}