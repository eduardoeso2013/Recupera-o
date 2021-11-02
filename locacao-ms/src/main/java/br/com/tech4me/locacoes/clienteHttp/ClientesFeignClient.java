package br.com.tech4me.locacoes.clienteHttp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tech4me.locacoes.shared.Locacao;

@FeignClient(name = "locacoes-ms", fallback = ClientesFeignClientFallBack.class)
public interface ClientesFeignClient {
  @GetMapping(path = "/api/locacoes/{cliente}/lista")
  List<Locacao> obterClientes(@PathVariable String cliente);
}

@Component
class ClientesFeignClientFallBack implements ClientesFeignClient {

  @Override
  public List<Locacao> obterClientes(String cliente) {
    return new ArrayList<>();
  }
}