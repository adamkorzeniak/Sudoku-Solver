package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Field;
import com.github.adkorzen.SudokuSolver.main.helper.Helper;

public class MultipleLinesHorizontally extends AbstractMultipleLines {

	@Override
	protected int getSquareID(int squareLine, int square) {
		return 3 * (squareLine - 1) + square;
	}

	@Override
	protected void compareSquares(List<List<Field>> list, int squareID, int firstLine, int secondLine, int possible) {
		for (int comparedSquareID = squareID + 1; comparedSquareID % 3 != 1; comparedSquareID++) {
			compareSquareLines(list, squareID, comparedSquareID, firstLine, secondLine, possible);
		}
	}

	@Override
	protected int getLineCoordinate(List<Field> squareList, int i) {
		return squareList.get(i).getY();
	}

	@Override
	protected int getSquareToCrossOut(int squareID, int comparedSquareID) {
		if (comparedSquareID % 3 != 0) {
			return comparedSquareID + 1;
		} else if (squareID % 3 == 1) {
			return squareID + 1;
		} else {
			return squareID - 1;
		}
	}

	@Override
	protected Field getFieldToCrossOut(int squareToCrossOut, int[] lines, int i, int j) {
		return board.getField(Helper.startXSquare(squareToCrossOut) + i, lines[j]);
	}
}
