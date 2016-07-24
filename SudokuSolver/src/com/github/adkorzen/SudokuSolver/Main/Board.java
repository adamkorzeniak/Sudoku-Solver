package com.github.adkorzen.SudokuSolver.Main;

import java.io.IOException;

import com.github.adkorzen.SudokuSolver.exceptions.IncorrectValueException;
import com.github.adkorzen.SudokuSolver.fileIO.FileReader;

public class Board {

	private Field[][] fields = new Field[9][9];
	private int[][] results;
	private int unsolvedAmount;

	public Board(String path) {
		unsolvedAmount = 81;
		try {
			results = FileReader.readFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		createFields();
	}

	private void createFields() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				fields[i][j] = new Field(this, j + 1, i + 1);
				if (results[i][j] > 0) {
					fields[i][j].setValue(results[i][j]);
				}
			}
		}
	}

	public void decreaseUnsolvedAmount() {
		unsolvedAmount--;
		if (unsolvedAmount == 0) {
			Checker.printSolution();
		}
	}

	public void solve() {
		Checker.solveBoard(this);
	}

	public int[][] getResult() {
		return results;
	}

	public Field[][] getFields() {
		return fields;
	}

	public void setResult(int x, int y, int value) {
		if (value > 9 || value < 1) {
			throw new IncorrectValueException(value);
		}
		results[y - 1][x - 1] = value;
	}

	public Field getField(int x, int y) {
		return fields[y - 1][x - 1];
	}
}