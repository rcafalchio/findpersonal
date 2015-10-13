package com.findpersonal.findpersonaljpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.findpersonal.findpersonaljpa.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByEmail(String email);

}
