package com.findpersonal.findpersonalws.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonaljpa.entity.Cidade;
import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonaljpa.entity.Estado;
import com.findpersonal.findpersonaljpa.entity.LocalAtendimento;
import com.findpersonal.findpersonaljpa.entity.Pais;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.entity.Usuario;
import com.findpersonal.findpersonaljpa.entity.Zona;
import com.findpersonal.findpersonalws.exception.ExpectedApplicationException;
import com.findpersonal.findpersonalws.rest.CadastroAlunoRest;
import com.findpersonal.findpersonalws.rest.CadastroLocalAtendimentoRest;
import com.findpersonal.findpersonalws.rest.CadastroPersonalRest;
import com.findpersonal.findpersonalws.rest.EnvioAtualizacaoAlunoRest;
import com.findpersonal.findpersonalws.rest.EnvioAtualizacaoPersonalRest;
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
		Aluno aluno = new Aluno();

		if (envioRest instanceof EnvioAtualizacaoAlunoRest) {
			EnvioAtualizacaoAlunoRest atulizacaoAlunoRest = (EnvioAtualizacaoAlunoRest) envioRest;
			aluno.setNome(atulizacaoAlunoRest.getNome());
			aluno.setUsuario(new Usuario());
			aluno.getUsuario().setEmail(atulizacaoAlunoRest.getEmail());
			aluno.getUsuario().setSenha(atulizacaoAlunoRest.getSenha());
			aluno.setCodigo(atulizacaoAlunoRest.getCodigo());
			aluno.setSiglaSexo(atulizacaoAlunoRest.getSiglaSexo());
			aluno.setDataNascimento(atulizacaoAlunoRest.getDataNascimento());
			if (atulizacaoAlunoRest.getAtivo() == null) {
				aluno.getUsuario().setAtivo(Boolean.TRUE);
			} else {
				aluno.getUsuario().setAtivo(atulizacaoAlunoRest.getAtivo());
			}

			if (atulizacaoAlunoRest.getCodigoFacebook() != null) {
				aluno.getUsuario().setCodigoFacebook(atulizacaoAlunoRest.getCodigoFacebook());
				aluno.getUsuario().setLoginFacebook(Boolean.TRUE);
			} else {
				aluno.getUsuario().setLoginFacebook(Boolean.FALSE);
			}
		} else {
			CadastroAlunoRest cadastroAlunoRest = (CadastroAlunoRest) envioRest;
			aluno.setNome(cadastroAlunoRest.getNome());
			aluno.setUsuario(new Usuario());
			aluno.getUsuario().setEmail(cadastroAlunoRest.getEmail());
			aluno.getUsuario().setSenha(cadastroAlunoRest.getSenha());

			if (cadastroAlunoRest.getCodigoFacebook() != null) {
				aluno.getUsuario().setCodigoFacebook(cadastroAlunoRest.getCodigoFacebook());
				aluno.getUsuario().setLoginFacebook(Boolean.TRUE);
			} else {
				aluno.getUsuario().setLoginFacebook(Boolean.FALSE);
			}
		}

		return aluno;
	}

	/**
	 * Converte de CadastroPersonalRest para Personal
	 * 
	 * @param cadastroPersonalRest
	 * @return
	 */
	public static Personal convertToPersonal(EnvioRest envioRest) {
		final Personal personal = new Personal();

		if (envioRest instanceof EnvioAtualizacaoPersonalRest) {
			EnvioAtualizacaoPersonalRest atulizacaoPersonalRest = (EnvioAtualizacaoPersonalRest) envioRest;
			personal.setNome(atulizacaoPersonalRest.getNome());
			personal.setCpf(atulizacaoPersonalRest.getCpf());
			personal.setCref(atulizacaoPersonalRest.getCref());
			personal.setUsuario(new Usuario());
			personal.getUsuario().setEmail(atulizacaoPersonalRest.getEmail());
			personal.getUsuario().setSenha(atulizacaoPersonalRest.getSenha());
			if (atulizacaoPersonalRest.getCodigoFacebook() != null) {
				personal.getUsuario().setCodigoFacebook(atulizacaoPersonalRest.getCodigoFacebook());
				personal.getUsuario().setLoginFacebook(Boolean.TRUE);
			} else {
				personal.getUsuario().setLoginFacebook(Boolean.FALSE);
			}
			personal.setSiglaSexo(atulizacaoPersonalRest.getSiglaSexo());
			personal.setDataNascimento(atulizacaoPersonalRest.getDataNascimento());
			personal.setCodigo(atulizacaoPersonalRest.getCodigo());
			if (atulizacaoPersonalRest.getAtivo() == null) {
				personal.getUsuario().setAtivo(Boolean.TRUE);
			} else {
				personal.getUsuario().setAtivo(atulizacaoPersonalRest.getAtivo());
			}
		} else {
			CadastroPersonalRest cadastroPersonalRest = (CadastroPersonalRest) envioRest;
			personal.setNome(cadastroPersonalRest.getNome());
			personal.setCpf(cadastroPersonalRest.getCpf());
			personal.setCref(cadastroPersonalRest.getCref());
			personal.setUsuario(new Usuario());
			personal.getUsuario().setEmail(cadastroPersonalRest.getEmail());
			personal.getUsuario().setSenha(cadastroPersonalRest.getSenha());
			if (cadastroPersonalRest.getCodigoFacebook() != null) {
				personal.getUsuario().setCodigoFacebook(cadastroPersonalRest.getCodigoFacebook());
				personal.getUsuario().setLoginFacebook(Boolean.TRUE);
			} else {
				personal.getUsuario().setLoginFacebook(Boolean.FALSE);
			}
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

	/**
	 * Copia as propriedades de uma entidade para outra, omitindo a copia para atributos informados e nulos.
	 * 
	 * @param entity
	 * @param entity2
	 * @param ignore
	 * @throws ExpectedApplicationException
	 */
	// @SuppressWarnings(value="all")
	public static void copyEntity(DatabaseEntity entity, DatabaseEntity entity2, String... ignore)
			throws ExpectedApplicationException {
		try {
			// Lista de String que deve ignorar na copia
			final List<String> listaIgnore = new ArrayList<String>();
			// listaIgnore.add(entity);
			// listaIgnore.add(entity2);
			for (String ignoreProperty : ignore) {
				listaIgnore.add(ignoreProperty);
			}

			Method[] metodos = entity.getClass().getMethods();

			// Verifica os metodos get e invoca, se o resultado for nulo não faz a copia da propriedade da primeira
			// entidade para as outras
			for (Method method : metodos) {
				if (method.getName().startsWith("is") || method.getName().startsWith("get")) {
					Object object = method.invoke(entity, new Object[]{});
					if (object == null) {
						String name = method.getName().replace("is", "");
						name = name.replace("get", "");
						listaIgnore.add(name.substring(0, 1).toLowerCase().concat(name.substring(1)));
					}
				}
			}

			final String[] stringArray = new String[listaIgnore.size()];
			for (String string : listaIgnore) {
				stringArray[listaIgnore.indexOf(string)] = string;
			}
			Method metodoCopy = BeanUtils.class.getMethod("copyProperties", Object.class, Object.class, String[].class);
			metodoCopy.invoke(null, new Object[]{entity, entity2, stringArray});
		} catch (SecurityException e) {
			throw new ExpectedApplicationException(e);
		} catch (IllegalAccessException e) {
			throw new ExpectedApplicationException(e);
		} catch (IllegalArgumentException e) {
			throw new ExpectedApplicationException(e);
		} catch (InvocationTargetException e) {
			throw new ExpectedApplicationException(e);
		} catch (NoSuchMethodException e) {
			throw new ExpectedApplicationException(e);
		}

	}

}
