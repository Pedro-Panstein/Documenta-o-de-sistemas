package com.atividade.atividade_vinicius.service;

import com.atividade.atividade_vinicius.entity.Emprestimo;
import com.atividade.atividade_vinicius.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmprestimoService {
    private EmprestimoRepository repository;

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

    public Emprestimo editarEmprestimo(Integer id, Emprestimo emprestimo) {
        try {
            Emprestimo emprestimoEditado = repository.findById(id).orElseThrow();
            return repository.save(emprestimoEditado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar o emprestimo: ", e);
        }
    }

    public Emprestimo buscarEmprestimo(Integer id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o emprestimo: ", e);
        }
    }

    public List<Emprestimo> buscarEmprestimos() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar os emprestimos: ", e);
        }
    }

    public void excluirEmprestimo(Integer id) {
        try {
            Emprestimo emprestimoDeletada = repository.findById(id).orElseThrow();
            repository.delete(emprestimoDeletada);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir o emprestimo: ", e);
        }
    }
}
