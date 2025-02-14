package com.atividade.atividade_vinicius.repository;

import com.atividade.atividade_vinicius.entity.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer> {
}
