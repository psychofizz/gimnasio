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

import com.example.demo.models.Membresia;
import com.example.demo.services.impl.MembresiaServiceImpl;

@RestController
@RequestMapping("/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaServiceImpl membresiaImplementacionService;

    @PostMapping("/crear")
    public Membresia crearMembresia(@RequestBody Membresia membresia) {
        membresiaImplementacionService.guardarMembresia(membresia);
        return membresia;
    }

    @GetMapping("/buscar/{id}")
    public Membresia buscarMembresia(@PathVariable(name = "id") int id) {
        return membresiaImplementacionService.buscarPorId(id);
    }

    @GetMapping("/todo-membresia")
    public List<Membresia> todoMembresia() {
        return membresiaImplementacionService.regresarTodo();
    }

    @DeleteMapping("/borrar/{id}")
    public Membresia borrarMembresia(@PathVariable(name = "id") int id) {
        return membresiaImplementacionService.borrarPorId(id);
    }

    @GetMapping("test")
    public String test() {
        return "Sanity check";
    }
}
