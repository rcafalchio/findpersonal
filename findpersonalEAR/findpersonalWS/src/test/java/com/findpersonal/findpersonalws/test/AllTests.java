package com.findpersonal.findpersonalws.test;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@Ignore
@RunWith(Suite.class)
@SuiteClasses({ AlunoAtualizacaoRestTest.class, AlunoCadastroRestTest.class, AlunoConsultaRestTest.class,
		PersonalAtualizacaoRestTest.class, PersonalCadastroRestTest.class, PersonalConsultaRestTest.class })
public class AllTests {

}
