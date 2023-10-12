package com.gustavo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

//@Getter  // Anotation para lombok criar os gets
//@Setter // Anotation para o lombok criar os sets
@Data // Anotation para o lombok criar os gets, sets, construtor, ToString
@Entity  // Esse anotation Entity vai servir para criar nossa tabela na banco de dados usando o Hibernate
//@Table(name = "Courses") // Caso o nome da tabela seja difente do da classe
public class Course {

    @Id  // Chave primaria de tabela.
    @GeneratedValue(strategy = GenerationType.AUTO) // Essa anotação gera um valor automatioco sempre que a gente insere um resistro no banco de dados.
    @JsonProperty("_id")  // Essa anotation ser para 'mudar' o nome desse campo que era id para _id, assim nos posibilitando usar esse id
    private long id;

    @Column(name = "name", length = 200, nullable = false)  // O Bom de usar essa anotation é que se o nome da coluna for diferente do nome do atributo podemos alterar
    private String name;

    @Column(name = "category", length = 200, nullable = false)  // Se não colocar o nome da coluna automaticamento o nome do atributo via ser o nome da coluna. E também podemos usar vários métodos
    private String category;


    // Vamos usar Lombok para criar os gets e sets
}
