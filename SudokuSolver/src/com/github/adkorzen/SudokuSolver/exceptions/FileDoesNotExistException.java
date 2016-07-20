package com.github.adkorzen.SudokuSolver.exceptions;

public class FileDoesNotExistException extends RuntimeException {
	
	public FileDoesNotExistException(String path) {
		super("File " + path + " does not exist");
	}

}
