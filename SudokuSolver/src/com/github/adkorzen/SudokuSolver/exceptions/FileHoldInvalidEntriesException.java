package com.github.adkorzen.SudokuSolver.exceptions;

public class FileHoldInvalidEntriesException extends RuntimeException{

		public FileHoldInvalidEntriesException(String path) {
			super("File " + path + " holds invalid entries");
		}

	}
