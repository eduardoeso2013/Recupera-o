package br.com.tech4me.clientes.clienteHttp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tech4me.clientes.shared.Locacao;

@FeignClient(name = "clientes-ms", fallback = LocacoesFeignClientFallBack.class)
public interface LocacoesFeignClient {
  @GetMapping(path = "/api/clientes/{locador}/lista")
  List<Locacao> obterLocacoes(@PathVariable String locador);
}

@Component
class LocacoesFeignClientFallBack implements LocacoesFeignClient {

  @Override
  public List<Locacao> obterLocacoes(String locador) {
    return new ArrayList<>();
  }
}