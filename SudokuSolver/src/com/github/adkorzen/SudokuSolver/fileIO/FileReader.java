package com.github.adkorzen.SudokuSolver.fileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.github.adkorzen.SudokuSolver.exceptions.FileDoesNotExistException;
import com.github.adkorzen.SudokuSolver.exceptions.FileHoldInvalidEntriesException;
import com.github.adkorzen.SudokuSolver.exceptions.FileHoldTooFewEntriesException;
import com.github.adkorzen.SudokuSolver.exceptions.FileHoldTooManyEntriesException;

public class FileReader {

	private static BufferedReader br;

	public static int[][] readFile(String path) throws IOException {
		String data = "";
		try {
			java.io.FileReader reader = new java.io.FileReader(path);
			br = new BufferedReader(reader);
			String line = "";
			while ((line = br.readLine()) != null) {
				data += line + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new FileDoesNotExistException(path);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}

		String[] splitted = data.split("\\s");
		if (splitted.length < 81) {
			throw new FileHoldTooFewEntriesException(path);
		}
		if (splitted.length > 81) {
			throw new FileHoldTooManyEntriesException(path);
		}
		int[][] result = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				try {
					result[i][j] = Integer.parseInt(splitted[i * 9 + j]);
				} catch (NumberFormatException e) {
					throw new FileHoldInvalidEntriesException(path);
				}
			}
		}
		return result;
	}

}
