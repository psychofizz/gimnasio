package com.example.demo.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Clientes;
import com.example.demo.services.impl.ClientesServiceImpl;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    	
	@Autowired
	private ClientesServiceImpl clienteImplementacionService;
	
	@PostMapping("/crear")
	public Clientes crearCliente(@RequestBody Clientes cliente) throws ParseException {
		clienteImplementacionService.guardarCliente(cliente);			
		return cliente;
	}
	
	@GetMapping("/buscar/{id}")
	public Clientes buscarCliente(@PathVariable(name="id") String id) {
		return clienteImplementacionService.buscarPorId(id);
	}

	@GetMapping("/todo-cliente")
	public List<Clientes> todoCliente (){
		return clienteImplementacionService.regresarTodo();
	}

	@DeleteMapping("/borrar/{id}")
	public Clientes borrarCliente(@PathVariable(name="id") String id){
		return clienteImplementacionService.borrarPorId(id);
	}

	@GetMapping("test")
	public String test(){
		return "Sanity check";
	}
}
