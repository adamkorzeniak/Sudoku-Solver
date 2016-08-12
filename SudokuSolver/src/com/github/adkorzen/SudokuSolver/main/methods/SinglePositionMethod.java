package com.github.adkorzen.SudokuSolver.main.methods;

import com.github.adkorzen.SudokuSolver.main.Board;

public class SinglePositionMethod {

	public void run(Board board) {
		singlePosition(board);
	}

	private void singlePosition(Board board) {
		new SinglePositionHorizontally().run(board);
		new SinglePositionVertically().run(board);
		new SinglePositionSquare().run(board);
	}
}
