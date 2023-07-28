package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.models.Direccion;
import com.example.demo.repositories.DireccionRepository;
import com.example.demo.services.DireccionService;

@Component
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public Direccion guardarDireccion(Direccion direccion) {
        direccionRepository.save(direccion);
        return direccion;
    }

    @Override
    public Direccion buscarPorId(int id) {
        Optional<Direccion> optionalDireccion = direccionRepository.findById(id);
        return optionalDireccion.orElse(null);
    }

    @Override
    public Direccion borrarPorId(int id) {
        Optional<Direccion> optionalDireccion = direccionRepository.findById(id);

        if (optionalDireccion.isPresent()) {
            Direccion direccion = optionalDireccion.get();
            direccionRepository.delete(direccion);
            return direccion;
        } else {
            return null;
        }
    }

    @Override
    public List<Direccion> regresarTodo() {
        List<Direccion> direccionesList = (List<Direccion>) direccionRepository.findAll();
        return direccionesList;
    }
}
