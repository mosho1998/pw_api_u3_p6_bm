package com.edu.uce.pw.api.service;

import com.edu.uce.pw.api.repository.modelo.Materia;

public interface IMateriaService {
	public Materia buscar(Long long1);

	public void actualizar(Materia materia);

	public void borrar(Integer id);

	public void guardar(Materia materia);
}
