package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Field;

public class CandidateLinesVertically extends AbstractCandidateLines {


	
	protected Field acquireField(List<Field> arrayToCheck, int i) {
		return board.getField(arrayToCheck.get(0).getX(), i);
	}
	
	protected boolean fieldOnOtherLine(List<Field> arrayToCheck, int i) {
		if (arrayToCheck.get(i).getX() != arrayToCheck.get(0).getX()) {
			return true;
		}
		return false;
	}
}
