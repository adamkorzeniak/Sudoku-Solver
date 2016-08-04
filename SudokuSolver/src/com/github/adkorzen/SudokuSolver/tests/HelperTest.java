package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;
import com.github.adkorzen.SudokuSolver.main.helper.Helper;

public class HelperTest {

	@Test
	public void StartXSquare_ID3_Returns7() {
		int expected = 7;
		int actual = Helper.startXSquare(3);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void StartXSquare_ID5_Returns4() {
		int expected = 4;
		int actual = Helper.startXSquare(5);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void StartXSquare_ID7_Returns1() {
		int expected = 1;
		int actual = Helper.startXSquare(7);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void StartYSquare_ID3_Returns1() {
		int expected = 1;
		int actual = Helper.startYSquare(3);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void StartYSquare_ID6_Returns4() {
		int expected = 4;
		int actual = Helper.startYSquare(6);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void StartYSquare_ID7_Returns7() {
		int expected = 7;
		int actual = Helper.startYSquare(7);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getSquareID_Field12_Return1() {
		int expected = 1;
		int actual = Helper.getSquareID(new Field(new Board("res/tests/SudokuTest.txt"), 1, 2));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getSquareID_Field61_Return2() {
		int expected = 2;
		int actual = Helper.getSquareID(new Field(new Board("res/tests/SudokuTest.txt"), 6, 1));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getSquareID_Field93_Return2() {
		int expected = 3;
		int actual = Helper.getSquareID(new Field(new Board("res/tests/SudokuTest.txt"), 9, 3));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getSquareID_Field36_Return4() {
		int expected = 4;
		int actual = Helper.getSquareID(new Field(new Board("res/tests/SudokuTest.txt"), 3, 6));
		
		assertEquals(expected, actual);
	}
	@Test
	public void getSquareID_Field66_Return5() {
		int expected = 5;
		int actual = Helper.getSquareID(new Field(new Board("res/tests/SudokuTest.txt"), 6, 6));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getSquareID_Field74_Return6() {
		int expected = 6;
		int actual = Helper.getSquareID(new Field(new Board("res/tests/SudokuTest.txt"), 7, 4));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getSquareID_Field29_Return7() {
		int expected = 7;
		int actual = Helper.getSquareID(new Field(new Board("res/tests/SudokuTest.txt"), 2, 9));
		
		assertEquals(expected, actual);
	}
	@Test
	public void getSquareID_Field68_Return8() {
		int expected = 8;
		int actual = Helper.getSquareID(new Field(new Board("res/tests/SudokuTest.txt"), 6, 8));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getSquareID_Field77_Return9() {
		int expected = 9;
		int actual = Helper.getSquareID(new Field(new Board("res/tests/SudokuTest.txt"), 7, 7));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPossibleCombinations_EmptyList_EmptyList() {
		List<List<Integer>> expected = new ArrayList<List<Integer>>();
		List<List<Integer>> actual = Helper.getPossibleCombinations(new ArrayList<Integer>());
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPossibleCombinations_OneElementList_EmptyList() {
		List<List<Integer>> expected = new ArrayList<List<Integer>>();
		List<Integer> possibleValues = new ArrayList<Integer>();
		possibleValues.add(3);
		
		List<List<Integer>> actual = Helper.getPossibleCombinations(possibleValues);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPossibleCombinations_TwoElementList_EmptyList() {
		List<List<Integer>> expected = new ArrayList<List<Integer>>();
		List<Integer> possibleValues = new ArrayList<Integer>();
		possibleValues.add(3);
		possibleValues.add(7);
		
		List<List<Integer>> actual = Helper.getPossibleCombinations(possibleValues);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPossibleCombinations_TwoElementList_ListOfCombinations() {
		List<List<Integer>> expected = new ArrayList<List<Integer>>();
		List<Integer> expectedResult1 = new ArrayList<Integer>();
		List<Integer> expectedResult2 = new ArrayList<Integer>();
		List<Integer> expectedResult3 = new ArrayList<Integer>();
		expectedResult1.add(7);
		expectedResult1.add(9);
		expectedResult2.add(3);
		expectedResult2.add(9);
		expectedResult3.add(3);
		expectedResult3.add(7);
		expected.add(expectedResult1);
		expected.add(expectedResult2);
		expected.add(expectedResult3);
		List<Integer> possibleValues = new ArrayList<Integer>();
		possibleValues.add(3);
		possibleValues.add(7);
		possibleValues.add(9);
		
		List<List<Integer>> actual = Helper.getPossibleCombinations(possibleValues);
		
		assertEquals(expected, actual);
	}

}
