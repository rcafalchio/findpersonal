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
import com.findpersonal.findpersonaljpa.entity.Facebook;
import com.findpersonal.findpersonaljpa.entity.LocalAtendimento;
import com.findpersonal.findpersonaljpa.entity.Pais;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.entity.Usuario;
import com.findpersonal.findpersonaljpa.entity.Zona;
import com.findpersonal.findpersonalws.exception.ExpectedApplicationException;
import com.findpersonal.findpersonalws.rest.dto.AlunoJSON;
import com.findpersonal.findpersonalws.rest.dto.CadastroAlunoJSON;
import com.findpersonal.findpersonalws.rest.dto.CadastroFacebookJSON;
import com.findpersonal.findpersonalws.rest.dto.CadastroLocalAtendimentoJSON;
import com.findpersonal.findpersonalws.rest.dto.CadastroPersonalJSON;
import com.findpersonal.findpersonalws.rest.dto.EnvioAtualizacaoAlunoJSON;
import com.findpersonal.findpersonalws.rest.dto.EnvioAtualizacaoPersonalJSON;
import com.findpersonal.findpersonalws.rest.dto.EnvioJSON;
import com.findpersonal.findpersonalws.rest.dto.PersonalJSON;

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
	public static Aluno convertToAluno(EnvioJSON envioRest) {
		Aluno aluno = new Aluno();

		if (envioRest instanceof EnvioAtualizacaoAlunoJSON) {
			EnvioAtualizacaoAlunoJSON atulizacaoAlunoRest = (EnvioAtualizacaoAlunoJSON) envioRest;
			aluno.setCodigo(atulizacaoAlunoRest.getCodigo());
			aluno.setNome(atulizacaoAlunoRest.getNome());
			aluno.setUsuario(new Usuario());
			aluno.getUsuario().setEmail(atulizacaoAlunoRest.getEmail());
			aluno.getUsuario().setSenha(atulizacaoAlunoRest.getSenha());
			aluno.setSiglaSexo(atulizacaoAlunoRest.getSiglaSexo());
			aluno.setDataNascimento(atulizacaoAlunoRest.getDataNascimento());
			aluno.setCpf(atulizacaoAlunoRest.getCpf());
			if (atulizacaoAlunoRest.getAtivo() == null) {
				aluno.getUsuario().setAtivo(Boolean.TRUE);
			} else {
				aluno.getUsuario().setAtivo(atulizacaoAlunoRest.getAtivo());
			}
		} else {
			CadastroAlunoJSON cadastroAlunoRest = (CadastroAlunoJSON) envioRest;
			aluno.setNome(cadastroAlunoRest.getNome());
			aluno.setUsuario(new Usuario());
			aluno.getUsuario().setEmail(cadastroAlunoRest.getEmail());
			aluno.getUsuario().setSenha(cadastroAlunoRest.getSenha());
			aluno.setCpf(cadastroAlunoRest.getCpf());
			if (cadastroAlunoRest.getCadastroFacebookJson() != null) {
				aluno.getUsuario().setLoginFacebook(Boolean.TRUE);
				aluno.getUsuario().setFacebook(convertToFacebook(cadastroAlunoRest.getCadastroFacebookJson()));
				aluno.getUsuario().getFacebook().setUsuario(aluno.getUsuario());
			} else {
				aluno.getUsuario().setLoginFacebook(Boolean.FALSE);
			}
		}

		return aluno;
	}

	/**
	 * Converte a entidade Aluno em AlunoRest
	 * 
	 * @param aluno
	 * @return AlunoRest
	 */
	public static AlunoJSON convertToAlunoRest(Aluno aluno) {
		final AlunoJSON alunoRest = new AlunoJSON();
		if (aluno != null) {
			alunoRest.setAtivo(aluno.getUsuario().getAtivo());
			if (aluno.getUsuario() != null) {
				alunoRest.setCadastroFacebookRest(convertToCadastroFacebookRest(aluno.getUsuario().getFacebook()));
			}
			alunoRest.setCodigo(aluno.getCodigo());
			alunoRest.setCpf(aluno.getCpf());
			alunoRest.setDataNascimento(aluno.getDataNascimento());
			alunoRest.setEmail(aluno.getUsuario().getEmail());
			alunoRest.setNome(aluno.getNome());
			alunoRest.setSiglaSexo(aluno.getSiglaSexo());
		}

		return alunoRest;
	}

	/**
	 * Converte de CadastroFacebookRest para Facebook
	 * 
	 * @param cadastroFacebookRest
	 * @return Facebook
	 */
	private static Facebook convertToFacebook(CadastroFacebookJSON cadastroFacebookRest) {
		final Facebook facebook = new Facebook();
		facebook.setApelido(cadastroFacebookRest.getApelido());
		facebook.setCodigoFacebook(cadastroFacebookRest.getCodigoFacebook());
		facebook.setLocale(cadastroFacebookRest.getLocale());
		facebook.setNome(cadastroFacebookRest.getNome());
		facebook.setPaginaFacebook(cadastroFacebookRest.getPaginaFacebook());
		facebook.setSobrenome(cadastroFacebookRest.getSobrenome());
		return facebook;
	}

	/**
	 * Converte de CadastroFacebookRest para Facebook
	 * 
	 * @param Facebook
	 * @return CadastroFacebookRest
	 */
	private static CadastroFacebookJSON convertToCadastroFacebookRest(Facebook facebook) {

		CadastroFacebookJSON cadastroFacebookRest = null;

		if (facebook != null) {
			cadastroFacebookRest = new CadastroFacebookJSON();
			cadastroFacebookRest.setApelido(facebook.getApelido());
			cadastroFacebookRest.setCodigoFacebook(facebook.getCodigoFacebook());
			cadastroFacebookRest.setLocale(facebook.getLocale());
			cadastroFacebookRest.setNome(facebook.getNome());
			cadastroFacebookRest.setPaginaFacebook(facebook.getPaginaFacebook());
			cadastroFacebookRest.setSobrenome(facebook.getSobrenome());
		}

		return cadastroFacebookRest;
	}

	/**
	 * Converte de CadastroPersonalRest para Personal
	 * 
	 * @param cadastroPersonalRest
	 * @return
	 */
	public static Personal convertToPersonal(EnvioJSON envioRest) {
		final Personal personal = new Personal();

		if (envioRest instanceof EnvioAtualizacaoPersonalJSON) {
			EnvioAtualizacaoPersonalJSON atulizacaoPersonalRest = (EnvioAtualizacaoPersonalJSON) envioRest;
			personal.setCodigo(atulizacaoPersonalRest.getCodigo());
			personal.setNome(atulizacaoPersonalRest.getNome());
			personal.setCpf(atulizacaoPersonalRest.getCpf());
			personal.setCref(atulizacaoPersonalRest.getCref());
			personal.setUsuario(new Usuario());
			personal.getUsuario().setEmail(atulizacaoPersonalRest.getEmail());
			personal.getUsuario().setSenha(atulizacaoPersonalRest.getSenha());
			personal.setSiglaSexo(atulizacaoPersonalRest.getSiglaSexo());
			personal.setDataNascimento(atulizacaoPersonalRest.getDataNascimento());
		} else {
			CadastroPersonalJSON cadastroPersonalRest = (CadastroPersonalJSON) envioRest;
			personal.setNome(cadastroPersonalRest.getNome());
			personal.setCpf(cadastroPersonalRest.getCpf());
			personal.setCref(cadastroPersonalRest.getCref());
			personal.setUsuario(new Usuario());
			personal.getUsuario().setEmail(cadastroPersonalRest.getEmail());
			personal.getUsuario().setSenha(cadastroPersonalRest.getSenha());
			if (cadastroPersonalRest.getCadastroFacebookRest() != null) {
				personal.getUsuario().setLoginFacebook(Boolean.TRUE);
				personal.getUsuario().setFacebook(convertToFacebook(cadastroPersonalRest.getCadastroFacebookRest()));
				personal.getUsuario().getFacebook().setUsuario(personal.getUsuario());
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
	public static LocalAtendimento convertToLocalAtendimento(CadastroLocalAtendimentoJSON atendimentoRest) {
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

	/**
	 * Coverte Personal em PersonalRest
	 * 
	 * @param Personal
	 * @return PersonalRest
	 */
	public static PersonalJSON convertToPersonalRest(Personal personal) {
		PersonalJSON personalRest = new PersonalJSON();
		if (personal != null && personal.getUsuario() != null) {
			personalRest.setAtivo(personal.getUsuario().getAtivo());
			personalRest.setEmail(personal.getUsuario().getEmail());
		}
		personalRest.setCodigo(personal.getCodigo());
		personalRest.setCpf(personal.getCpf());
		personalRest.setCref(personal.getCref());
		personalRest.setDataNascimento(personal.getDataNascimento());
		personalRest.setNome(personal.getNome());
		personalRest.setSiglaSexo(personal.getSiglaSexo());
		personalRest.setCadastroFacebookRest(convertToCadastroFacebookRest(personal.getUsuario().getFacebook()));
		return personalRest;
	}

}
