package com.atividade.atividade_vinicius.controller;

import com.atividade.atividade_vinicius.entity.Autor;
import com.atividade.atividade_vinicius.service.AutorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/autor")
public class AutorController {
    private AutorService service;

    @PostMapping("/adicionar")
    public ResponseEntity<Autor> adicionarAutor(@RequestBody Autor autor) {
        try {
            Autor novoAutor = service.adiconarAutor(autor);
            return new ResponseEntity<>(novoAutor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Autor> editarAutor(@PathVariable Integer id, @RequestBody Autor autor) {
        try {
            Autor autorEditado = service.editarAutor(id, autor);
            return new ResponseEntity<>(autorEditado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Autor> buscarAutor(@PathVariable Integer id) {
        try {
            Autor autor = service.buscarAutor(id);
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Autor>> buscarAutors() {
        try {
            List<Autor> autores = service.buscarAutors();
            return new ResponseEntity<>(autores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirAutor(@PathVariable Integer id) {
        try {
            service.excluirAutor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
