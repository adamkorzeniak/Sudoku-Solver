package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;

public abstract class AbstractHiddenPairs extends AbstractPairs {

	public void run(Board b) {
		board = b;
		check();
	}

	protected void check() {
		for (int line = 1; line < 10; line++) {
			setUpLists(line);
			for (List<Integer> combination : possibleCombinations) {
				arrayToCheck = getArrayToCheck(combination, emptyFields);
				if (arrayToCheck.size() == combination.size()) {
					crossOut(arrayToCheck, combination);
					continue;
				}
			}
		}
	}

	protected static List<Field> getArrayToCheck(List<Integer> combination, List<Field> emptyFields) {
		List<Field> arrayToCheck = new ArrayList<Field>();
		outer: for (Field f : emptyFields) {
			for (int i: combination) {
				if (f.isPossible(i)) {
					arrayToCheck.add(f);
					continue outer;
				}
			}
		}
		return arrayToCheck;
	}
	
	protected void crossOut(List<Field> arrayCrossOut, List<Integer> combination) {
		for (Field f : arrayCrossOut) {
			for (int value = 1; value < 10; value++) {
				if (!combination.contains(value)) {
					f.setImpossibleValue(value);
				}
			}
		}
	}
}
