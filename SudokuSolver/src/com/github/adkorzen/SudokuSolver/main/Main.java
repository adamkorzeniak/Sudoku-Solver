package com.github.adkorzen.SudokuSolver.main;

public class Main {
	public static void main(String[] args) {
		Board board = new Board("res/SudokuTrudne.txt");
		board.solve();
	}
}
