package com.atividade.atividade_vinicius.service;

import com.atividade.atividade_vinicius.entity.Biblioteca;
import com.atividade.atividade_vinicius.repository.BibliotecaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BibliotecaService {
    private BibliotecaRepository repository;

    public Biblioteca adiconarBiblioteca(Biblioteca biblioteca) {
        try {
            if (biblioteca.getNome() == null || biblioteca.getEndereco() == null) {
                throw new RuntimeException("Todos os campos são obrigatórios");
            }
            return repository.save(biblioteca);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar a biblioteca: ", e);
        }
    }

    public Biblioteca editarBiblioteca(Integer id, Biblioteca biblioteca) {
        try {
            Biblioteca bibliotecaEditado = repository.findById(id).orElseThrow();
            return repository.save(bibliotecaEditado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar a biblioteca: ", e);
        }
    }

    public Biblioteca buscarBiblioteca(Integer id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar a biblioteca: ", e);
        }
    }

    public List<Biblioteca> buscarBibliotecas() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar as bibliotecas: ", e);
        }
    }

    public void excluirBiblioteca(Integer id) {
        try {
            Biblioteca bibliotecaDeletada = repository.findById(id).orElseThrow();
            repository.delete(bibliotecaDeletada);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir a biblioteca: ", e);
        }
    }
}
