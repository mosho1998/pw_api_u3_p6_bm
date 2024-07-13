package com.edu.uce.pw.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IEstudianteRepository;
import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public List<Estudiante> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorGenero(genero);
	}

	
	public EstudianteTO convertir(Estudiante estu) {
		EstudianteTO estTO = new EstudianteTO();
		estTO.setId(estu.getId());
		estTO.setNombre(estu.getNombre());
		estTO.setApellido(estu.getApellido());
		estTO.setGenero(estu.getGenero());
		estTO.setFechaNacimiento(estu.getFechaNacimiento());
		return estTO;
	}

	@Override
	public EstudianteTO buscarPorId(Integer id) {
		Estudiante est = this.estudianteRepository.seleccionar(id);
		return this.convertir(est);
	}
}
