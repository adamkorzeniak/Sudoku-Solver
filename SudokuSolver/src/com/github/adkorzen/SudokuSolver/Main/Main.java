package com.github.adkorzen.SudokuSolver.Main;

public class Main {
	public static void main(String[] args) {
		Board board = new Board("res/sudoku.txt");
		board.solve();
	}
}
