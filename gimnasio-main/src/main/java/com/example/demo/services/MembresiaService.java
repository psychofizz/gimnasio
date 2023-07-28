package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Membresia;

@Service
public interface MembresiaService {

    public Membresia guardarMembresia(Membresia membresia);

    public Membresia buscarPorId(int id);

    public Membresia borrarPorId(int id);

    public List<Membresia> regresarTodo();
}
