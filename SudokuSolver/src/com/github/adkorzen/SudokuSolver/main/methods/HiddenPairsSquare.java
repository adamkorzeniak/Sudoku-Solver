package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Field;
import com.github.adkorzen.SudokuSolver.main.helper.Helper;

public class HiddenPairsSquare extends AbstractHiddenPairs {

	protected void check() {
		for (int square = 1; square < 10; square++) {
			int startX = Helper.startXSquare(square);
			int startY = Helper.startYSquare(square);

			possibleValues = setAllValuesPossible();
			emptyFields = new ArrayList<Field>();
			arrayToCheck = new ArrayList<Field>();
			for (int y = startY; y < startY + 3; y++) {
				for (int x = startX; x < startX + 3; x++) {
					field = acquireField(y, x);
					if (field.getValue() > 0) {
						possibleValues.remove(possibleValues.indexOf(field.getValue()));
					} else {
						emptyFields.add(field);
					}
				}
			}
			possibleCombinations = Helper.getPossibleCombinations(possibleValues);

			for (List<Integer> combination : possibleCombinations) {
				arrayToCheck = getArrayToCheck(combination, emptyFields);
				if (arrayToCheck.size() == combination.size()) {
					crossOut(arrayToCheck, combination);
					continue;
				}
			}
		}
	}
	
	
	protected Field acquireField(int line, int i) {
		return board.getField(i, line);
	}
	
	
}