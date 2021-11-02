package br.com.tech4me.clientes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.clientes.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
