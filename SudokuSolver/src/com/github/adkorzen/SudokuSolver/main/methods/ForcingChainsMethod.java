package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;

public class ForcingChainsMethod {
	private Board board;

	public void run(Board b) {
		board = b;
		check();
	}

	private void check() {
		Field primary = null;
		for (int y = 1; y < 10; y++) {
			for (int x = 1; x < 10; x++) {
				primary = board.getField(x, y);
				if (primary.getPossibleCount() == 2) {
					startChain(x, y);
					break;
				}
			}
		}
	}

	private void startChain(int x, int y) {
		Board copy = null;
		Field starting = null;
		List<Integer> possibilities = board.getField(x, y).getPossibleValues();
		List<Board> results = new ArrayList<Board>();
		for (int possible : possibilities) {
			copy = new Board(board);
			starting = copy.getField(x, y);
			starting.setImpossibleValue(copy, possible);

			results.add(copy);
		}
		for (int j = 1; j < 10; j++) {
			outer: for (int i = 1; i < 10; i++) {
				Field original = board.getField(i, j);
				if (original.getValue() == 0) {
					int value = 0;
					for (Board b : results) {
						if (value == 0) {
							if (b.getField(i, j).getValue() != 0) {
								value = b.getField(i, j).getValue();
							} else {
								continue outer;
							}
						} else {
							if (b.getField(i, j).getValue() == value) {
								original.setValue(board, value);
							} else {
								continue outer;
							}
							
						}
					}
				}
			}
		}
	}
}
