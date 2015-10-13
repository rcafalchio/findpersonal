package com.findpersonal.findpersonalws.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.findpersonal.findpersonalutil.constant.ValidationEnum;
import com.findpersonal.findpersonalutil.util.MessageUtils;
import com.findpersonal.findpersonalutil.vo.ErroNegocio;
import com.findpersonal.findpersonalws.rest.RetornoRest.RetornoRestEnum;

@ControllerAdvice
public class ControllerValidationHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public RetornoRest processValidationError(MethodArgumentNotValidException ex) {
		RetornoRest retornoRest = new RetornoCadastroRest(RetornoRestEnum.ERRO_NEGOCIO);
		BindingResult result = ex.getBindingResult();
		List<FieldError> errors = result.getFieldErrors();
		if (errors != null && !errors.isEmpty()) {
			retornoRest = processFieldError(errors);
		}
		return retornoRest;

	}

	private RetornoRest processFieldError(List<FieldError> errors) {

		RetornoRest retornoRest = new RetornoCadastroRest(RetornoRestEnum.ERRO_NEGOCIO);
		StringBuffer buffer = new StringBuffer(MessageUtils.getBundle()
				.getString(ValidationEnum.ERRO_NOS_PARAMETROS_ENVIO.getPropertiesMensage()).concat(";"));
		for (FieldError fieldError : errors) {
			buffer.append("[" + fieldError.getField() + "]");
			buffer.append(fieldError.getDefaultMessage().concat(";"));
		}
		final ErroNegocio erroNegocio = new ErroNegocio(ValidationEnum.ERRO_NOS_PARAMETROS_ENVIO.getCodigo(),
				buffer.toString());
		retornoRest.getListaErrosNegocio().add(erroNegocio);
		return retornoRest;
	}
}
