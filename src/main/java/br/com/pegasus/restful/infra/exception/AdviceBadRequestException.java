package br.com.pegasus.restful.infra.exception;

public class AdviceBadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AdviceBadRequestException(String msg) {
		super(msg);
	}
}
