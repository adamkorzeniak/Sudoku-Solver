package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;

public abstract class AbstractWing {

	protected Board board;

	public void run(Board b) {
		board = b;
		check();
	}
	
	protected void check() {
		for (int value = 1; value < 10; value++) {
			List<List<Field>> linesWithTwoPossibleFields = getFieldList(value);
			if (linesWithTwoPossibleFields.size() > 1) {
				checkXWing(linesWithTwoPossibleFields, value);
			}
		}
	}
	
	protected void checkXWing(List<List<Field>> linesWithTwoPossibleFields, int value) {
		for (int i = 0; i < linesWithTwoPossibleFields.size() - 1; i++) {
			List<Field> list = linesWithTwoPossibleFields.get(i);

			int firstPerpendicular = acquirePerpendicularLineCoordinate(list, 0);
			int secondPerpendicular = acquirePerpendicularLineCoordinate(list, 1);
			for (int j = i + 1; j < linesWithTwoPossibleFields.size(); j++){
				List<Field> list2 = linesWithTwoPossibleFields.get(j);
				if (firstPerpendicular != acquirePerpendicularLineCoordinate(list2, 0)) {
					continue;
				} else if(secondPerpendicular != acquirePerpendicularLineCoordinate(list2, 1)) {
					continue;
				}
				crossOut(firstPerpendicular, secondPerpendicular, list, list2, value);
			}
		}
	}
	
	protected abstract int acquirePerpendicularLineCoordinate(List<Field> list, int i);
	protected abstract Field acquireField(int line, int i);

	protected void crossOut(int firstPerpendicular, int secondPerpendicular, List<Field> list, List<Field> list2,
			int value) {
		for (int i = 1; i < 10; i++) {
			Field field = acquireField(firstPerpendicular, i);
			Field field2 = acquireField(secondPerpendicular, i);
			if (!list.contains(field) && !list2.contains(field)) {
				field.setImpossibleValue(value);
				field2.setImpossibleValue(value);
			}
		}
		
	}

	protected List<List<Field>> getFieldList(int value) {
		List<List<Field>> result = new ArrayList<List<Field>>();
		List<Field> temporary = null;
		for (int j = 1; j < 10; j++) {
			temporary = new ArrayList<Field>();
			for (int i = 1; i < 10; i++) {
				Field field = acquireField(i, j);
				if (field.isPossible(value)) {
					temporary.add(field);
				}
			}
			if (temporary.size() == 2) {
				result.add(temporary);
			}
		}
		return result;
	}
}
