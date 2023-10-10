package com.gustavo.controller;

import com.gustavo.model.Course;
import com.gustavo.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  // Esse anotation indica que essa classe vai ter um endPoint(URL) que nos vamos poder acessar atravez da API (Por tráz dos panos temos um Java servelet)
@RequestMapping("/api/courses")  // O endPoint
//@AllArgsConstructor // Essa anotation do Lombok via fazer criação do constrotutor que vai servir para injeção de dependencias.
public class CourseController {
// Se quisermos que o spring crie uma instância e automaticamente gerencie o ciclo de vida dela a gente usa o anotation @Componet. Esses são @Bean que é uma anotaiton que inidica que o cliclo de compoente vai ser gerenciado pelo Spring

    private final CourseRepository courseRepository;  // Como a instância só vai ser passada uma vez vamos usar um final para evitar problemas futuros.

//    Fazer a injeção dependencia via construtor é uma boa prática, pois quando o Spring for instanciar essa classe ela
//    vai ser obrigada a passar o CouserReposity para poder funcionar. Via atributo usando @Autowired ou via ‘set’ indica
//    que precisamos dessa instancia em um segundo momento. Porque usamos isso, porque temos um atributo
//    obrigatorio que é o couserRepository.
    public CourseController(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

//    @RequestMapping(method = RequestMethod.GET) // Esse é igual ao abaixo.
    @GetMapping
    public List<Course> list(){
        return courseRepository.findAll();  // O findAll vai funcionar como ser fosse uma consulta na tabela assim: select * .
//       No mundo real não usamos findAll sem cláusula, pois que essa tabela tiver milhares de resistros no nosso banco de dados
//        a gente precisaria usar paginação para controlar e aumnentar a performace.
    }

//    Esse componente só vai servir para nível de exemplo isso NUNCA poderá ser feito numa aplicação real.
    @Bean // Usando bean para indicar que Spring via gerenciar todo o ciclo de vida desse componente
    CommandLineRunner initDataBase(CourseRepository courseRepository){  // O CommandLineRunner vai ser execultado assim que aplicação subir.
        return args -> {
            courseRepository.deleteAll(); // Esse delete all vai servir para que sempre que a gente inicializar esse projeto eu limpar a base de dados e ter novo dados.

            Course c = new Course();
            c.setName("Angular Com Spring");
            c.setCategory("Frot-end");

            courseRepository.save(c);
        };
    }
}