package com.Service;

import com.Repository.JugadorRepository;
import com.model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorServiceImpl {

    private final JugadorRepository jugadorRepository;

    @Autowired
    public JugadorServiceImpl(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public Jugador agregarJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public List<Jugador> obtenerTodosLosJugadores() {
        return jugadorRepository.findAll();
    }

    public Jugador obtenerJugadorPorId(Long id) {
        Optional<Jugador> jugadorOptional = jugadorRepository.findById(id);
        return jugadorOptional.orElse(null);
    }

    public void eliminarJugador(Long id) {
        jugadorRepository.deleteById(id);
    }

}
