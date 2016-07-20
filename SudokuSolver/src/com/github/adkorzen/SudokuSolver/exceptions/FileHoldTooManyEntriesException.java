package com.github.adkorzen.SudokuSolver.exceptions;

public class FileHoldTooManyEntriesException extends RuntimeException {
	
	public FileHoldTooManyEntriesException(String path) {
		super("File " + path + " holds too few entries");
	}

}
