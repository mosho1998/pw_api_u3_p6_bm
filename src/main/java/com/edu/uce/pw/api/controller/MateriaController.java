package com.edu.uce.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IMateriaService;

@RestController
@RequestMapping(path = "/materias")
public class MateriaController {

    @Autowired
    private IMateriaService iMateriaService;

    @PostMapping(path = "/guardar")
    public ResponseEntity<Materia> guardar(@RequestBody Materia mat) {
        this.iMateriaService.guardar(mat);
        return ResponseEntity.status(201).body(mat);
    }

    @PutMapping(path = "/actualizar")
    public ResponseEntity<Materia> actualizar(@RequestBody Materia mat) {
        this.iMateriaService.actualizar(mat);
        return ResponseEntity.status(238).body(mat);
    }

    @DeleteMapping(path = "/borrar/{id}")
    public void borrar(@PathVariable Integer id) {
        this.iMateriaService.borrar(id);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Materia> actualizarParcial(@RequestBody Materia materia, @PathVariable Long id) {
        materia.setId(id);
        Materia materia2 = this.iMateriaService.buscar(materia.getId());

        if (materia.getNombre() != null) {
            materia2.setNombre(materia.getNombre());
        }
        if (materia.getProfesor() != null) {
            materia2.setProfesor(materia.getProfesor());
        }
        if (materia.getCodigoUnico() != null) {
            materia2.setCodigoUnico(materia.getCodigoUnico());
        }
        this.iMateriaService.actualizar(materia2);
        return ResponseEntity.status(239).body(materia);
    }
    
}
