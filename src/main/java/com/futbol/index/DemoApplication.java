package com.futbol.index;

import com.Service.ClubServiceImpl;
import com.Service.JugadorServiceImpl;
import com.model.Club;
import com.model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private final JugadorServiceImpl jugadorService;
	private final ClubServiceImpl clubService;

	@Autowired
	public DemoApplication(JugadorServiceImpl jugadorServiceImpl, ClubServiceImpl clubService ) {
		this.jugadorService = jugadorServiceImpl;
		this.clubService = clubService;
	}


	@PostMapping("/jugadores/crear")
	public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador jugador) {
		Jugador nuevoJugador = jugadorService.agregarJugador(jugador);
		return new ResponseEntity<>(nuevoJugador, HttpStatus.CREATED);
	}


	@GetMapping("/jugadores/all")
	public ResponseEntity<List<Jugador>> obtenerTodosLosJugadores() {
		List<Jugador> jugadores = jugadorService.obtenerTodosLosJugadores();
		return new ResponseEntity<>(jugadores, HttpStatus.OK);
	}


	@GetMapping("/jugadores/{id}")
	public ResponseEntity<Jugador> obtenerJugadorPorId(@PathVariable Long id) {
		Jugador jugador = jugadorService.obtenerJugadorPorId(id);
		if (jugador != null) {
			return new ResponseEntity<>(jugador, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@DeleteMapping("jugador/eliminar/{id}")
	public ResponseEntity<Void> eliminarJugador(@PathVariable Long id) {
		Jugador jugador = jugadorService.obtenerJugadorPorId(id);
		if (jugador != null) {
			jugadorService.eliminarJugador(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/clubes/crear")
	public ResponseEntity<Club> crearClub(@RequestBody Club club) {
		Club nuevoClub = clubService.agregarClub(club);
		return new ResponseEntity<>(nuevoClub, HttpStatus.CREATED);
	}

	@GetMapping("/clubes/all")
	public ResponseEntity<List<Club>> obtenerTodosLosClubes() {
		List<Club> clubes = clubService.obtenerTodosLosClubes();
		return new ResponseEntity<>(clubes, HttpStatus.OK);
	}

	@GetMapping("/clubes/{id}")
	public ResponseEntity<Club> obtenerClubPorId(@PathVariable Long id) {
		Club club = clubService.obtenerClubPorId(id);
		if (club != null) {
			return new ResponseEntity<>(club, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("club/eliminar/{id}")
	public ResponseEntity<Void> eliminarClub(@PathVariable Long id) {
		Club club = clubService.obtenerClubPorId(id);
		if (club != null) {
			clubService.eliminarClub(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("club/actualizar/{id}")
	public ResponseEntity<Club> actualizarClub(@PathVariable Long id, @RequestBody Club clubActualizado) {
		Club clubExistente = clubService.obtenerClubPorId(id);
		if (clubExistente != null) {
			clubExistente.setNombre(clubActualizado.getNombre());
			clubExistente.setCiudad(clubActualizado.getCiudad());
			Club clubActualizadoResult = clubService.actualizarClub(id, clubExistente);
			return new ResponseEntity<>(clubActualizadoResult, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
