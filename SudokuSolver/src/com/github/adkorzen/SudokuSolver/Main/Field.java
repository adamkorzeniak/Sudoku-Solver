package com.github.adkorzen.SudokuSolver.Main;

import com.github.adkorzen.SudokuSolver.exceptions.AmbiguousValueException;
import com.github.adkorzen.SudokuSolver.exceptions.NoPossibleValueException;

public class Field {
	private Board board;
	private int x, y;
	private int value;
	private boolean[] possible = new boolean[9];
	private int possibleCount = 9;

	public Field(Board board, int x, int y) {
		this.board = board;
		this.x = x;
		this.y = y;
		setAllValuesPossible();
	}

	private void decreasePossibleCount() {
		possibleCount--;
		if (possibleCount == 1) {
			setValue();
		}
	}

	public boolean isPossible(int value) {
		return possible[value - 1];
	}

	// Test
	public void setImpossibleValue(int value) {
		if (possible[value - 1] = true) {
			possible[value - 1] = false;
			decreasePossibleCount();
		}
	}

	private void setAllValuesPossible() {
		for (int i = 0; i < 9; i++) {
			possible[i] = true;
		}
	}

	public int getValue() {
		return value;
	}

	private void setValue() {
		if (possibleCount == 1) {
			for (int i = 0; i < 9; i++) {
				if (possible[i] == true) {
					value = i + 1;
					break;
				}
			}
		} else if (possibleCount > 1) {
			throw new AmbiguousValueException();
		} else if (possibleCount < 1) {
			throw new NoPossibleValueException();
		}
		board.setResult(x, y, value);
		Checker.updateAfterFilling(x, y, value);
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getPossibleCount() {
		return possibleCount;
	}
}
