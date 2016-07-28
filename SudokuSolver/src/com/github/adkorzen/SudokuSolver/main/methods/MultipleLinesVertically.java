package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Field;
import com.github.adkorzen.SudokuSolver.main.helper.Helper;

public class MultipleLinesVertically extends AbstractMultipleLines {
	
	protected int getSquareID(int squareLine, int square) {
		return (square - 1) * 3 + squareLine;
	}

	protected void compareSquares(List<List<Field>> list, int squareID, int firstLine, int secondLine, int possible) {
		for (int comparedSquareID = squareID + 3; comparedSquareID < 7 + squareID % 3; comparedSquareID += 3) {
			compareSquareLines(list, squareID, comparedSquareID, firstLine, secondLine, possible);
		}
	}

	protected int getLineCoordinate(List<Field> squareList, int i) {
		return squareList.get(i).getX();
	}

	protected int getSquareToCrossOut(int squareID, int comparedSquareID) {
		if (comparedSquareID < 7) {
			return comparedSquareID + 3;
		} else if (squareID > 3) {
			return squareID - 3;
		} else {
			return squareID + 3;
		}
	}
	
	protected Field getFieldToCrossOut(int squareToCrossOut,int[] lines, int i, int j) {
		return board.getField(lines[j], Helper.startYSquare(squareToCrossOut) + i);
	}
}
