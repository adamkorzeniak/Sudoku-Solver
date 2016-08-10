package com.github.adkorzen.SudokuSolver.main;


import java.io.IOException;

import com.github.adkorzen.SudokuSolver.exceptions.IncorrectValueException;
import com.github.adkorzen.SudokuSolver.fileIO.FileReader;
import com.github.adkorzen.SudokuSolver.main.helper.Solver;
import com.github.adkorzen.SudokuSolver.main.methods.CandidateLinesMethod;
import com.github.adkorzen.SudokuSolver.main.methods.ForcingChainsMethod;
import com.github.adkorzen.SudokuSolver.main.methods.HiddenPairsMethod;
import com.github.adkorzen.SudokuSolver.main.methods.MultipleLinesMethod;
import com.github.adkorzen.SudokuSolver.main.methods.NakedPairsMethod;
import com.github.adkorzen.SudokuSolver.main.methods.SingleCandidateMethod;
import com.github.adkorzen.SudokuSolver.main.methods.SinglePositionMethod;
import com.github.adkorzen.SudokuSolver.main.methods.SwordfishMethod;
import com.github.adkorzen.SudokuSolver.main.methods.XYWingMethod;

public class Board {

	private Field[][] fields = new Field[9][9];
	private int[][] results;
	private int unsolvedAmount;
	private boolean created;
	private boolean changeHappened = false;
	private boolean original;

	public Board(String path) {
		unsolvedAmount = 81;
		original = true;
		try {
			results = FileReader.readFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		createFields();
	}
	
	public Board (Board toClone) {
		this.results = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.results[i][j] = toClone.results[i][j];
			}
		}
		this.unsolvedAmount = toClone.unsolvedAmount;
		this.created = toClone.created;
		this.fields = new Field[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.fields[i][j] = new Field(this, toClone.getField(j + 1, i + 1));
			}
		}
		this.changeHappened = toClone.changeHappened;
	}
	
	private void createFields() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				fields[i][j] = new Field(this, j + 1, i + 1);
				if (results[i][j] > 0) {
					fields[i][j].setValue(this, results[i][j]);
				}
			}
		}
		created = true;
	}

	public void decreaseUnsolvedAmount() {
		unsolvedAmount--;
		if (unsolvedAmount == 0 && original) {
			Solver.printSolution(this);
			boolean isCorrect = Solver.isSolutionCorrect(this);
			if (isCorrect) {
			System.out.print("Solution is correct.");
			} else {
				System.out.print("Solution is wrong.");
			}
			System.exit(0);
		}
	}

	public void solve() {
		new SingleCandidateMethod().run(this);
		do {
			setChangeHappend(false);
			new SinglePositionMethod().run(this);
			new CandidateLinesMethod().run(this);
			new MultipleLinesMethod().run(this);
			new NakedPairsMethod().run(this);
			new HiddenPairsMethod().run(this);
			new SwordfishMethod().run(this);
			new XYWingMethod().run(this);
		} while (changeHappened);
		
		new ForcingChainsMethod().run(this);
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
	
	public boolean isCreated() {
		return created;
	}
	
	public void setChangeHappend(boolean happened) {
		changeHappened = happened;
	}
}