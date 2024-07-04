package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.IEstudianteService;

@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteController {

	// Se inyecta la capa Service
	@Autowired
	private IEstudianteService estudianteService;

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	//@PostMapping(path = "/guardar")
	
	//nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes
	@PostMapping
	public void guardar(@RequestBody Estudiante est) {
		/*
		 * Estudiante est= new Estudiante(); est.setNombre("Bryan");
		 * est.setApellido("Mullo");
		 * est.setFechaNacimiento(LocalDateTime.of(1998,9,12,1,1));
		 */
		this.estudianteService.guardar(est);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	//@PutMapping(path = "/actualizar{id}")
	
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/3
	@PutMapping(path = "/{id}")
	public void actualizar(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		this.estudianteService.actualizar(est);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
	//@PatchMapping(path = "/actualizarParcial")
	
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/{id}
	@PatchMapping(path = "/{id}")
	public void actualizarParcial(@RequestBody Estudiante est, @PathVariable Integer id) {
		
		est.setId(id);
		Estudiante est1 = this.estudianteService.buscar(est.getId());
		if (est.getNombre() != null) {
			est1.setNombre(est.getNombre());
		}
		if (est.getApellido() != null) {
			est1.setApellido(est.getApellido());
		}
		if (est.getFechaNacimiento() != null) {
			est1.setFechaNacimiento(est.getFechaNacimiento());
		}
		// est.setNombre("Israel");
		this.estudianteService.actualizar(est1);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/1
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/2
	
	//@DeleteMapping(path = "/borrar/{id}")
	
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/2
	@DeleteMapping(path = "{id}")
	public void borrar(@PathVariable Integer id) {

		this.estudianteService.borrar(id);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/1/nuevo/prueba
	// @GetMapping(path = "/buscar/{id}/nuevo")
	//@GetMapping(path = "/buscar/{id}/nuevo/{dato}")
	
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/2
	@GetMapping(path = "/{id}")
	public Estudiante buscar(@PathVariable Integer id) {
	
		return this.estudianteService.buscar(id);
	}

	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=M&edad=25
	@GetMapping(path = "/buscarPorGenero")
	public List<Estudiante> buscarPorGenero(@RequestParam String genero, @RequestParam Integer edad) {
		System.out.println("EDAD: " + edad);
		List<Estudiante> lista = this.estudianteService.buscarPorGenero(genero);
		
		return lista;
	}
	
	
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/3?prueba=HolaMundo
	@GetMapping(path = "/buscarMixto/{id}")
	public Estudiante buscarMixto(@PathVariable Integer id, @RequestParam String prueba) {
		System.out.println("DATO: " + id);
		System.out.println("DATO: " + prueba);
		return this.estudianteService.buscar(id);
	}

}