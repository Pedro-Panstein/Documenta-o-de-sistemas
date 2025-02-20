package com.atividade.atividade_vinicius.controller;

import com.atividade.atividade_vinicius.entity.Autor;
import com.atividade.atividade_vinicius.entity.Emprestimo;
import com.atividade.atividade_vinicius.entity.Emprestimo;
import com.atividade.atividade_vinicius.service.AutorService;
import com.atividade.atividade_vinicius.service.EmprestimoService;
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
@RequestMapping("/emprestimo")
public class EmprestimoController {
    private EmprestimoService service;

    /**
     * Adiciona um novo emprestimo.
     *
     * <p>Recebe a requisição de um novo emprestimo e envia para a service.
     *
     * @param emprestimo Emprestimo a ser adicionado
     * @return Emprestimo adicionado com sucesso (201) ou erro (400 ou 500)
     * @Throws Exception
     * @see EmprestimoService#adiconarEmprestimo(Emprestimo)
     */
    @Operation(summary = "Adiciona um novo Emprestimo", description = "Recebe a requisição de um novo Emprestimo e envia para a service que gerencia as regras de negócios e aciona a repository que adiciona o Emprestimo ao banco de dados")
    @ApiResponse(responseCode = "201", description = "Emprestimo adicionado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao adicionar o Emprestimo")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao adicionar o Emprestimo")
    @PostMapping("/adicionar")
    public ResponseEntity<Emprestimo> adicionarEmprestimo(@RequestBody Emprestimo emprestimo) {
        try {
            Emprestimo novoEmprestimo = service.adiconarEmprestimo(emprestimo);
            return new ResponseEntity<>(novoEmprestimo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Edita um Emprestimo.
     *
     * <p>Recebe a requisição de um Emprestimo editado e envia para a service.
     *
     * @param id         ID do Emprestimo a ser editado
     * @param emprestimo Emprestimo a ser editado
     * @return Emprestimo editado com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see EmprestimoService#editarEmprestimo(Integer, Emprestimo)
     */
    @Operation(summary = "Atualiza um Emprestimo", description = "Recebe a requisição de um Emprestimo editado e envia para a service que gerencia as regras de negócios e aciona a repository para editar o Emprestimo e salvar no banco de dados")
    @ApiResponse(responseCode = "200", description = "Emprestimo editado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao editar o Emprestimo")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao editar o Emprestimo")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Emprestimo> editarEmprestimo(@PathVariable Integer id, @RequestBody Emprestimo emprestimo) {
        try {
            Emprestimo emprestimoEditado = service.editarEmprestimo(id, emprestimo);
            return new ResponseEntity<>(emprestimoEditado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Busca um Emprestimo.
     *
     * <p>Recebe a requisição de um Emprestimo pelo seu ID e envia para a service.
     *
     * @param id ID do Emprestimo a ser buscado
     * @return Emprestimo encontrado com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see EmprestimoService#buscarEmprestimo(Integer)
     */
    @Operation(summary = "Busca um Emprestimo pelo ID", description = "Recebe a requisição de uma busca de um Emprestimo por ID e envia para a service o id que foi passado na requisição, a service gerencia as regras de negócios e aciona a repository que busca o Emprestimo no banco de dados")
    @ApiResponse(responseCode = "200", description = "Emprestimo foi encontrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao buscar o Emprestimo")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao buscar o Emprestimo")
    @GetMapping("/listar/{id}")
    public ResponseEntity<Emprestimo> buscarEmprestimo(@PathVariable Integer id) {
        try {
            Emprestimo emprestimo = service.buscarEmprestimo(id);
            return new ResponseEntity<>(emprestimo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Busca todos os Emprestimos.
     *
     * <p>Recebe a requisição de uma busca por todos os Emprestimos e envia para a service.
     *
     * @return Todos os Emprestimos encontrados com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see EmprestimoService#buscarEmprestimos()
     */
    @Operation(summary = "Busca todos os Emprestimos", description = "Recebe a requisição de uma busca por todos as Bibliotecas, que envia a requisição para a service que gerencia as regras de negócios e aciona a repository que busca todos os Emprestimos presentes no banco de dados")
    @ApiResponse(responseCode = "200", description = "Os Emprestimos foram encontrados com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao buscar os Emprestimos")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao buscar os Emprestimos")
    @GetMapping("/listarTodos")
    public ResponseEntity<List<Emprestimo>> buscarEmprestimos() {
        try {
            List<Emprestimo> emprestimos = service.buscarEmprestimos();
            return new ResponseEntity<>(emprestimos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Deleta um Emprestimo.
     *
     * <p>Recebe a requisição de uma remoção de um Emprestimo por ID e envia para a service o id que foi passado na requisição.
     *
     * @param id ID do Emprestimo a ser deletado
     * @return Emprestimo deletado com sucesso (200) ou erro (400 ou 500)
     * @Throws Exception
     * @see EmprestimoService#excluirEmprestimo(Integer)
     */
    @Operation(summary = "Deleta um Emprestimo", description = "Recebe a requisição de uma remoção de um Emprestimo por ID e envia para a service o id que foi passado na requisição, a service gerencia as regras de negócios e aciona a repository que deleta o Emprestimo do banco de dados")
    @ApiResponse(responseCode = "200", description = "O Emprestimo foi deletado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao deletar o Emprestimo")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao deletar o Emprestimo")
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
