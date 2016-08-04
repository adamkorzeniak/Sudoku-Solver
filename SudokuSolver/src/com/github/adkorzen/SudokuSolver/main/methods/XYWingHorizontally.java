package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;

public class XYWingHorizontally extends AbstractXYWing {

	
	protected int acquireLineCoordinate(Field field) {
		return field.getY();
	}
	
	protected Field acquireField(int line, int i) {
		return board.getField(i, line);
	}
	
	protected void check() {
		for (Field f : horizontal) {
			if (f.getPossibleCount() == 2) {
				checkDirection(f);
			}
		}
	}
	
	protected void checkOtherDirection(int toMatch) {
		for (Field f : vertical) {
			if (f.getPossibleCount() == 2) {
				checkIfMatches(f, toMatch);
			}
		}
	}

	public static List<Field> getEligibleFields(Board board, Field field) {
		List<Field> result = new ArrayList<Field>();
		int line = field.getY();
		for (int i = 1; i < 10; i++) {
			
			Field toCheck = board.getField(i, line);
			if (toCheck.getPossibleCount() == 2 && !toCheck.equals(field)) {
				result.add(toCheck);
			}
		}
		return result;
	}
}
