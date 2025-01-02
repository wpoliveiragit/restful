package br.com.pegasus.restful.infra.exception;

public class AdviceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AdviceNotFoundException(String msg) {
		super(msg);
	}
}
