package br.com.tech4me.locacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LocacoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocacoesApplication.class, args);
	}

}
