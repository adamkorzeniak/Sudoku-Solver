package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;

public class XYWingMethod {
	private Board board;

	public void run(Board b) {
		board = b;
		xWing();
	}

	private void xWing() {
		Field primary = null;
		for (int x = 1; x < 10; x++) {
			for (int y = 1; y < 10; y++) {
				primary = board.getField(x, y);
				List<Field> horizontal = XYWingHorizontally.getEligibleFields(board, primary);
				List<Field> vertical = XYWingVertically.getEligibleFields(board, primary);
				List<Field> square = XYWingSquare.getEligibleFields(board, primary, horizontal, vertical);

				if (primary.getPossibleCount() == 2) {
					new XYWingHorizontally().run(board, primary, horizontal, vertical, square);
				}
				if (primary.getPossibleCount() == 2) {
					new XYWingVertically().run(board, primary, horizontal, vertical, square);
				}
			}
		}

	}
}
