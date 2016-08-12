package com.github.adkorzen.SudokuSolver.main.helper;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Field;

public class Helper {

	public static int startXSquare(int square) {
		return (square - 1) % 3 * 3 + 1;
	}

	public static int startYSquare(int square) {
		return (square - 1) / 3 * 3 + 1;
	}

	public static int getSquareID(Field field) {
		int x = field.getX();
		int y = field.getY();
		int result = (y - 1) / 3 * 3 + (x + 2) / 3;
		return result;
	}

	public static List<List<Integer>> getPossibleCombinations(List<Integer> possibleValues) {
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

}
