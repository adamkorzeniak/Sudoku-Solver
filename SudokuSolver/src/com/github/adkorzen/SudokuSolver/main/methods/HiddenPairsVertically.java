package com.github.adkorzen.SudokuSolver.main.methods;


import com.github.adkorzen.SudokuSolver.main.Field;

public class HiddenPairsVertically extends AbstractHiddenPairs {
	
	protected Field acquireField(int line, int i) {
		return board.getField(line, i);
	}
}
