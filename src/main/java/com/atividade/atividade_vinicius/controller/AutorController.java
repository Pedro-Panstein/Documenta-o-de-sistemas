package com.atividade.atividade_vinicius.controller;

import com.atividade.atividade_vinicius.entity.Autor;
import com.atividade.atividade_vinicius.entity.Usuario;
import com.atividade.atividade_vinicius.service.AutorService;
import com.atividade.atividade_vinicius.service.UsuarioService;
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
@RequestMapping("/autor")
public class AutorController {
    private AutorService service;

    /**
     * Adiciona um novo autor.
     *
     * <p>Recebe a requisição de um novo autor e envia para a service.
     *
     * @param autor Autor a ser adicionado
     * @return Autor adicionado com sucesso (201) ou erro (400 ou 500)
     * @Throws Exception
     * @see AutorService#adiconarAutor(Autor)
     */
    @Tag(name = "Livros", description = "Operações relacionadas a livros")
    @Operation(summary = "Adiciona um novo Autor", description = "Recebe a requisição de um novo Autor e envia para a service que gerencia as regras de negócios e aciona a repository que adiciona o Autor ao banco de dados")
    @ApiResponse(responseCode = "201", description = "Autor adicionado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao adicionar o Autor")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao adicionar o Autor")
    @PostMapping("/adicionar")
    public ResponseEntity<Autor> adicionarAutor(@RequestBody Autor autor) {
        try {
            Autor novoAutor = service.adiconarAutor(autor);
            return new ResponseEntity<>(novoAutor, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar o autor: ", e);
        }
    }

    /**
     * Atualiza um usuário.
     *
     * <p>Recebe a requisição de um usuário editado e envia para a service.
     *
     * @param id      ID do autor a ser editado
     * @param autor Autor editado
     * @return Autor editado com sucesso (200) ou erro (400 ou 500)
     * @throws Exception
     * @see AutorService#editarAutor(Integer, Autor)
     */
    @Tag(name = "Livros", description = "Operações relacionadas a livros")
    @Operation(summary = "Atualiza um Autor", description = "Recebe a requisição de um Autor editado e envia para a service que gerencia as regras de negócios e aciona a repository para editar o Autor e salvar no banco de dados")
    @ApiResponse(responseCode = "200", description = "Autor editado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao editar o Autor")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao editar o Autor")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Autor> editarAutor(@PathVariable Integer id, @RequestBody Autor autor) {
        try {
            Autor autorEditado = service.editarAutor(id, autor);
            return new ResponseEntity<>(autorEditado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Busca um autor pelo ID.
     *
     * <p>Recebe a requisição de uma busca de um autor pelo ID e envia para a service.
     *
     * @param id ID do autor a ser buscado
     * @return autor foi encontrado com sucesso (200) ou erro (400 ou 500)
     * @throws Exception
     * @see AutorService#buscarAutor(Integer)
     */
    @Tag(name = "Livros", description = "Operações relacionadas a livros")
    @Operation(summary = "Busca um Autor pelo ID", description = "Recebe a requisição de uma busca de um Autor por ID e envia para a service o id que foi passado na requisição, a service gerencia as regras de negócios e aciona a repository que busca o Autor no banco de dados")
    @ApiResponse(responseCode = "200", description = "Autor foi encontrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao buscar o Autor")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao buscar o Autor")
    @GetMapping("/listar/{id}")
    public ResponseEntity<Autor> buscarAutor(@PathVariable Integer id) {
        try {
            Autor autor = service.buscarAutor(id);
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Busca todos os autores.
     *
     * <p>Recebe a requisição de uma busca de todos os autores e envia para a service.
     *
     * @return Todos os autores encontrados com sucesso (200) ou erro (400 ou 500)
     * @throws Exception
     * @see AutorService#buscarAutors()
     */
    @Tag(name = "Livros", description = "Operações relacionadas a livros")
    @Operation(summary = "Busca todos os Autores", description = "Recebe a requisição de uma busca por todos as Bibliotecas, que envia a requisição para a service que gerencia as regras de negócios e aciona a repository que busca todos os Autores presentes no banco de dados")
    @ApiResponse(responseCode = "200", description = "Os Autores foram encontrados com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao buscar os Autores")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao buscar os Autores")
    @GetMapping("/listarTodos")
    public ResponseEntity<List<Autor>> buscarAutors() {
        try {
            List<Autor> autores = service.buscarAutors();
            return new ResponseEntity<>(autores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Deleta um autor.
     *
     * <p>Recebe a requisição de uma remoção de um autor por ID e envia para a service o id que foi passado na requisição.
     *
     * @param id ID do autor a ser deletado
     * @return Autor deletado com sucesso (200) ou erro (400 ou 500)
     * @throws Exception
     * @see AutorService#excluirAutor(Integer)
     */
    @Tag(name = "Livros", description = "Operações relacionadas a livros")
    @Operation(summary = "Deleta um Autor", description = "Recebe a requisição de uma remoção de um Autor por ID e envia para a service o id que foi passado na requisição, a service gerencia as regras de negócios e aciona a repository que deleta o Autor do banco de dados")
    @ApiResponse(responseCode = "200", description = "O Autor foi deletado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao deletar o Autor")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao deletar o Autor")
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
