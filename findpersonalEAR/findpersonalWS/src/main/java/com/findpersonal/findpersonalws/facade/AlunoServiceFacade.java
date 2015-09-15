package com.findpersonal.findpersonalws.facade;

import com.findpersonal.findpersonaljpa.entity.Aluno;

/**
 * Servicos do aluno
 * 
 * @author Ricardo
 *
 */
public class AlunoServiceFacade {

	/**
	 * Busca o Aluno por c�digo
	 * 
	 * @param codigo
	 * @return Aluno
	 */
	// Aluno encontrarAlunoPorCodigo(Long codigo) {
	// Aluno aluno = new Aluno(1L, "Ricardo Cafalchio");
	// return aluno;
	// }

	/**
	 * Busca o Aluno por c�digo
	 * 
	 * @param codigo
	 * @return Aluno
	 */
	Aluno incluirAluno(Long codigo, String nome) {
		 Aluno aluno = new Aluno();
		 return aluno;
	}

}
