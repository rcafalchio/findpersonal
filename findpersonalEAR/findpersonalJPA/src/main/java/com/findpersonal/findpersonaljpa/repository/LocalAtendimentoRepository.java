package com.findpersonal.findpersonaljpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.findpersonal.findpersonaljpa.entity.LocalAtendimento;
import com.findpersonal.findpersonaljpa.entity.LocalAtendimentoPK;

public interface LocalAtendimentoRepository extends JpaRepository<LocalAtendimento, LocalAtendimentoPK> {

}
