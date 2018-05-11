/*
 * COMP90041 lab3 
 * Assignment Name: CheckerChecker.java
 * Student NO.:653909 
 * Author: Changjian MA 
 * Date: 10/09/2015
 * Java program to check bugs of the Checker class
 */
public class CheckerChecker {

	public static void main(String[] args) {
		if (testingConstructor() && testingInput() && testingMove()) {
			System.out.println("CORRECT");
		}
		else {
			System.out.println("BUG");
		}
	}
	

	public static boolean testingConstructor() {
		Checker checker = new Checker(true);
		if (!checker.isRed()) {
			return false;
		}
		if (!verifyDoNothing(checker, 1, 1)) {
			return false;
		}

		checker = new Checker(false);
		if (checker.isRed()) {
			return false;
		}
		if (!verifyDoNothing(checker, 1, 1)) {
			return false;
		}
		return true;
	}

	public static boolean testingInput() {
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k < 2; k++) {
					boolean isRed = false;
					if (k == 0) {
						isRed = true;
					}
					Checker checker = new Checker(isRed, i, j);
					if (!verifyRange(checker.getRow(), checker.getColumn())){
						return false;
					}
					if (checker.getRow() != 1 || checker.getColumn() != 1) {
						if (!verifyDoNothing(checker, i, j)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public static boolean testingMove() {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				for (int k = 0; k < 2; k++) {
					boolean isRed = false;
					if (k == 0) {
						isRed = true;
					}
					Checker checker = new Checker(isRed, i, j);
					for (int n = 1; n <= 8; n++) {
						if (!moveStep(checker, 1, 1)) {
							return false;
						}
					}

					checker = new Checker(isRed, i, j);
					for (int n = 1; n <= 8; n++) {
						if (!moveStep(checker, 1, -1)) {
							return false;
						}
					}

					checker = new Checker(isRed, i, j);
					for (int n = 1; n <= 8; n++) {
						if (!moveStep(checker, -1, -1)) {
							return false;
						}
					}

					checker = new Checker(isRed, i, j);
					for (int n = 1; n <= 8; n++) {
						if (!moveStep(checker, -1, 1)) {
							return false;
						}
					}

					checker = new Checker(isRed, i, j);
					if (!moveStep(checker, i, j)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean moveStep(Checker checker, int row, int column) {
		int stayRow = checker.getRow();
		int stayColumn = checker.getColumn();
		if (!verifyMoveing(checker.isRed(), row, column)) {
			checker.move(row, column);
			if (!verifyDoNothing(checker, stayRow, stayColumn)) {
				return false;
			}
		} else {
			checker.move(row, column);
			if (!verifyRange(checker.getRow(), checker.getColumn())) {
				return false;
			}
		}
		return true;
	}

	private static boolean verifyMoveing(boolean isRed, int moveRow, int moveColumn) {
		if (Math.abs(moveRow) != 1 || Math.abs(moveColumn) != 1) {
			return false;
		}
		if (isRed == moveRow > 0) {
			return false;
		}
		return true;
	}

	private static boolean verifyDoNothing(Checker checker, int stayRow, int stayColumn) {
		if (checker.getRow() != stayRow || checker.getColumn() != stayColumn) {
			return false;
		}
		return true;
	}

	private static boolean verifyRange(int row, int column) {
		if (row < 1 || row > 8 || column < 1 || column > 8 || (column % 2 != row % 2)) {
			return false;
		}
		return true;
	}

}
