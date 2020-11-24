package br.com.loadti.gerenciamentodepessoa.controller;

import br.com.loadti.gerenciamentodepessoa.entity.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonContoller {

    Person p = new Person();

}
