package com.github.adkorzen.SudokuSolver.Main;

public class Main {
	public static void main(String[] args) {
		Board board = new Board("res/tests/Test4.txt");
		board.solve();
		// if not solved print how much it solved
		Checker.printSolution();
		boolean isNotIncorrect = Checker.isSolutionNotIncorrect(board);
		System.out.println("Is not Incorrect: " + isNotIncorrect);
	}
}
