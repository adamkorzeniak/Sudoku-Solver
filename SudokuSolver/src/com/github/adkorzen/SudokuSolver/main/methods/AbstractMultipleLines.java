package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;

public abstract class AbstractMultipleLines {
	protected Board board;

	protected void run(Board b, List<List<Field>> list, int possible) {
		board = b;
		check(list, possible);
	}

	protected void check(List<List<Field>> list, int possible) {
		int firstLine, secondLine, squareID;
		for (int squareLine = 1; squareLine < 4; squareLine++) {
			for (int square = 1; square < 3; square++) {
				squareID = getSquareID(squareLine, square);
				if (getTwoLines(list, squareID) != null) {
					firstLine = getTwoLines(list, squareID)[0];
					secondLine = getTwoLines(list, squareID)[1];
					compareSquares(list, squareID, firstLine, secondLine, possible);
				}
			}
		}
	}

	protected abstract int getSquareID(int squareLine, int square);

	protected int[] getTwoLines(List<List<Field>> list, int squareID) {
		List<Field> squareList = list.get(squareID - 1);
		if (squareList.size() > 1) {
			int firstLine = 0;
			int secondLine = 0;
			int temporary = 0;
			int[] result = new int[2];
			firstLine = getLineCoordinate(squareList, 0);

			for (int i = 1; i < squareList.size(); i++) {
				temporary = getLineCoordinate(squareList, i);
				;
				if (temporary != firstLine) {
					if (secondLine == 0) {
						secondLine = temporary;
					} else if (temporary != secondLine) {
						return null;
					}
				}
			}
			if (firstLine < secondLine) {
				result[0] = firstLine;
				result[1] = secondLine;
			} else {
				result[0] = secondLine;
				result[1] = firstLine;
			}
			return result;
		}
		return null;
	}

	protected abstract void compareSquares(List<List<Field>> list, int squareID, int firstLine, int secondLine,
			int possible);

	protected abstract int getLineCoordinate(List<Field> squareList, int i);

	protected void compareSquareLines(List<List<Field>> list, int squareID, int comparedSquareID, int firstLine,
			int secondLine, int possible) {
		if (getTwoLines(list, comparedSquareID) != null) {
			if (getTwoLines(list, comparedSquareID)[0] == firstLine
					&& getTwoLines(list, comparedSquareID)[1] == secondLine) {
				crossOut(squareID, comparedSquareID, firstLine, secondLine, possible);
			}
		}
	}

	protected void crossOut(int squareID, int comparedSquareID, int first, int second, int possible) {
		int squareToCrossOut = getSquareToCrossOut(squareID, comparedSquareID);
		int[] lines = new int[2];
		lines[0] = first;
		lines[1] = second;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				Field toCrossOut = getFieldToCrossOut(squareToCrossOut, lines, i, j);
				toCrossOut.setImpossibleValue(board, possible);
			}
		}
	}

	protected abstract int getSquareToCrossOut(int squareID, int comparedSquareID);

	protected abstract Field getFieldToCrossOut(int squareToCrossOut, int[] lines, int i, int j);
}
