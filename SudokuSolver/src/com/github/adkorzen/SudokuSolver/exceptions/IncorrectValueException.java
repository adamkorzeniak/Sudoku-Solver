package com.github.adkorzen.SudokuSolver.exceptions;

public class IncorrectValueException extends RuntimeException {
	
	public IncorrectValueException(int value) {
		super(value + " is not a correct value to hold for a field");
	}

}
