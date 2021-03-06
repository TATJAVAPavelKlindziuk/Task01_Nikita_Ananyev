package com.ananyev.task2;

public class NumberChecker {
	public static final long serialVersionUID = 42L;

	public boolean searchForMistakesInNumbers(String[] args) {
		return (hasAllScores(args) && checkForSpecialSymbols(args) && isZeroInFirstNumber(args[0]));
	}

	protected boolean hasAllScores(String[] args) {
		if (args.length == 0) {
			System.out.println("Enter values");
			return false;
		}
		if ((args.length > 3) || (args.length < 3)) {
			System.out.println("Enter only 3 values");
			return false;
		} else
			return true;
	}

	protected boolean checkForSpecialSymbols(String[] args) {
		boolean returned = false;
		String regex = "\\d+";
		for (String line : args) {
			if (!line.matches(regex)) {
				System.out.println("Only numbers allowed.Please try again.");
				returned = false;
			} else {
				returned = true;
			}
		}
		return returned;
	}

	protected boolean isZeroInFirstNumber(String args) {
		if (args.equals("0")) {
			System.out.println("A mustn't be zero");
			return false;
		} else {
			return true;
		}
	}
}