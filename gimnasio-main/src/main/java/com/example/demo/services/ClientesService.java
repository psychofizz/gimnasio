package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Clientes;

@Service

public interface ClientesService {

	
	public Clientes guardarCliente(Clientes cliente);
	
	public Clientes buscarPorId(String id);

	public Clientes borrarPorId(String id);

	public List<Clientes> regresarTodo();
	
}
