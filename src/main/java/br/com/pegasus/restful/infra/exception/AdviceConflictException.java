package br.com.pegasus.restful.infra.exception;

public class AdviceConflictException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AdviceConflictException(String msg) {
		super(msg);
	}
}
