package com.atividade.atividade_vinicius.controller;

import com.atividade.atividade_vinicius.entity.Biblioteca;
import com.atividade.atividade_vinicius.service.BibliotecaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/biblioteca")
public class BibliotecaController {
    private BibliotecaService service;

    @PostMapping("/adicionar")
    public ResponseEntity<Biblioteca> adicionarBiblioteca(@RequestBody Biblioteca biblioteca) {
        try {
            Biblioteca novaBiblioteca = service.adiconarBiblioteca(biblioteca);
            return new ResponseEntity<>(novaBiblioteca, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Biblioteca> editarBiblioteca(@PathVariable Integer id, @RequestBody Biblioteca biblioteca) {
        try {
            Biblioteca bibliotecaEditado = service.editarBiblioteca(id, biblioteca);
            return new ResponseEntity<>(bibliotecaEditado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Biblioteca> buscarBiblioteca(@PathVariable Integer id) {
        try {
            Biblioteca biblioteca = service.buscarBiblioteca(id);
            return new ResponseEntity<>(biblioteca, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Biblioteca>> buscarBibliotecas() {
        try {
            List<Biblioteca> bibliotecas = service.buscarBibliotecas();
            return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirBiblioteca(@PathVariable Integer id) {
        try {
            service.excluirBiblioteca(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
