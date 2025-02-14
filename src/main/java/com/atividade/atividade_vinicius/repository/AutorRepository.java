package com.atividade.atividade_vinicius.repository;

import com.atividade.atividade_vinicius.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
