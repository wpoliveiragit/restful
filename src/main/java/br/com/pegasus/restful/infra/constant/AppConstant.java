package br.com.pegasus.restful.infra.constant;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AppConstant {

	// KEY MAP
	MAP_KEY_CODE("code"), //
	MAP_KEY_MESSAGE("message"), //
	MAP_KEY_DETAIL("detail"),

	// Message exception
	MSG_NOT_FOUND_EXCEPTION("ID não encontrado."), //
	MSG_CONFLICT_EXCEPTION("Existe um registro com o mesmo nome");

	public final String text;
}
