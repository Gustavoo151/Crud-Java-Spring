package com.gustavo.controller;

import com.gustavo.model.Course;
import com.gustavo.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  // Esse anotation indica que essa classe vai ter um endPoint(URL) que nos vamos poder acessar atravez da API (Por tráz dos panos temos um Java servelet)
@RequestMapping("/api/courses")  // O endPoint
//@AllArgsConstructor   // Essa anotation do Lombok via fazer criação do constrotutor que vai servir para injeção de dependencias.
public class CourseController {
// Se quisermos que o spring crie um instância e automaticamente gerencie o ciclo de vida dela a gente usa o anotation @Componet. Esses são @Bean que é uma anotaiton que inidica que o cliclo de compoente vai ser gerenciado pelo Spring

    private CourseRepository courseRepository;

//    Fazer a injeção dependencia via construtor é uma boa prática, pois quando o Spring for instanciar essa classe ela
//    vai ser obrigada a passar o CouserReposity para poder funcionar. Via atributo usando @Autowired ou via set indica
//    que precisamos dessa instancia em um segundo momento. Porque usamos isso, por causa que temos um atributo
//    obrigatorio que é o couserRepository.
    public CourseController(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

//    @RequestMapping(method = RequestMethod.GET) // Esse é igual ao abaixo.
    @GetMapping
    public List<Course> list(){
        return null;
    }
}
