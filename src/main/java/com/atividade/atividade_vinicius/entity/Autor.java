package com.atividade.atividade_vinicius.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Pedro Henrique Panstein
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.REMOVE)
    private List<Livro> livros;
}
