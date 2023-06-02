package com.sz.reminiscene.exception;

public class ReminiException extends RuntimeException {
	private String msg;
	
	public ReminiException() {
	}
	public ReminiException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
