package com.github.adkorzen.SudokuSolver;

public class Checker {
	
	//Test or not
	public void initialUpdate() {
		for (int i = 0; i < 9; i++) {
			checkLine(i);
			checkColumn(i);
			//need to rethink how these methods will work
		}
	}
	//Not yet implemented
	public static void checkLine(int y) {
		
	}
	public static void checkLine(Field field) {
		checkLine(field.getY());
	}
	//Not yet implemented
	public static void checkColumn(int x) {
		
	}
	public static void checkColumn(Field field) {
		checkColumn(field.getX());
	}
	//Not yet implemented
	public static void checkSquare(int x, int y) {
		
	}
	public static void checkSquare(Field field) {
		checkSquare(field.getX(), field.getY());
	}
	//Not yet implemented
	public static void updateAfterFilling(int x, int y, int value) {
		
	}
}
