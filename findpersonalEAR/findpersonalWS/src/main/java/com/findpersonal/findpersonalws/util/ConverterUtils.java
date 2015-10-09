package com.findpersonal.findpersonalws.util;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonaljpa.entity.Cidade;
import com.findpersonal.findpersonaljpa.entity.Especialidade;
import com.findpersonal.findpersonaljpa.entity.Estado;
import com.findpersonal.findpersonaljpa.entity.LocalAtendimento;
import com.findpersonal.findpersonaljpa.entity.Pais;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.entity.Usuario;
import com.findpersonal.findpersonaljpa.entity.Zona;
import com.findpersonal.findpersonalws.rest.CadastroAlunoRest;
import com.findpersonal.findpersonalws.rest.CadastroLocalAtendimentoRest;
import com.findpersonal.findpersonalws.rest.CadastroPersonalRest;
import com.findpersonal.findpersonalws.rest.EnvioAtulizacaoAlunoRest;
import com.findpersonal.findpersonalws.rest.EnvioRest;

/**
 * Classe util responsável por converter os Objetos JSon em entidades
 * 
 * @author Ricardo
 *
 */
public final class ConverterUtils {

	/**
	 * Converte de CadastroAlunoRest para Aluno
	 * 
	 * @param cadastroAlunoRest
	 *            - Cadastro aluno
	 * @return Aluno
	 */
	public static Aluno convertToAluno(EnvioRest envioRest) {
		CadastroAlunoRest cadastroAlunoRest = (CadastroAlunoRest) envioRest;
		Aluno aluno = new Aluno();
		aluno.setNome(cadastroAlunoRest.getNome());
		if (cadastroAlunoRest instanceof EnvioAtulizacaoAlunoRest) {
			EnvioAtulizacaoAlunoRest atulizacaoAlunoRest = (EnvioAtulizacaoAlunoRest) cadastroAlunoRest;
			aluno.setSiglaSexo(atulizacaoAlunoRest.getSiglaSexo());
			aluno.setDataNascimento(atulizacaoAlunoRest.getDataNascimento());
		}
		aluno.setUsuario(new Usuario());
		aluno.getUsuario().setEmail(cadastroAlunoRest.getEmail());
		aluno.getUsuario().setSenha(cadastroAlunoRest.getSenha());
		if (cadastroAlunoRest.getCodigoFacebook() != null) {
			aluno.getUsuario().setCodigoFacebook(cadastroAlunoRest.getCodigoFacebook());
			aluno.getUsuario().setLoginFacebook(Boolean.TRUE);
		}else{
			aluno.getUsuario().setLoginFacebook(Boolean.FALSE);
		}
		return aluno;
	}

	/**
	 * Converte de CadastroPersonalRest para Personal
	 * 
	 * @param cadastroPersonalRest
	 * @return
	 */
	public static Personal convertToPersonal(CadastroPersonalRest cadastroPersonalRest) {
		final Personal personal = new Personal();
		personal.setDataNascimento(cadastroPersonalRest.getDataNascimento());
		personal.setNome(cadastroPersonalRest.getNome());
		personal.setUsuario(new Usuario());
		personal.getUsuario().setEmail(cadastroPersonalRest.getEmail());
		personal.getUsuario().setSenha(cadastroPersonalRest.getSenha());
		for (CadastroLocalAtendimentoRest atendimentoRest : cadastroPersonalRest.getListaAtendimento()) {
			personal.getLocaisAtendimento().add(convertToLocalAtendimento(atendimentoRest));
		}
		for (Integer codigo : cadastroPersonalRest.getCodigosEspecialidades()) {
			Especialidade especialidade = new Especialidade();
			especialidade.setCodigo(codigo);
			personal.getEspecialidades().add(especialidade);
		}
		return personal;
	}

	/**
	 * Converte de CadastroLocalAtendimentoRest para LocalAtendimento
	 * 
	 * @param atendimentoRest
	 * @return LocalAtendimento
	 */
	public static LocalAtendimento convertToLocalAtendimento(CadastroLocalAtendimentoRest atendimentoRest) {
		LocalAtendimento localAtendimento = new LocalAtendimento();
		localAtendimento.setCidade(new Cidade());
		localAtendimento.getCidade().setCodigo(atendimentoRest.getCodigoCidade());
		localAtendimento.setEstado(new Estado());
		localAtendimento.getEstado().setCodigo(atendimentoRest.getCodigoEstado());
		localAtendimento.setPais(new Pais());
		localAtendimento.getPais().setCodigo(atendimentoRest.getCodigoPais());
		localAtendimento.setZona(new Zona());
		localAtendimento.getZona().setCodigo(atendimentoRest.getCodigoZona());
		return localAtendimento;
	}

}
