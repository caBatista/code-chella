package br.com.alura.codechella;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class CodechellaApplication {
	
	public static void main(String[] args) {
		Dotenv dotEnv = Dotenv.load();
		System.setProperty("DB_PASSWORD", Objects.requireNonNull(dotEnv.get("DB_PASSWORD")));
		SpringApplication.run(CodechellaApplication.class, args);
	}
}
