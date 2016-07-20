package com.github.adkorzen.SudokuSolver;

import com.github.adkorzen.SudokuSolver.fileIO.FileReader;

public class Board {
	
	private Field[][] fields = new Field[9][9];
	private int[][] results;
	
	public Board(String path) {
		results = FileReader.readFile(path);
	}

	public int[][] getResult() {
		return results;
	}
	public Field[][] getFields() {
		return fields;
	}
	//test
	public void setResult(int x, int y, int value) {
		results[x-1][y-1] = value;
	}
	//test
	public Field getField(int x, int y) {
		return fields[x-1][y-1];
	}
}
