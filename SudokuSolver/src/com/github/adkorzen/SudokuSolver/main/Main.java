package com.github.adkorzen.SudokuSolver.main;
import com.github.adkorzen.SudokuSolver.main.helper.Solver;

public class Main {
	public static void main(String[] args) {
		Board board = new Board("res/methods/XY-Wing2.txt");
		board.solve();
		
		// if not solved print how much it solved
		Solver.printSolution();
		boolean isNotIncorrect = Solver.isSolutionNotIncorrect(board);
		System.out.println("Is not Incorrect: " + isNotIncorrect);
	}
}
