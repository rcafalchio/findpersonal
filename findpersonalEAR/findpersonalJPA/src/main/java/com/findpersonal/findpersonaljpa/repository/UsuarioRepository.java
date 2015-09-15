package com.findpersonal.findpersonaljpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.findpersonal.findpersonaljpa.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
