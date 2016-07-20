package com.github.adkorzen.SudokuSolver.exceptions;

public class FileHoldTooFewEntriesException extends RuntimeException {
	
	public FileHoldTooFewEntriesException(String path) {
		super("File " + path + " holds too few entries");
	}

}
