package com.atividade.atividade_vinicius.service;

import com.atividade.atividade_vinicius.entity.Autor;
import com.atividade.atividade_vinicius.repository.AutorRepository;
import com.atividade.atividade_vinicius.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pedro Henrique Panstein
 * @version 1.0
 * @since 2025-02-13
 */

@Service
@AllArgsConstructor
public class AutorService {
    private AutorRepository repository;

    /**
     * Adiciona um novo Autor.
     *
     * @param autor Autor a ser adicionado.
     * @return O Autor recem-criado.
     * @throws RuntimeException Se o autor não tiver todos os campos obrigatórios preenchidos
     *                          ou se houver um erro interno ao salvar o autor.
     * @see AutorRepository#save(Object)
     */
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

    /**
     * Edita um Autor.
     *
     * @param id    ID do Autor a ser editado
     * @param autor Autor a ser editado
     * @return Autor editado com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see AutorRepository#save(Object)
     */
    public Autor editarAutor(Integer id, Autor autor) {
        try {
            Autor autorEditado = repository.findById(id).orElseThrow();
            return repository.save(autorEditado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar o autor: ", e);
        }
    }

    /**
     * Busca um Autor.
     *
     * @param id ID do Autor a ser buscado
     * @return Autor encontrado com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see AutorRepository#findById(Object)
     */
    public Autor buscarAutor(Integer id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o autor: ", e);
        }
    }

    /**
     * Busca todos os Autores.
     *
     * @return Todos os Autores encontrados com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see AutorRepository#findAll()
     */
    public List<Autor> buscarAutors() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar os autores: ", e);
        }
    }

    /**
     * Exclui um Autor.
     *
     * @param id ID do Autor a ser excluido
     * @Throws Exception
     * @see AutorRepository#deleteById(Object)
     */
    public void excluirAutor(Integer id) {
        try {
            Autor autorDeletado = repository.findById(id).orElseThrow();
            repository.delete(autorDeletado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir o autor: ", e);
        }
    }
}
