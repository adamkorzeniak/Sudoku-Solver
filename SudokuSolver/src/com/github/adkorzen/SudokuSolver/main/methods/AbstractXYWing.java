package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;

public abstract class AbstractXYWing {

	protected Board board;
	protected Field primary;
	protected List<Field> horizontal;
	protected List<Field> vertical;
	protected List<Field> square;
	protected int firstPossibility;
	protected int secondPossibility;
	protected int thirdPossibility;
	protected Field firstField;
	protected Field secondField;

	public void run(Board board, Field field, List<Field> horizontal, List<Field> vertical, List<Field> square) {
		this.board = board;
		this.primary = field;
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.square = square;
		firstPossibility = primary.getPossibleValues().get(0);
		secondPossibility = primary.getPossibleValues().get(1);
		check();
	}

	protected abstract void check();

	protected void checkDirection(Field f) {
		int first = f.getPossibleValues().get(0);
		int second = f.getPossibleValues().get(1);
		int toMatch = 0;

		if (first != firstPossibility || second != secondPossibility) {
			if (first == firstPossibility) {
				thirdPossibility = second;
				toMatch = secondPossibility;
			} else if (first == secondPossibility) {
				thirdPossibility = second;
				toMatch = firstPossibility;
			} else if (second == firstPossibility) {
				thirdPossibility = first;
				toMatch = secondPossibility;
			} else if (second == secondPossibility) {
				thirdPossibility = first;
				toMatch = firstPossibility;
			} else {
				return;
			}
			firstField = f;
			checkOtherDirection(toMatch);
			checkSquare(toMatch);
		}
	}

	protected abstract void checkOtherDirection(int toMatch);

	protected void checkSquare(int toMatch) {
		for (Field f : square) {
			if (f.getPossibleCount() == 2) {
				checkIfMatches(f, toMatch);
			}
		}
	}

	protected void checkIfMatches(Field f, int toMatch) {
		int first = f.getPossibleValues().get(0);
		int second = f.getPossibleValues().get(1);

		if (first == thirdPossibility && second == toMatch || first == toMatch && second == thirdPossibility) {
			secondField = f;
			crossOut(firstField, secondField);
		}
	}

	protected void crossOut(Field firstField, Field secondField) {
		Field field1 = board.getField(firstField.getX(), secondField.getY());
		Field field2 = board.getField(secondField.getX(), firstField.getY());
		field1.setImpossibleValue(thirdPossibility);
		field2.setImpossibleValue(thirdPossibility);
	}

	protected abstract int acquireLineCoordinate(Field field);

	protected abstract Field acquireField(int line, int i);

}
