package cl.demo.demo_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import cl.demo.demo_spring.model.Libro;

import cl.demo.demo_spring.repository.LibroRepository;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    public Optional<Libro> buscarPorId(Long id) {
        return libroRepository.findById(id);
    }

    public Libro crearLibro(Libro libro) {
        libro.setId(null);
        return libroRepository.save(libro);
    }

    public Optional<Libro> actualizarLibro(Long id, Libro libro) {
        return libroRepository.findById(id).map(existing -> {
            existing.setTitulo(libro.getTitulo());
            existing.setAutor(libro.getAutor());
            return libroRepository.save(existing);
        });
    }

    public boolean borrarLibro(Long id) {
        if (!libroRepository.existsById(id)) {
            return false;
        }

        libroRepository.deleteById(id);
        return true;
    }
}
