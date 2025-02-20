package com.atividade.atividade_vinicius.service;

import com.atividade.atividade_vinicius.entity.Emprestimo;
import com.atividade.atividade_vinicius.entity.Livro;
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
public class EmprestimoService {
    private EmprestimoRepository repository;

    /**
     * Adiciona um novo Emprestimo.
     *
     * @param emprestimo Emprestimo a ser adicionado.
     * @return O Emprestimo recem-criado.
     * @throws RuntimeException Se o emprestimo não tiver todos os campos obrigatórios preenchidos
     *                          ou se houver um erro interno ao salvar o emprestimo.
     * @see EmprestimoRepository#save(Object)
     */
    public Emprestimo adiconarEmprestimo(Emprestimo emprestimo) {
        try {
            if (emprestimo.getDataEmprestimo() == null || emprestimo.getDataDevolucao() == null) {
                throw new RuntimeException("Todos os campos são obrigatórios");
            }
            return repository.save(emprestimo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar o emprestimo: ", e);
        }
    }

    /**
     * Edita um Emprestimo.
     *
     * @param id         ID do Emprestimo a ser editado
     * @param emprestimo Emprestimo a ser editado
     * @return Emprestimo editado com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see EmprestimoRepository#save(Object)
     */
    public Emprestimo editarEmprestimo(Integer id, Emprestimo emprestimo) {
        try {
            Emprestimo emprestimoEditado = repository.findById(id).orElseThrow();
            return repository.save(emprestimoEditado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar o emprestimo: ", e);
        }
    }

    /**
     * Busca um Emprestimo.
     *
     * @param id ID do Emprestimo a ser buscado
     * @return Emprestimo encontrado com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see EmprestimoRepository#findById(Object)
     */
    public Emprestimo buscarEmprestimo(Integer id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o emprestimo: ", e);
        }
    }

    /**
     * Busca todos os Emprestimos.
     *
     * @return Todos os Emprestimos encontrados com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see EmprestimoRepository#findAll()
     */
    public List<Emprestimo> buscarEmprestimos() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar os emprestimos: ", e);
        }
    }

    /**
     * Exclui um Emprestimo.
     *
     * @param id ID do Emprestimo a ser excluido
     * @Throws Exception
     * @see EmprestimoRepository#deleteById(Object)
     */
    public void excluirEmprestimo(Integer id) {
        try {
            Emprestimo emprestimoDeletada = repository.findById(id).orElseThrow();
            repository.delete(emprestimoDeletada);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir o emprestimo: ", e);
        }
    }
}
