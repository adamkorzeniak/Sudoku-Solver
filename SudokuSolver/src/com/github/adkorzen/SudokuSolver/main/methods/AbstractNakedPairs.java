package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;
import com.github.adkorzen.SudokuSolver.main.helper.Helper;

public abstract class AbstractNakedPairs {
	
	protected Board board;
	protected Field field;
	protected List<Integer> possibleValues;
	protected List<Field> emptyFields;
	protected List<Field> arrayToCheck;
	List<List<Integer>> possibleCombinations;
	
	public void run(Board b) {
		board = b;
		check();
	}
	
	protected void check() {
		outer: for (int line = 1; line < 10; line++) {
			possibleValues = setAllValuesPossible();
			emptyFields = new ArrayList<Field>();
			arrayToCheck = new ArrayList<Field>();
			for (int i = 1; i < 10; i++) {
				field = acquireField(line, i);
				if (field.getValue() > 0) {
					possibleValues.remove(possibleValues.indexOf(field.getValue()));
				} else {
					emptyFields.add(field);
				}
			}
			possibleCombinations = Helper.getPossibleCombinations(possibleValues);

			for (List<Integer> combination : possibleCombinations) {
				arrayToCheck = getArrayToCheck(combination, emptyFields);
				if (arrayToCheck.size() == combination.size()) {
					Helper.crossOut(emptyFields, arrayToCheck, combination);
					continue outer;
				}
			}
		}
	}

	protected List<Integer> setAllValuesPossible() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			result.add(i);
		}
		return result;
	}
	
	protected abstract Field acquireField(int line, int i);

	protected static List<Field> getArrayToCheck(List<Integer> combination, List<Field> emptyFields) {
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
}
