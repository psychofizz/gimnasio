package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.models.Clientes;
import com.example.demo.repositories.ClientesRepository;
import com.example.demo.services.ClientesService;

@Component

public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesRepository clienteRepository;

    @Override
    public Clientes guardarCliente(Clientes cliente) {

        clienteRepository.save(cliente);

        return null;
    }

    @Override
    public Clientes buscarPorId(String id) {
        Optional<Clientes> optionalClientes = clienteRepository.findById(id);
        return optionalClientes.orElse(null);
    }

    @Override
    public Clientes borrarPorId(String id) {
        Optional<Clientes> optionalClientes = clienteRepository.findById(id);

        if (optionalClientes.isPresent()) {
            Clientes cliente = optionalClientes.get();
            clienteRepository.delete(cliente);
            return cliente;
        } else {
            return null;
        }
    }

    @Override
    public List<Clientes> regresarTodo() {
        List<Clientes> clientesList = (List<Clientes>) clienteRepository.findAll();
        return clientesList;
    }

}
