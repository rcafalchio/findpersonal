package com.findpersonal.findpersonalws.rest;

import java.util.Date;
import java.util.List;

public class CadastroPersonalRest extends EnvioRest {
	
	private String login;
	private String senha;
	private String email;
	private String nome;
	private Date dataNascimento;
	private String siglaSexo;
	private List<CadastroLocalAtendimentoRest> listaAtendimento;
	private List<Integer> codigosEspecialidades;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSiglaSexo() {
		return siglaSexo;
	}
	public void setSiglaSexo(String siglaSexo) {
		this.siglaSexo = siglaSexo;
	}
	public List<CadastroLocalAtendimentoRest> getListaAtendimento() {
		return listaAtendimento;
	}
	public void setListaAtendimento(List<CadastroLocalAtendimentoRest> listaAtendimento) {
		this.listaAtendimento = listaAtendimento;
	}
	public List<Integer> getCodigosEspecialidades() {
		return codigosEspecialidades;
	}
	public void setCodigosEspecialidades(List<Integer> codigosEspecialidades) {
		this.codigosEspecialidades = codigosEspecialidades;
	}

}
