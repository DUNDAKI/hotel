package model.exceptions;

public class DomainExcptions extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DomainExcptions (String msg) {
		super(msg);
	}
}
