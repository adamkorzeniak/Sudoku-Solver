package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;
import com.github.adkorzen.SudokuSolver.main.helper.Helper;

public class XYWingSquare {

	public static List<Field> getEligibleFields(Board board, Field field, List<Field> horizontal, List<Field> vertical) {
		List<Field> result = new ArrayList<Field>();
		int sqareID = Helper.getSquareID(field);
		int startX = Helper.startXSquare(sqareID);
		int startY = Helper.startYSquare(sqareID);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Field toCheck = board.getField(startX + j, startY + i);
				if (toCheck.getPossibleCount() == 2 && !toCheck.equals(field) && !horizontal.contains(toCheck) && !vertical.contains(toCheck)) {
					result.add(toCheck);
				}
			}
		}
		return result;
	}
}
