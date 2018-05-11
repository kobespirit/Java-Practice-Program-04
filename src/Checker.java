/*
 * COMP90041 lab4 
 * Assignment Name: Checker.java
 * Student NO.:653909 
 * Author: Changjian MA 
 * Date: 15/09/2015
 * Java program to implement the Checker class
 */
public class Checker {
	private boolean isRed;
	private int row;
	private int column;

	public Checker(boolean isRed) {
		this.isRed = isRed;
		this.row = 1;
		this.column = 1;
	}
	public Checker(boolean isRed, int row, int column) {
		this.isRed = isRed;
		if (oneStep(row, column)) {		
			this.row = row;
			this.column = column;
		} 
		else{
			this.row = 1;
			this.column = 1;
		}
	}
	public int getRow() {
		return this.row;
	}
	public int getColumn() {
		return this.column;
	}
	public boolean isRed() {
		return this.isRed;
	}
	public void move(int row, int column) {
		if (shiftStep(row, column)) {
			this.row += row;
			this.column += column;
		}
	}
	private boolean oneStep(int row, int column) {
		if (row < 1 || row > 8 || column < 1 || column > 8 || (column % 2 != row % 2)) {
			return false;
		}
		return true;
	}
	
	private boolean shiftStep(int row, int column) {
		if (Math.abs(row) != 1 || Math.abs(column) != 1) {
			return false;
		}
		if (this.isRed == row > 0)
			return false;
		return oneStep(this.row + row, this.column + column);
	}

	
}
