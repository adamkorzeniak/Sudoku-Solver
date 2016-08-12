package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Field;

public class SwordfishVertically extends AbstractSwordfish {
	
	@Override
	protected int acquirePerpendicularLineCoordinate(List<Field> list, int i) {
		return list.get(i).getY();
	}

	@Override
	protected Field acquireField(int line, int i) {
		return board.getField(i, line);
	}
}
