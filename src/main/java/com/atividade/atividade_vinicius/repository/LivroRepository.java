package com.atividade.atividade_vinicius.repository;

import com.atividade.atividade_vinicius.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
