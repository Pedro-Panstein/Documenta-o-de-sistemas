package com.atividade.atividade_vinicius.controller;

import com.atividade.atividade_vinicius.entity.Emprestimo;
import com.atividade.atividade_vinicius.entity.Emprestimo;
import com.atividade.atividade_vinicius.service.EmprestimoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/emprestimo")
public class EmprestimoController {
    private EmprestimoService service;

    @PostMapping("/adicionar")
    public ResponseEntity<Emprestimo> adicionarEmprestimo(@RequestBody Emprestimo emprestimo) {
        try {
            Emprestimo novoEmprestimo = service.adiconarEmprestimo(emprestimo);
            return new ResponseEntity<>(novoEmprestimo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Emprestimo> editarEmprestimo(@PathVariable Integer id, @RequestBody Emprestimo emprestimo) {
        try {
            Emprestimo emprestimoEditado = service.editarEmprestimo(id, emprestimo);
            return new ResponseEntity<>(emprestimoEditado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Emprestimo> buscarEmprestimo(@PathVariable Integer id) {
        try {
            Emprestimo emprestimo = service.buscarEmprestimo(id);
            return new ResponseEntity<>(emprestimo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Emprestimo>> buscarEmprestimos() {
        try {
            List<Emprestimo> emprestimos = service.buscarEmprestimos();
            return new ResponseEntity<>(emprestimos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirEmprestimo(@PathVariable Integer id) {
        try {
            service.excluirEmprestimo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
