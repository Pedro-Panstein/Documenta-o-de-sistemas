package com.atividade.atividade_vinicius.service;

import com.atividade.atividade_vinicius.entity.Biblioteca;
import com.atividade.atividade_vinicius.repository.BibliotecaRepository;
import com.atividade.atividade_vinicius.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pedro Henrique Panstein
 * @version 1.0
 * @since 2025-02-13
 */

@Service
@AllArgsConstructor
public class BibliotecaService {

    /**
     * Adiciona uma nova Biblioteca.
     *
     * @param biblioteca Biblioteca a ser adicionada.
     * @return O Biblioteca recem-criado.
     * @throws RuntimeException Se a bilioteca não tiver todos os campos obrigatórios preenchidos
     * ou se houver um erro interno ao salvar a biblioteca.
     * @see BibliotecaRepository#save(Object)
     */
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

    /**
     * Edita uma Biblioteca.
     *
     * @param id         ID da Biblioteca a ser editada
     * @param biblioteca Biblioteca a ser editada
     * @return Biblioteca editada com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see BibliotecaRepository#save(Object)
     */
    public Biblioteca editarBiblioteca(Integer id, Biblioteca biblioteca) {
        try {
            Biblioteca bibliotecaEditado = repository.findById(id).orElseThrow();
            return repository.save(bibliotecaEditado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar a biblioteca: ", e);
        }
    }


    /**
     * Busca uma Biblioteca.
     *
     * @param id ID da Biblioteca a ser buscada
     * @return Biblioteca encontrado com sucesso (200) ou erro (400)
     * @throws RuntimeException Se a Biblioteca nao for encontrada ou se houver um erro interno ao buscar a Biblioteca
     * @see BibliotecaRepository#findById(Object)
     */
    public Biblioteca buscarBiblioteca(Integer id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar a biblioteca: ", e);
        }
    }

    /**
     * Busca todas as Bibliotecas.
     *
     * @return Todas as Bibliotecas encontradas com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see BibliotecaRepository#findAll()
     */
    public List<Biblioteca> buscarBibliotecas() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar as bibliotecas: ", e);
        }
    }

    /**
     * Exclui uma Biblioteca.
     *
     * @param id ID da Biblioteca a ser excluida
     * @Throws Exception
     * @see BibliotecaRepository#deleteById(Object)
     */
    public void excluirBiblioteca(Integer id) {
        try {
            Biblioteca bibliotecaDeletada = repository.findById(id).orElseThrow();
            repository.delete(bibliotecaDeletada);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir a biblioteca: ", e);
        }
    }
}
