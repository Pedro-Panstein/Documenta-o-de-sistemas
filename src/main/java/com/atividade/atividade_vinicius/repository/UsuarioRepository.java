package com.atividade.atividade_vinicius.repository;

import com.atividade.atividade_vinicius.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
