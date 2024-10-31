package br.com.alura.codechella.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String nome;
	private LocalDate nascimento;
	private String email;
}
