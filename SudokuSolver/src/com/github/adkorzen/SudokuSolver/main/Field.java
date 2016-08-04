package com.github.adkorzen.SudokuSolver.main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.adkorzen.SudokuSolver.exceptions.AmbiguousValueException;
import com.github.adkorzen.SudokuSolver.exceptions.IncorrectValueException;
import com.github.adkorzen.SudokuSolver.exceptions.NoPossibleValueException;
import com.github.adkorzen.SudokuSolver.main.helper.Solver;
import com.github.adkorzen.SudokuSolver.main.methods.SingleCandidateMethod;

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

	public void setImpossibleValue(int value) {
		if (isPossible(value)) {
			possible[value - 1] = false;
			decreasePossibleCount();
			Solver.setChangeHappend();
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
					board.setResult(x, y, value);
					board.decreaseUnsolvedAmount();
					setImpossibleValue(value);
					SingleCandidateMethod.crossOutFromLineColumnSquare(this);
					Solver.setChangeHappend();
					break;
				}
			}
		} else if (possibleCount > 1) {
			throw new AmbiguousValueException();
		} else if (possibleCount < 1) {
			throw new NoPossibleValueException();
		}
	}

	public void setValue(int value) {
		if (this.value == 0) {
			if (value > 0 && value < 10) {
				this.value = value;
				if (board.isCreated()) {
					SingleCandidateMethod.crossOutFromLineColumnSquare(this);
					Solver.setChangeHappend();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(possible);
		result = prime * result + possibleCount;
		result = prime * result + value;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Field other = (Field) obj;
		if (!Arrays.equals(possible, other.possible))
			return false;
		if (possibleCount != other.possibleCount)
			return false;
		if (value != other.value)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
