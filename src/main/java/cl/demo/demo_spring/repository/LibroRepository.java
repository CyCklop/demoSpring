package cl.demo.demo_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.demo.demo_spring.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

}
