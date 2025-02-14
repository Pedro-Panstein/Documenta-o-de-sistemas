package com.atividade.atividade_vinicius.service;

import com.atividade.atividade_vinicius.entity.Autor;
import com.atividade.atividade_vinicius.repository.AutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutorService {
    private AutorRepository repository;

    public Autor adiconarAutor(Autor autor) {
        try {
            if (autor.getNome() == null) {
                throw new RuntimeException("Todos os campos são obrigatórios");
            }
            return repository.save(autor);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar o autor: ", e);
        }
    }

    public Autor editarAutor(Integer id, Autor autor) {
        try {
            Autor autorEditado = repository.findById(id).orElseThrow();
            return repository.save(autorEditado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar o autor: ", e);
        }
    }

    public Autor buscarAutor(Integer id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o autor: ", e);
        }
    }

    public List<Autor> buscarAutors() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar os autores: ", e);
        }
    }

    public void excluirAutor(Integer id) {
        try {
            Autor autorDeletado = repository.findById(id).orElseThrow();
            repository.delete(autorDeletado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir o autor: ", e);
        }
    }
}
