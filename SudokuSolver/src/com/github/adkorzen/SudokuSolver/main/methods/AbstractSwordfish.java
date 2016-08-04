package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;

public abstract class AbstractSwordfish {

	protected Board board;

	public void run(Board b) {
		board = b;
		check();
	}

	protected void check() {
		for (int value = 1; value < 10; value++) {
			List<List<Field>> linesWithTwoPossibleFields = getFieldList(value);
			if (linesWithTwoPossibleFields.size() > 1) {
				checkSwordfish(linesWithTwoPossibleFields, value);
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

	protected void checkSwordfish(List<List<Field>> linesWithTwoPossibleFields, int value) {
		for (int i = 0; i < linesWithTwoPossibleFields.size() - 1; i++) {
			List<Field> list = linesWithTwoPossibleFields.get(i);

			int firstPerpendicular = acquirePerpendicularLineCoordinate(list, 0);
			int secondPerpendicular = acquirePerpendicularLineCoordinate(list, 1);

			List<Integer> chainIndexes = new ArrayList<Integer>();
			chainIndexes.add(i);

			List<Integer> perpendicularCoordinates = new ArrayList<Integer>();
			perpendicularCoordinates.add(firstPerpendicular);
			perpendicularCoordinates.add(secondPerpendicular);

			checkChain(linesWithTwoPossibleFields, firstPerpendicular, secondPerpendicular, chainIndexes,
					perpendicularCoordinates, value);
		}
	}

	private void checkChain(List<List<Field>> linesWithTwoPossibleFields, int coordinateToMatch, int finalCoordinate,
			List<Integer> chainIndexes, List<Integer> perpendicularCoordinates, int value) {
		for (int j = chainIndexes.get(0) + 1; j < linesWithTwoPossibleFields.size(); j++) {
			if (!chainIndexes.contains(j)) {
				List<Field> list2 = linesWithTwoPossibleFields.get(j);
				int firstCoordinate = acquirePerpendicularLineCoordinate(list2, 0);
				int secondCoordinate = acquirePerpendicularLineCoordinate(list2, 1);

				if (firstCoordinate == coordinateToMatch) {
					chainIndexes.add(j);
					perpendicularCoordinates.add(firstCoordinate);
					if (secondCoordinate == finalCoordinate) {
						crossOut(linesWithTwoPossibleFields, chainIndexes, perpendicularCoordinates, value);
					} else {
						checkChain(linesWithTwoPossibleFields, secondCoordinate, finalCoordinate, chainIndexes,
								perpendicularCoordinates, value);
					}

				} else if (secondCoordinate == coordinateToMatch) {
					chainIndexes.add(j);
					perpendicularCoordinates.add(firstCoordinate);
					if (firstCoordinate == finalCoordinate) {
						crossOut(linesWithTwoPossibleFields, chainIndexes, perpendicularCoordinates, value);
					} else {
						checkChain(linesWithTwoPossibleFields, firstCoordinate, finalCoordinate, chainIndexes,
								perpendicularCoordinates, value);
					}
				}
			}
		}
	}

	protected void crossOut(List<List<Field>> linesWithTwoPossibleFields, List<Integer> chainIndexes,
			List<Integer> perpendicularCoordinates, int value) {
		
		List<Field> fieldsNotToChange = new ArrayList<Field>();
		for (Integer index: chainIndexes) {
			fieldsNotToChange.add(linesWithTwoPossibleFields.get(index).get(0));
			fieldsNotToChange.add(linesWithTwoPossibleFields.get(index).get(1));
		}
		for (int i = 1; i < 10; i ++) {
			for (Integer coord: perpendicularCoordinates) {
				Field field = acquireField(coord, i);
				if (!fieldsNotToChange.contains(field)) {
					field.setImpossibleValue(value);
				}
			}
		}
	}

	protected abstract int acquirePerpendicularLineCoordinate(List<Field> list, int i);

	protected abstract Field acquireField(int line, int i);
}
