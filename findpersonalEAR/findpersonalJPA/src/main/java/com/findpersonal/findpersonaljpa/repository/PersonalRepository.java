package com.findpersonal.findpersonaljpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.findpersonal.findpersonaljpa.entity.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Integer> {
	
}
