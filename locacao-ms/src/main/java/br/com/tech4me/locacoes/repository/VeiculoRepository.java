package br.com.tech4me.locacoes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.tech4me.locacoes.model.Veiculo;

public interface VeiculoRepository extends MongoRepository<Veiculo, String> {

}
