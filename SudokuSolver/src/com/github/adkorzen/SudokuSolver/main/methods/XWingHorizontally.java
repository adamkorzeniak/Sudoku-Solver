package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Field;

public class XWingHorizontally extends AbstractWing {

	
	protected int acquirePerpendicularLineCoordinate(List<Field> list, int i) {
		return list.get(i).getX();
	}
	
	protected Field acquireField(int line, int i) {
		return board.getField(line, i);
	}
}
