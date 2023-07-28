package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Direccion;
import com.example.demo.services.impl.DireccionServiceImpl;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private DireccionServiceImpl direccionImplementacionService;

    @PostMapping("/crear")
    public Direccion crearDireccion(@RequestBody Direccion direccion) {
        direccionImplementacionService.guardarDireccion(direccion);
        return direccion;
    }

    @GetMapping("/buscar/{id}")
    public Direccion buscarDireccion(@PathVariable(name = "id") int id) {
        return direccionImplementacionService.buscarPorId(id);
    }

    @GetMapping("/todo-direccion")
    public List<Direccion> todoDireccion() {
        return direccionImplementacionService.regresarTodo();
    }

    @DeleteMapping("/borrar/{id}")
    public Direccion borrarDireccion(@PathVariable(name = "id") int id) {
        return direccionImplementacionService.borrarPorId(id);
    }

    @GetMapping("test")
    public String test() {
        return "Sanity check";
    }
}
