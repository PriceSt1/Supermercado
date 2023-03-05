package com.falejandroborjas.supermercado;

import com.falejandroborjas.supermercado.models.service.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupermercadoApplication implements CommandLineRunner {

	@Autowired
	private IUploadFileService fileService;

	@Override
	public void run(String... args) throws Exception {
		fileService.deleteAll();
		fileService.init();


	}
	public static void main(String[] args) {
		SpringApplication.run(SupermercadoApplication.class, args);
	}

}
