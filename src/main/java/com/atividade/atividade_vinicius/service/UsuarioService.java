package com.atividade.atividade_vinicius.service;

import com.atividade.atividade_vinicius.entity.Usuario;
import com.atividade.atividade_vinicius.repository.LivroRepository;
import com.atividade.atividade_vinicius.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Pedro Henrique Panstein
 * @version 1.0
 * @since 2025-02-13
 */

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository repository;

    /**
     * Adiciona um novo usuário.
     *
     * @param usuario Usuário a ser adicionado.
     * @return O usuário recem-criado.
     * @throws RuntimeException Se o usuário não tiver todos os campos obrigatórios preenchidos
     *                          ou se houver um erro interno ao salvar o usuário.
     * @see UsuarioRepository#save(Object)
     */
    public Usuario adiconarUsuario(Usuario usuario) {
        try {
            if (usuario.getEmail() == null || usuario.getTelefone() == null || usuario.getNome() == null) {
                throw new RuntimeException("Todos os campos são obrigatórios");
            }
            return repository.save(usuario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar o usuario: ", e);
        }
    }

    /**
     * Edita um usuário.
     *
     * @param id      O identificador do usuário a ser editado.
     * @param usuario O usuário editado.
     * @return O usuário editado.
     * @throws RuntimeException Se o usuário n o  for encontrado ou se houver um erro interno
     * ao editar o usuário.
     * @see UsuarioRepository#save(Object)
     */
    public Usuario editarUsuario(Integer id, Usuario usuario) {
        try {
            Usuario usuarioEditado = repository.findById(id).orElseThrow(NoSuchElementException::new);
            usuario.setId(usuarioEditado.getId());
            return repository.save(usuario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar o usuario: ", e);
        }
    }

    /**
     * Busca um usuário pelo seu identificador.
     *
     * @param id O identificador do usuário a ser buscado.
     * @return O usuário encontrado.
     * @throws RuntimeException Se o usuário n o  for encontrado ou se houver um erro interno
     *                          ao buscar o usuário.
     *
     * @see UsuarioRepository#findById(Object)
     */
    public Usuario buscarUsuario(Integer id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o usuario: ", e);
        }
    }

    /**
     * Busca todos os usuários cadastrados.
     *
     * @return Uma lista contendo todos os usuários.
     * @throws RuntimeException Se houver um erro interno ao buscar os usuários.
     *
     * @see UsuarioRepository#findAll()
     */
    public List<Usuario> buscarUsuarios() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar os usuarios: ", e);
        }
    }

    /**
     * Deleta um usuário pelo seu identificador.
     *
     * @param id O identificador do usuário a ser deletado.
     * @throws RuntimeException Se o usuário n o  for encontrado ou se houver um erro interno
     *ao deletar o usuário.
     *
     * @see UsuarioRepository#deleteById(Object)
     */
    public void excluirUsuario(Integer id) {
        try {
            Usuario usuarioDeletado = repository.findById(id).orElseThrow();
            repository.delete(usuarioDeletado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir o usuario: ", e);
        }
    }
}
