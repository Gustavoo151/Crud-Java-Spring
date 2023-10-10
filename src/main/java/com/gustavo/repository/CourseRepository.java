package com.gustavo.repository;

import com.gustavo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Esse anotation indica que vamos fazer uma conexão com o banco de dados.
public interface CourseRepository extends JpaRepository<Course, Long> {   // Aqui na herança do Jpa vamos usar os gerenerec para indicar o tipo da chave primaria e nossa entidade.
    // Quando eu fizer isso o spring vai criar uma implementação dessa interface que já tem os métodos automaticamente para a gente poder acessar.

}
