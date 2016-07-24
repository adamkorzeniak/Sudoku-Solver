package com.github.adkorzen.SudokuSolver.Main;

public class Main {
	public static void main(String[] args) {
		Board board = new Board("res/Sudoku.txt");
		board.solve();
		boolean isCorrect = Checker.isSolutionCorrect(board);
		System.out.println(isCorrect);
	}
}
