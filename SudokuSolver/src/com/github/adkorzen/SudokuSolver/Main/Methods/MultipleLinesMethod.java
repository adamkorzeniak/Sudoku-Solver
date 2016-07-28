package com.github.adkorzen.SudokuSolver.Main.Methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.Main.Board;
import com.github.adkorzen.SudokuSolver.Main.Checker;
import com.github.adkorzen.SudokuSolver.Main.Field;

public class MultipleLinesMethod {
	private static Board board;

	public static void run(Board b) {
		board = b;
		multipleLinesMethod();
	}
	// consists both: Double Pairs and Multiple Lines Methods
	private static void multipleLinesMethod() {
		List<List<Field>> lists = null;
		List<Field> arrayToCheck = null;
		for (int possible = 1; possible < 10; possible++) {
			lists = new ArrayList<List<Field>>();
			for (int square = 1; square < 10; square++) {
				arrayToCheck = new ArrayList<Field>();
				int startX = Checker.startXSquare(square);
				int startY = Checker.startYSquare(square);
				for (int j = startY; j < startY + 3; j++) {
					for (int i = startX; i < startX + 3; i++) {
						Field toCheck = board.getField(i, j);
						if (toCheck.getValue() == 0 && toCheck.isPossible(possible)) {
							arrayToCheck.add(toCheck);
						}
					}
				}
				lists.add(arrayToCheck);
			}
			checkMultipleLines(lists, possible);
		}

	}

	private static void checkMultipleLines(List<List<Field>> list, int possible) {
		checkMultipleLinesHorizontally(list, possible);
		checkMultipleLinesVertically(list, possible);
	}

	private static void checkMultipleLinesHorizontally(List<List<Field>> list, int possible) {
		int first, second, squareID;
		for (int squareLine = 1; squareLine < 4; squareLine++) {
			for (int square = 1; square < 4; square++) {
				squareID = 3 * (squareLine - 1) + square;
				if (getTwoLines(list, squareID) != null) {
					first = getTwoLines(list, squareID)[0];
					second = getTwoLines(list, squareID)[1];
					for (int comparedSquareID = squareID + 1; comparedSquareID % 3 != 1; comparedSquareID++) {
						if (getTwoLines(list, comparedSquareID) != null) {
							if (getTwoLines(list, comparedSquareID)[0] == first
									&& getTwoLines(list, comparedSquareID)[1] == second) {
								multipleLinesCrossOutHorizontally(squareID, comparedSquareID, first, second, possible);
							}
						}
					}
				}
			}
		}
	}

	private static int[] getTwoLines(List<List<Field>> list, int squareID) {
		List<Field> squareList = list.get(squareID - 1);
		if (squareList.size() > 1) {
			int firstLine = 0;
			int secondLine = 0;
			int temporary = 0;
			int[] result = new int[2];
			firstLine = squareList.get(0).getY();

			for (int i = 1; i < squareList.size(); i++) {
				temporary = squareList.get(i).getY();
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

	private static void multipleLinesCrossOutHorizontally(int squareID, int comparedSquareID, int first, int second,
			int possible) {
		int squareToCrossOut = 0;
		if (comparedSquareID % 3 != 0) {
			squareToCrossOut = comparedSquareID + 1;
		} else if (squareID % 3 == 1) {
			squareToCrossOut = squareID + 1;
		} else {
			squareToCrossOut = squareID - 1;
		}
		int[] lines = new int[2];
		lines[0] = first;
		lines[1] = second;
		int x = ((squareToCrossOut - 1) % 3) * 3 + 1;
		Field toCrossOut = null;
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 3; i++) {
				toCrossOut = board.getField(x + i, lines[j]);
				toCrossOut.setImpossibleValue(possible);
			}
		}
	}

	private static void checkMultipleLinesVertically(List<List<Field>> list, int possible) {
		int first, second, squareID;
		for (int squareColumn = 1; squareColumn < 4; squareColumn++) {
			for (int square = 1; square < 4; square++) {
				squareID = (square - 1) * 3 + squareColumn;
				if (getTwoColumns(list, squareID) != null) {
					first = getTwoColumns(list, squareID)[0];
					second = getTwoColumns(list, squareID)[1];
					for (int comparedSquareID = squareID + 3; comparedSquareID < 7
							+ squareID % 3; comparedSquareID += 3) {
						if (getTwoColumns(list, comparedSquareID) != null) {
							if (getTwoColumns(list, comparedSquareID)[0] == first
									&& getTwoColumns(list, comparedSquareID)[1] == second) {
								multipleLinesCrossOutVertically(squareID, comparedSquareID, first, second, possible);
							}
						}
					}
				}
			}
		}
	}

	private static int[] getTwoColumns(List<List<Field>> list, int squareID) {
		List<Field> squareList = list.get(squareID - 1);
		if (squareList.size() > 1) {
			int firstColumn = 0;
			int secondColumn = 0;
			int temporary = 0;
			int[] result = new int[2];
			firstColumn = squareList.get(0).getX();

			for (int i = 1; i < squareList.size(); i++) {
				temporary = squareList.get(i).getX();
				if (temporary != firstColumn) {
					if (secondColumn == 0) {
						secondColumn = temporary;
					} else if (temporary != secondColumn) {
						return null;
					}
				}
			}
			if (firstColumn < secondColumn) {
				result[0] = firstColumn;
				result[1] = secondColumn;
			} else {
				result[0] = secondColumn;
				result[1] = firstColumn;
			}
			return result;
		}
		return null;
	}

	private static void multipleLinesCrossOutVertically(int squareID, int comparedSquareID, int first, int second,
			int possible) {
		int squareToCrossOut = 0;
		if (comparedSquareID < 7) {
			squareToCrossOut = comparedSquareID + 3;
		} else if (squareID > 3) {
			squareToCrossOut = squareID - 3;
		} else {
			squareToCrossOut = squareID + 3;
		}
		int[] columns = new int[2];
		columns[0] = first;
		columns[1] = second;
		int y = ((squareToCrossOut - 1) / 3) * 3 + 1;
		Field toCrossOut = null;
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 2; i++) {
				toCrossOut = board.getField(columns[i], y + j);
				toCrossOut.setImpossibleValue(possible);
			}
		}
	}
}
