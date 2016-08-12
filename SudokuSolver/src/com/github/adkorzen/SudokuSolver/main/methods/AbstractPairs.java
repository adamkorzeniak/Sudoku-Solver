package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;
import com.github.adkorzen.SudokuSolver.main.helper.Helper;

public abstract class AbstractPairs {

	protected Board board;
	protected Field field;
	protected List<Integer> possibleValues;
	protected List<Field> emptyFields;
	protected List<Field> arrayToCheck;
	protected List<List<Integer>> possibleCombinations;

	protected void setUpLists(int line) {
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
	}

	protected List<Integer> setAllValuesPossible() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			result.add(i);
		}
		return result;
	}

	protected abstract Field acquireField(int line, int i);
}
