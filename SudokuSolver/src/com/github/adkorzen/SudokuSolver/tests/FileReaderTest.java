package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.exceptions.FileDoesNotExistException;
import com.github.adkorzen.SudokuSolver.exceptions.FileHoldInvalidEntriesException;
import com.github.adkorzen.SudokuSolver.exceptions.FileHoldTooFewEntriesException;
import com.github.adkorzen.SudokuSolver.exceptions.FileHoldTooManyEntriesException;
import com.github.adkorzen.SudokuSolver.fileIO.FileReader;

public class FileReaderTest {

	@Test(expected = FileDoesNotExistException.class)
	public void ReadFile_FileDoesNotExist_RuntimeExceptionThrown() throws IOException {
		FileReader.readFile("res/tests/FileDoesNotExist.txt");
	}

	@Test(expected = FileHoldTooFewEntriesException.class)
	public void ReadFile_FileHoldFewLowEntries_RuntimeExceptionThrown() throws IOException {
		FileReader.readFile("res/tests/TooShort.txt");
	}
	@Test(expected = FileHoldTooManyEntriesException.class)
	public void ReadFile_FileHoldManyLowEntries_RuntimeExceptionThrown() throws IOException {
		FileReader.readFile("res/tests/TooLong.txt");
	}
	@Test(expected = FileHoldInvalidEntriesException.class)
	public void ReadFile_FileHoldInvalidEntries_RuntimeExceptionThrown() throws IOException {
		FileReader.readFile("res/tests/Invalid.txt");
	}

	@Test()
	public void ReadFile_CorrectFile_ReturnsIntArray() throws IOException {
		int[][] actual = FileReader.readFile("res/tests/SudokuTest.txt");
		int[][] expected = { { 0, 0, 0, 0, 2, 0, 0, 4, 0 }, { 0, 0, 2, 0, 0, 0, 0, 5, 0 },
				{ 4, 1, 8, 0, 0, 0, 0, 0, 0 }, { 0, 9, 5, 0, 0, 0, 0, 6, 1 }, { 0, 0, 4, 0, 0, 0, 0, 0, 2 },
				{ 6, 0, 0, 0, 0, 0, 0, 0, 9 }, { 8, 0, 0, 0, 4, 5, 9, 0, 7 }, { 2, 0, 0, 0, 7, 8, 0, 0, 0 },
				{ 0, 4, 6, 0, 0, 2, 0, 8, 0 } };

		assertArrayEquals(expected, actual);
	}
}
