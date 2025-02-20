package com.atividade.atividade_vinicius.repository;

import com.atividade.atividade_vinicius.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface responsavel por criar e gerenciar as operacoes de banco de dados para a entidade Emprestimo.
 *
 * @author Pedro Henrique Panstein
 * @version 1.0
 * @since 2025-02-13
 *
 * @see Emprestimo
 */
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
}
