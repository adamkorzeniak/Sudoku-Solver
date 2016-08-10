package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;

public abstract class AbstractNakedPairs extends AbstractPairs {

	public void run(Board b) {
		board = b;
		check();
	}

	protected void check() {
		outer: for (int line = 1; line < 10; line++) {
			setUpLists(line);
			for (List<Integer> combination : possibleCombinations) {
				arrayToCheck = getArrayToCheck(combination, emptyFields);
				if (arrayToCheck.size() == combination.size()) {
					crossOut(emptyFields, arrayToCheck, combination);
					continue outer;
				}
			}
		}
	}

	protected List<Field> getArrayToCheck(List<Integer> combination, List<Field> emptyFields) {
		List<Field> arrayToCheck = new ArrayList<Field>();
		outer: for (Field f : emptyFields) {
			for (int i = 1; i < 10; i++) {
				if (f.isPossible(i) && !combination.contains(i)) {
					continue outer;
				}
			}
			arrayToCheck.add(f);
		}
		return arrayToCheck;
	}

	protected void crossOut(List<Field> emptyFields, List<Field> arrayToLeave, List<Integer> combination) {
		for (Field f : emptyFields) {
			if (!arrayToLeave.contains(f)) {
				for (Integer i : combination) {
					f.setImpossibleValue(board, i);
				}
			}
		}
	}

}
