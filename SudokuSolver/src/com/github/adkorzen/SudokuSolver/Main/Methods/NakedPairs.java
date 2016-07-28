package com.github.adkorzen.SudokuSolver.Main.Methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.Main.Board;
import com.github.adkorzen.SudokuSolver.Main.Checker;
import com.github.adkorzen.SudokuSolver.Main.Field;

public class NakedPairs {

	private static Board board;
	private static Field field;

	public static void run(Board b) {
		board = b;
		nakedPairsMethod();
	}

	private static void nakedPairsMethod() {
		checkLines();
		checkColumns();
		checkSquares();
	}

	private static void checkLines() {
		List<Integer> possibleValues = null;
		List<Field> emptyFields = null;
		List<Field> arrayToCheck = null;
		List<List<Integer>> possibleCombinations = null;
		outer: for (int line = 1; line < 10; line++) {
			possibleValues = setAllValuesPossible();
			emptyFields = new ArrayList<Field>();
			arrayToCheck = new ArrayList<Field>();
			for (int x = 1; x < 10; x++) {
				field = board.getField(x, line);
				if (field.getValue() > 0) {
					possibleValues.remove(possibleValues.indexOf(field.getValue()));
				} else {
					emptyFields.add(field);
				}
			}
			possibleCombinations = possibleCombinations(possibleValues);

			for (List<Integer> combination : possibleCombinations) {
				arrayToCheck = getArrayToCheck(combination, emptyFields);
				if (arrayToCheck.size() == combination.size()) {
					crossOut(emptyFields, arrayToCheck, combination);
					continue outer;
				}
			}
		}

	}

	private static void checkColumns() {
		List<Integer> possibleValues = null;
		List<Field> emptyFields = null;
		List<Field> arrayToCheck = null;
		List<List<Integer>> possibleCombinations = null;
		outer: for (int column = 1; column < 10; column++) {
			possibleValues = setAllValuesPossible();
			emptyFields = new ArrayList<Field>();
			arrayToCheck = new ArrayList<Field>();
			for (int y = 1; y < 10; y++) {
				field = board.getField(column, y);
				if (field.getValue() > 0) {
					possibleValues.remove(possibleValues.indexOf(field.getValue()));
				} else {
					emptyFields.add(field);
				}
			}
			possibleCombinations = possibleCombinations(possibleValues);

			for (List<Integer> combination : possibleCombinations) {
				arrayToCheck = getArrayToCheck(combination, emptyFields);
				if (arrayToCheck.size() == combination.size()) {
					crossOut(emptyFields, arrayToCheck, combination);
					continue outer;
				}
			}
		}
	}

	private static void checkSquares() {
		List<Integer> possibleValues = null;
		List<Field> emptyFields = null;
		List<Field> arrayToCheck = null;
		List<List<Integer>> possibleCombinations = null;

		outer: for (int square = 1; square < 10; square++) {
			int startX = Checker.startXSquare(square);
			int startY = Checker.startYSquare(square);

			possibleValues = setAllValuesPossible();
			emptyFields = new ArrayList<Field>();
			arrayToCheck = new ArrayList<Field>();
			for (int y = startY; y < startY + 3; y++) {
				for (int x = startX; x < startX + 3; x++) {
					field = board.getField(x, y);
					if (field.getValue() > 0) {
						possibleValues.remove(possibleValues.indexOf(field.getValue()));
					} else {
						emptyFields.add(field);
					}
				}
			}
			possibleCombinations = possibleCombinations(possibleValues);

			for (List<Integer> combination : possibleCombinations) {
				arrayToCheck = getArrayToCheck(combination, emptyFields);
				if (arrayToCheck.size() == combination.size()) {
					crossOut(emptyFields, arrayToCheck, combination);
					continue outer;
				}
			}
		}
	}

	private static List<Integer> setAllValuesPossible() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			result.add(i);
		}
		return result;
	}

	public static List<List<Integer>> possibleCombinations(List<Integer> possibleValues) {
		String binary = null;
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> values = null;
		int possibilities = (int) Math.pow(2, possibleValues.size());

		for (int start = 0; start < possibilities; start++) {
			values = new ArrayList<Integer>();
			String temp = Integer.toBinaryString(start);
			binary = "";
			for (int i = 0; i < possibleValues.size() - temp.length(); i++) {
				binary += "0";
			}
			binary += temp;

			for (int i = 0; i < binary.length(); i++) {
				if (binary.substring(i, i + 1).equals("1")) {
					values.add(possibleValues.get(i));
				}
			}
			if (values.size() > 1 && values.size() < possibleValues.size() && !results.contains(values)) {
				results.add(values);

			}
		}
		return results;
	}

	private static List<Field> getArrayToCheck(List<Integer> combination, List<Field> emptyFields) {
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

	private static void crossOut(List<Field> emptyFields, List<Field> arrayToCheck, List<Integer> combination) {
		for (Field f : emptyFields) {
			if (!arrayToCheck.contains(f)) {
				for (Integer i : combination) {
					f.setImpossibleValue(i);
				}
			}
		}
	}
}
