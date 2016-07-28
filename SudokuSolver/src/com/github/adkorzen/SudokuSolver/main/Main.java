package com.github.adkorzen.SudokuSolver.main;
import com.github.adkorzen.SudokuSolver.main.helper.Solver;

public class Main {
	public static void main(String[] args) {
//		Board board = new Board("res/Sudoku.txt");
		
		Board board = new Board("res/methods/DoublePairs.txt");
//		Board board = new Board("res/methods/DoublePairs2.txt");	
//		Board board = new Board("res/methods/NakedPairs.txt");
//		Board board = new Board("res/methods/NakedPairs2.txt");
//		Board board = new Board("res/methods/NakedPairs3.txt");
//		Board board = new Board("res/methods/NakedPairs5.txt");	
		
		board.solve();
		
		// if not solved print how much it solved
		Solver.printSolution();
		boolean isNotIncorrect = Solver.isSolutionNotIncorrect(board);
		System.out.println("Is not Incorrect: " + isNotIncorrect);
	}
}
