package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Field;
import com.github.adkorzen.SudokuSolver.main.helper.Helper;

public class SinglePositionSquare extends AbstractSinglePosition {

	@Override
	public void check() {
		List<Field> possiblePosition = null;
		for (int square = 1; square < 10; square++) {
			int startX = Helper.startXSquare(square);
			int startY = Helper.startYSquare(square);
			for (int value = 1; value < 10; value++) {
				possiblePosition = new ArrayList<Field>();
				for (int i = startX; i < startX + 3; i++) {
					for (int j = startY; j < startY + 3; j++) {
						addToPossiblePosition(possiblePosition, value, i, j);
					}
				}
				isOnlySolution(possiblePosition, value);
			}
		}
	}

	@Override
	public Field acquireField(int i, int j) {
		return board.getField(i, j);
	}
}
