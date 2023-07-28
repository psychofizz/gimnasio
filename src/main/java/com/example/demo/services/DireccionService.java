package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Direccion;

@Service
public interface DireccionService {

    public Direccion guardarDireccion(Direccion direccion);

    public Direccion buscarPorId(int id);

    public Direccion borrarPorId(int id);

    public List<Direccion> regresarTodo();
}
