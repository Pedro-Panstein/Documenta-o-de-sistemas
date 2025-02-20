package com.atividade.atividade_vinicius.controller;

import com.atividade.atividade_vinicius.entity.Livro;
import com.atividade.atividade_vinicius.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
@RequestMapping("/livro")
public class LivroController {

    private LivroService service;

    /**
     * Adiciona um novo livro.
     *
     * <p>Recebe a requisição de um novo livro e envia para a service que gerencia as regras de negócios e aciona a repository que adiciona o livro ao banco de dados.
     *
     * @param livro Livro a ser adicionado
     * @return Livro adicionado com sucesso (201) ou erro (400)
     * @throws Exception
     * @see LivroService#adiconarLivro(Livro)
     */

    @Operation(summary = "Adiciona um novo Livro", description = "Recebe a requisição de um novo Livro e envia para a service que gerencia as regras de negócios e aciona a repository que adiciona o Livro ao banco de dados")
    @ApiResponse(responseCode = "201", description = "Livro adicionado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao adicionar o Livro")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao adicionar o Livro")
    @PostMapping("/adicionar")
    public ResponseEntity<Livro> adicionarLivro(@RequestBody Livro livro) {
        try {
            Livro novoLivro = service.adiconarLivro(livro);
            return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Edita um livro.
     *
     * <p>Recebe a requisição de um livro editado e envia para a service que gerencia as regras de neg cios e aciona a repository que edita o livro no banco de dados.
     *
     * @param id    ID do livro a ser editado
     * @param livro Livro editado
     * @return Livro editado com sucesso (200) ou erro (400)
     * @throws Exception
     * @see LivroService#editarLivro(Integer, Livro)
     */
    @Operation(summary = "Atualiza um Livro", description = "Recebe a requisição de um Livro editado e envia para a service que gerencia as regras de negócios e aciona a repository para editar o Livro e salvar no banco de dados")
    @ApiResponse(responseCode = "200", description = "Livro editado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao editar o Livro")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao editar o Livro")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Livro> editarLivro(@PathVariable Integer id, @RequestBody Livro livro) {
        try {
            Livro livroEditado = service.editarLivro(id, livro);
            return new ResponseEntity<>(livroEditado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Busca um livro.
     *
     * <p>Recebe a requisição de um livro pelo seu ID e envia para a service que gerencia as regras de neg cios e aciona a repository que busca o livro no banco de dados.
     *
     * @param id ID do livro a ser buscado
     * @return Livro encontrado com sucesso (200) ou erro (400)
     * @throws Exception
     * @see LivroService#buscarLivro(Integer)
     */
    @Operation(summary = "Busca um Livro pelo ID", description = "Recebe a requisição de uma busca de um Livro por ID e envia para a service o id que foi passado na requisição, a service gerencia as regras de negócios e aciona a repository que busca o Livro no banco de dados")
    @ApiResponse(responseCode = "200", description = "Livro foi encontrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao buscar o Livro")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao buscar o Livro")
    @GetMapping("/listar/{id}")
    public ResponseEntity<Livro> buscarLivro(@PathVariable Integer id) {
        try {
            Livro livro = service.buscarLivro(id);
            return new ResponseEntity<>(livro, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Busca todos os livros.
     *
     * <p>Recebe a requisi o de uma busca por todos os livros e envia para a service que gerencia as regras de neg cios e aciona a repository que busca todos os livros presentes no banco de dados.
     *
     * @return Todos os livros encontrados com sucesso (200) ou erro (400)
     * @throws Exception
     * @see LivroService#buscarLivros()
     */
    @Operation(summary = "Busca todos os Livros", description = "Recebe a requisição de uma busca por todos os Livros, que envia a requisição para a service que gerencia as regras de negócios e aciona a repository que busca todos os Livros presentes no banco de dados")
    @ApiResponse(responseCode = "200", description = "Os Livros foram encontrados com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao buscar os Livros")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao buscar os Livros")
    @GetMapping("/listarTodos")
    public ResponseEntity<List<Livro>> buscarLivros() {
        try {
            List<Livro> livros = service.buscarLivros();
            return new ResponseEntity<>(livros, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Exclui um livro.
     *
     * <p>Recebe a requisi o de exclus o de um livro pelo seu ID e envia para a service que gerencia as regras de neg cios e aciona a repository que remove o livro no banco de dados.
     *
     * @param id ID do livro a ser exclu do
     * @return Livro exclu do com sucesso (200) ou erro (400)
     * @throws Exception
     * @see LivroService#excluirLivro(Integer)
     */
    @Operation(summary = "Deleta um Livro", description = "Recebe a requisição de uma remoção de um Livro por ID e envia para a service o id que foi passado na requisição, a service gerencia as regras de negócios e aciona a repository que deleta o Livro do banco de dados")
    @ApiResponse(responseCode = "200", description = "O Livro foi deletado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao deletar o Livro")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao deletar o Livro")
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirLivro(@PathVariable Integer id) {
        try {
            service.excluirLivro(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}