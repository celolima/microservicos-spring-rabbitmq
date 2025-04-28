package com.marcelo.analisecredito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcelo.analisecredito.domain.Proposta;
import com.marcelo.analisecredito.domain.Usuario;
import com.marcelo.analisecredito.service.AnaliseCreditoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class AnalisecreditoApplication {

	private final Logger logger = LoggerFactory.getLogger(AnalisecreditoApplication.class);

	private AnaliseCreditoService analiseCreditoService;

	public static void main(String[] args) {
		SpringApplication.run(AnalisecreditoApplication.class, args);
	}

	/**
	 * Comment with @Bean to execute on init app
	 * @return
	 */
	public CommandLineRunner commandLineRunner() {

		return args -> {
			Proposta p = new Proposta(Long.valueOf(1),Double.valueOf(70000.00),Integer.valueOf(20),Boolean.TRUE,"Emprestimo consignado",new Usuario());
			analiseCreditoService.analisar(p);

			logger.info(String.format("Sua proposta foi %s", p.getAprovada() ? "APROVADA" : "RECUSADA"));
		};
	}

}
