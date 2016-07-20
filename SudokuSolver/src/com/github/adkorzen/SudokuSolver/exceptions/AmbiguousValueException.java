package com.github.adkorzen.SudokuSolver.exceptions;

public class AmbiguousValueException extends RuntimeException {

	public AmbiguousValueException() {
		super("Filed has yet more than one possible solution\n Cannot set its value yet");
	}
}
