package com.github.adkorzen.SudokuSolver.exceptions;

public class NoPossibleValueException extends RuntimeException {

	public NoPossibleValueException() {
		super("Impossible to solve. Or mistake in algorithm:)");
	}
}
