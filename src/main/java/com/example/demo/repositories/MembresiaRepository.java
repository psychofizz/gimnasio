package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Membresia;

public interface MembresiaRepository extends CrudRepository<Membresia, String> {
}