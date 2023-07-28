package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Membresia;
import com.example.demo.repositories.MembresiaRepository;
import com.example.demo.services.MembresiaService;

@Service
public class MembresiaServiceImpl implements MembresiaService {

    @Autowired
    private MembresiaRepository membresiaRepository;

    @Override
    public Membresia guardarMembresia(Membresia membresia) {
        return membresiaRepository.save(membresia);
    }

    @Override
    public Membresia buscarPorId(int id) {
        return membresiaRepository.findById(id).orElse(null);
    }

    @Override
    public Membresia borrarPorId(int id) {
        Membresia membresia = buscarPorId(id);
        if (membresia != null) {
            membresiaRepository.delete(membresia);
        }
        return membresia;
    }

    @Override
    public List<Membresia> regresarTodo() {
        return membresiaRepository.findAll();
    }
}
