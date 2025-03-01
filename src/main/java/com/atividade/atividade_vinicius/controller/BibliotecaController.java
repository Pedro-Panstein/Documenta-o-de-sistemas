package com.atividade.atividade_vinicius.controller;

import com.atividade.atividade_vinicius.entity.Biblioteca;
import com.atividade.atividade_vinicius.entity.Emprestimo;
import com.atividade.atividade_vinicius.service.BibliotecaService;
import com.atividade.atividade_vinicius.service.EmprestimoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Pedro Henrique Panstein
 * @version 1.0
 * @since 2025-02-13
 */

@RestController
@AllArgsConstructor
@RequestMapping("/biblioteca")
public class BibliotecaController {
    private BibliotecaService service;

    /**
     * Adiciona uma novoa Biblioteca.
     *
     * <p>Recebe a requisição de uma nova biblioteca e envia para a service.
     *
     * @param biblioteca Biblioteca a ser adicionada
     * @return Biblioteca adicionada com sucesso (201) ou erro (400 ou 500)
     * @Throws Exception
     * @see BibliotecaService#adiconarBiblioteca(Biblioteca)
     */
    @Tag(name = "Biblioteca", description = "Operações relacionadas a Biblioteca")
    @Operation(summary = "Adiciona um novo Biblioteca", description = "Recebe a requisição de um novo Biblioteca e envia para a service que gerencia as regras de negócios e aciona a repository que adiciona o Biblioteca ao banco de dados")
    @ApiResponse(responseCode = "201", description = "Biblioteca adicionado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao adicionar o Biblioteca")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao adicionar o Biblioteca")
    @PostMapping("/adicionar")
    public ResponseEntity<Biblioteca> adicionarBiblioteca(@RequestBody Biblioteca biblioteca) {
        try {
            Biblioteca novaBiblioteca = service.adiconarBiblioteca(biblioteca);
            return new ResponseEntity<>(novaBiblioteca, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Edita uma Biblioteca.
     *
     * <p>Recebe a requisição de uma Biblioteca editada e envia para a service.
     *
     * @param id         ID da Biblioteca a ser editada
     * @param biblioteca Biblioteca a ser editada
     * @return Emprestimo editado com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see BibliotecaService#editarBiblioteca(Integer, Biblioteca)
     */
    @Tag(name = "Biblioteca", description = "Operações relacionadas a Biblioteca")
    @Operation(summary = "Atualiza um Biblioteca", description = "Recebe a requisição de um Biblioteca editado e envia para a service que gerencia as regras de negócios e aciona a repository para editar o Biblioteca e salvar no banco de dados")
    @ApiResponse(responseCode = "200", description = "Biblioteca editado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao editar o Biblioteca")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao editar o Biblioteca")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Biblioteca> editarBiblioteca(@PathVariable Integer id, @RequestBody Biblioteca biblioteca) {
        try {
            Biblioteca bibliotecaEditado = service.editarBiblioteca(id, biblioteca);
            return new ResponseEntity<>(bibliotecaEditado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Busca uma Biblioteca.
     *
     * <p>Recebe a requisição de uma Biblioteca pelo seu ID e envia para a service.
     *
     * @param id ID da Biblioteca a ser buscada
     * @return Biblioteca encontrado com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see BibliotecaService#buscarBiblioteca(Integer)
     */
    @Tag(name = "Biblioteca", description = "Operações relacionadas a Biblioteca")
    @Operation(summary = "Busca uma Biblioteca pelo ID", description = "Recebe a requisição de uma busca de uma Biblioteca por ID e envia para a service o id que foi passado na requisição, a service gerencia as regras de negócios e aciona a repository que busca a Biblioteca no banco de dados")
    @ApiResponse(responseCode = "200", description = "Biblioteca foi encontrada com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao buscar a Biblioteca")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao buscar a Biblioteca")
    @GetMapping("/listar/{id}")
    public ResponseEntity<Biblioteca> buscarBiblioteca(@PathVariable Integer id) {
        try {
            Biblioteca biblioteca = service.buscarBiblioteca(id);
            return new ResponseEntity<>(biblioteca, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Busca todas as Bibliotecas.
     *
     * <p>Recebe a requisição de uma busca por todas as Bibliotecas e envia para a service.
     *
     * @return Todas as Bibliotecas encontradas com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see BibliotecaService#buscarBibliotecas()
     */
    @Tag(name = "Biblioteca", description = "Operações relacionadas a Biblioteca")
    @Operation(summary = "Busca todas as Bibliotecas", description = "Recebe a requisição de uma busca por todos as Bibliotecas, que envia a requisição para a service que gerencia as regras de negócios e aciona a repository que busca todos as Bibliotecas presentes no banco de dados")
    @ApiResponse(responseCode = "200", description = "Os Bibliotecas foram encontrados com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao buscar as Bibliotecas")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao buscar as Bibliotecas")
    @GetMapping("/listarTodos")
    public ResponseEntity<List<Biblioteca>> buscarBibliotecas() {
        try {
            List<Biblioteca> bibliotecas = service.buscarBibliotecas();
            return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Deleta uma Biblioteca.
     *
     * <p>Recebe a requisição de uma remoção de uma Biblioteca por ID e envia para a service o id que foi passado na requisição.
     *
     * @param id ID da Biblioteca a ser deletada
     * @return Biblioteca deletada com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see BibliotecaService#excluirBiblioteca(Integer)
     */
    @Tag(name = "Biblioteca", description = "Operações relacionadas a Biblioteca")
    @Operation(summary = "Deleta uma Biblioteca", description = "Recebe a requisição de uma remoção de uma Biblioteca por ID e envia para a service o id que foi passado na requisição, a service gerencia as regras de negócios e aciona a repository que deleta a Biblioteca do banco de dados")
    @ApiResponse(responseCode = "200", description = "A Biblioteca foi deletado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao deletar a Biblioteca")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao deletar a Biblioteca")
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
