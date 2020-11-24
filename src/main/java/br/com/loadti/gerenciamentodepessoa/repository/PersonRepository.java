package br.com.loadti.gerenciamentodepessoa.repository;

import br.com.loadti.gerenciamentodepessoa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
