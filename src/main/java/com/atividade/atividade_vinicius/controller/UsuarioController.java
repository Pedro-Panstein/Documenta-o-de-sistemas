package com.atividade.atividade_vinicius.controller;

import com.atividade.atividade_vinicius.entity.Usuario;
import com.atividade.atividade_vinicius.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService service;

    /**
     * Adiciona um novo usuário.
     *
     * <p>Recebe a requisição de um novo usuário e envia para a service.
     *
     * @param usuario Usuário a ser adicionado
     * @return Usuário adicionado com sucesso (201) ou erro (400 ou 500)
     * @Throws Exception
     *
     * @see UsuarioService#adiconarUsuario(Usuario)
     */
    @Operation(summary = "Adiciona um novo usuário", description = "Recebe a requisição de um novo usuário e envia para a service que gerencia as regras de negócios e aciona a repository que adiciona o usuário ao banco de dados")
    @ApiResponse(responseCode = "201", description = "Usuário adicionado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao adicionar o usuário")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao adicionar o usuário")
    @PostMapping("/adicionar")
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody @Parameter(description = "Usuário a ser adicionado", required = true, content = @Content(schema = @Schema(implementation = Usuario.class))) Usuario usuario) {
        try {
            Usuario novoUsuario = service.adiconarUsuario(usuario);
            return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Atualiza um usuário.
     *
     * <p>Recebe a requisição de um usuário editado e envia para a service.
     *
     * @param id ID do usuário a ser editado
     * @param usuario   Usuário editado
     * @return Usuário editado com sucesso (200) ou erro (400 ou 500)
     * @throws Exception
     *
     * @see UsuarioService#editarUsuario(Integer, Usuario)
     */
    @Operation(summary = "Atualiza um usuário", description = "Recebe a requisição de um usuário editado e envia para a service que gerencia as regras de negócios e aciona a repository para editar o usuário e salvar no banco de dados")
    @ApiResponse(responseCode = "200", description = "Usuário editado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao editar o usuário")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao editar o usuário")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        try {
            Usuario usuarioEditado = service.editarUsuario(id, usuario);
            return new ResponseEntity<>(usuarioEditado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Busca um usuário pelo ID.
     *
     * <p>Recebe a requisição de uma busca de um usuário pelo ID e envia para a service.
     *
     * @param id ID do usuário a ser buscado
     * @return Usuário foi encontrado com sucesso (200) ou erro (400 ou 500)
     * @throws Exception
     *
     * @see UsuarioService#buscarUsuario(Integer)
     */
    @Operation(summary = "Busca um usuário pelo ID", description = "Recebe a requisição de uma busca de um usuario por ID e envia para a service o id que foi passado na requisição, a service gerencia as regras de negócios e aciona a repository que busca o usuário no banco de dados")
    @ApiResponse(responseCode = "200", description = "Usuário foi encontrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao buscar o usuário")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao buscar o usuário")
    @GetMapping("/listar/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer id) {
        try {
            Usuario usuario = service.buscarUsuario(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Busca todos os usuários.
     *
     * <p>Recebe a requisição de uma busca de todos os usuarios e envia para a service.
     *
     * @return Todos os usuários encontrados com sucesso (200) ou erro (400 ou 500)
     * @throws Exception
     *
     * @see UsuarioService#buscarUsuarios()
     */
    @Operation(summary = "Busca todos os usuários", description = "Recebe a requisição de uma busca por todos os usuarios, que envia a requisição para a service que gerencia as regras de negócios e aciona a repository que busca todos os usuarios presentes no banco de dados")
    @ApiResponse(responseCode = "200", description = "Os Usuarios foram encontrados com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao buscar os usuários")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao buscar os usuários")
    @GetMapping("/listarTodos")
    public ResponseEntity<List<Usuario>> buscarUsuarios() {
        try {
            List<Usuario> usuarios = service.buscarUsuarios();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Deleta um usuário pelo ID.
     *
     * <p>Recebe a requisição de deletar um usuário pelo ID e envia para a service.
     *
     * @param id ID do usuário a ser deletado
     * @return Usuário deletado com sucesso (200) ou erro (400 ou 500)
     * @throws Exception
     *
     * @see UsuarioService#excluirUsuario(Integer)
     */
    @Operation(summary = "Deleta um usuários", description = "Recebe a requisição de uma remoção de um usuario por ID e envia para a service o id que foi passado na requisição, a service gerencia as regras de negócios e aciona a repository que deleta o usuário do banco de dados")
    @ApiResponse(responseCode = "200", description = "O Usuario foi deletado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro do cliente ao deletadar os usuários")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao deletadar os usuários")
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Integer id) {
        try {
            service.excluirUsuario(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
