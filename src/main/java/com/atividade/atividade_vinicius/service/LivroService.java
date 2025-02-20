package com.atividade.atividade_vinicius.service;

import com.atividade.atividade_vinicius.entity.Livro;
import com.atividade.atividade_vinicius.entity.Usuario;
import com.atividade.atividade_vinicius.repository.LivroRepository;
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
public class LivroService {
    private LivroRepository repository;

    /**
     * Adiciona um novo Livro.
     *
     * @param livro Livro a ser adicionado.
     * @return O Livro recem-criado.
     * @throws RuntimeException Se o livro não tiver todos os campos obrigatórios preenchidos
     *                          ou se houver um erro interno ao salvar o livro.
     * @see LivroRepository#save(Object)
     */
    public Livro adiconarLivro(Livro livro) {
        try {
            if (livro.getAutor() == null || livro.getIsbn() == null || livro.getBiblioteca() == null || livro.getTitulo() == null || livro.getQuantidadeExemplares() == null) {
                throw new RuntimeException("Todos os campos são obrigatórios");
            }
            return repository.save(livro);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar o livro: ", e);
        }
    }

    /**
     * Edita um livro.
     *
     * @param id    ID do livro a ser editado
     * @param livro Livro editado
     * @return Livro editado com sucesso (200) ou erro (400)
     * @throws Exception
     * @see LivroRepository#save(Object)
     */
    public Livro editarLivro(Integer id, Livro livro) {
        try {
            Livro livroEditado = repository.findById(id).orElseThrow();
            return repository.save(livroEditado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar o livro: ", e);
        }
    }

    /**
     * Busca um livro.
     *
     * @param id ID do livro a ser buscado
     * @return Livro encontrado com sucesso (200) ou erro (400)
     * @throws Exception
     * @see LivroRepository#findById(Object)
     */
    public Livro buscarLivro(Integer id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o livro: ", e);
        }
    }

    /**
     * Busca todos os livros.
     *
     * @return Todos os livros encontrados com sucesso (200) ou erro (400)
     * @throws Exception
     * @see LivroRepository#findAll()
     */
    public List<Livro> buscarLivros() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar os livros: ", e);
        }
    }

    /**
     * Exclui um livro.
     *
     * @param id ID do livro a ser excluido
     * @throws Exception
     * @see LivroRepository#deleteById(Object)
     */
    public void excluirLivro(Integer id) {
        try {
            Livro livroDeletado = repository.findById(id).orElseThrow();
            repository.delete(livroDeletado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir o livro: ", e);
        }
    }
}
