package com.github.adkorzen.SudokuSolver.main;


import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.exceptions.AmbiguousValueException;
import com.github.adkorzen.SudokuSolver.exceptions.IncorrectValueException;
import com.github.adkorzen.SudokuSolver.exceptions.NoPossibleValueException;
import com.github.adkorzen.SudokuSolver.main.methods.SingleCandidateMethod;

public class Field {
	private int x, y;
	private int value;
	private boolean[] possible = new boolean[9];
	private int possibleCount = 9;

	public Field(Board board, int x, int y) {
		this.x = x;
		this.y = y;
		setAllValuesPossible();
	}
	
	public Field(Board board, Field toClone) {
		this.x = toClone.x;
		this.y = toClone.y;
		this.value = toClone.value;
		this.possible = new boolean[9];
		for (int i = 0; i < 9; i++) {
			this.possible[i] = toClone.possible[i];
		}
		this.possibleCount = toClone.possibleCount;
	}

	private void decreasePossibleCount(Board board) {
		possibleCount--;
		if (possibleCount == 1) {
			setValue(board);
		}
	}

	public boolean isPossible(int value) {
		return possible[value - 1];
	}

	public void setImpossibleValue(Board board, int value) {
		if (isPossible(value)) {
			possible[value - 1] = false;
			decreasePossibleCount(board);
			board.setChangeHappend(true);
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

	private void setValue(Board board) {
		if (possibleCount == 1) {
			for (int i = 0; i < 9; i++) {
				if (possible[i] == true) {
					value = i + 1;
					board.setResult(x, y, value);
					board.decreaseUnsolvedAmount();
					setImpossibleValue(board, value);
					SingleCandidateMethod.crossOutFromLineColumnSquare(board, this);
					board.setChangeHappend(true);
					break;
				}
			}
		} else if (possibleCount > 1) {
			throw new AmbiguousValueException();
		} else if (possibleCount < 1) {
			throw new NoPossibleValueException();
		}
	}

	public void setValue(Board board, int value) {
		if (this.value == 0) {
			if (value > 0 && value < 10) {
				this.value = value;
				if (board.isCreated()) {
					SingleCandidateMethod.crossOutFromLineColumnSquare(board, this);
					board.setChangeHappend(true);
				}
				board.setResult(x, y, value);
				board.decreaseUnsolvedAmount();
				possibleCount = 0;
				for (int i = 0; i < 9; i++) {
					possible[i] = false;
				}
			} else if (value != 0) {
				throw new IncorrectValueException(value);
			}
		}
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
	
	public List<Integer> getPossibleValues() {
		List<Integer> result = new ArrayList<Integer>();
		for (int value = 1; value < 10; value++) {
			if (isPossible(value)) {
				result.add(value);
			}
		}
		return result;
	}

}
