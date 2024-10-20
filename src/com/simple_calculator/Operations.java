package com.simple_calculator;

import java.util.ArrayList;

public class Operations {

	static boolean isOpValid;
	static boolean isDotValid;
	static boolean isSigned;
	static {
		isOpValid = false;
		isDotValid = true;
		isSigned = false;
	}

	public static void setIsOpValid() {
		isOpValid = true;
	}

	public static String addDot(String input) {
		if (isDotValid) {
			isDotValid = false;
			isOpValid = false;
			isSigned = true;
			return input + ".";
		}
		// optional error msg
		return input;
	}

	public static String addAddSign(String input) {
		if (isOpValid) {
			isOpValid = false;
			isDotValid = true;
			isSigned = false;
			return input + "+";
		}
		if (!isSigned) {
			isSigned = true;
			return input + "+";
		}
		return input;
	}

	public static String addSubSign(String input) {
		if (isOpValid) {
			isOpValid = false;
			isDotValid = true;
			isSigned = false;
			return input + "-";
		}
		if (!isSigned) {
			isSigned = true;
			return input + "-";
		}
		return input;
	}

	public static String addMulSign(String input) {
		if (isOpValid) {
			isOpValid = false;
			isDotValid = true;
			isSigned = false;
			return input + "X";
		}
		return input;
	}

	public static String addDivSign(String input) {
		if (isOpValid) {
			isOpValid = false;
			isDotValid = true;
			isSigned = false;
			return input + "/";
		}
		return input;
	}

	public static String clear(String input) { // logic to clear the input field
		if (input.length() != 0) { // if the input field is not empty
			char deletedChar = input.charAt(input.length() - 1);
			input = input.substring(0, input.length() - 1);// input is updated
			if (Character.isLetter(deletedChar) && deletedChar != 'X') {
				isOpValid = false;
				isDotValid = true;
				isSigned = false;
				return "";
			} else if (deletedChar == '+' || deletedChar == '-') { // if the deleted character is + or - operators
				int i = input.length() - 1; // loop back to check weather a dot is already present before finding
											// another operator
				while (i >= 1 && Character.isDigit(input.charAt(i))) { // as long as a digit is found
					if (input.charAt(i - 1) == '.')
						isDotValid = false; // set isDotvalid to false indicating a dot is not present in the current
											// number
					i--;
				}
				if (deletedChar == '-' && input.isEmpty()) { // handles an edge case of negative number obtained as a
																// result or
																// -ve number entered and deleted
					isOpValid = false;
					isSigned = false;
				} else {
					if (isSigned) {
						isSigned = false; // for the first = or - deleted allow an insertion of sign(+ or -)
					} else {
						isOpValid = true; // executed when a + or - has been already deleted
					}
				}
			} else if (deletedChar == '/' || deletedChar == 'X') {
				int i = input.length() - 1;
				while (i > 0 && Character.isDigit(input.charAt(i))) { // check for a dot before allowing another dot
					if (input.charAt(i - 1) == '.')
						isDotValid = false;
					i--;
				}
				isOpValid = true; // allow user to enter another operator
			} else if (deletedChar == '.') {
				isDotValid = true; // if a dot is removed another one can be entered
				if (input.isEmpty()) { // if dot was the first character then only allow a + or - sign
					isSigned = false;
				} else { // check
					switch (input.charAt(input.length() - 1)) { // now check the current last character
					case 'X':
					case '/':
						isSigned = false; // if its a X or / a sign can be added
						break;
					case '+':
					case '-': { // for a + or - check if its ending with -- or ++ if true skip
								// if not(it is a d+, d-, dX-, d/- ) allow a sign
						if (input.length() >= 2 && (input.charAt(input.length() - 2) != '+'
								&& input.charAt(input.length() - 2) != '-')) {
							isSigned = false;
						}
					}
						break;
					default: // the last element is a digit
						isOpValid = true;
					}

				}
			} else { // if the deleted character is a digit
				if (input.isEmpty()) { // if its the last digit
					isOpValid = false; // set isOpValid to false to revert isOpValid=true set by entering it the first
										// time
					isSigned = false; // set isSigned to false to add signed numbers in the start
				} else if (!Character.isDigit(input.charAt(input.length() - 1))) {// if deleted one is not the last
																					// digit
																					// and the character on the
																					// end of current string is in
																					// (--,++ , +, -, X, /, .)
					isOpValid = false; // set isOpValid to false should block further addition of an operator if it is
										// set to true by previously deleted characters.
					if (input.charAt(input.length() - 1) == '.' || (input.length() ==1 &(
							input.charAt(input.length() - 1) == '-'|| input.charAt(input.length() - 1) == '+')) //signed num is entered and deleted or  is a result
							|| (input.length() >= 2 && !Character.isDigit(input.charAt(input.length() - 2))))
						// check weather a sign should be allowed (current input should not end with a .
						// or second char from last should be a digit not an operator like dX+, d/-,
						// d++, d--)
						isSigned = true;
					else
						isSigned = false;
				}
			}
			return input;
		}
		return "";
	}

	public static String findResult(String input) {
		if (input.length() <= 1) {
			return input;
		}
		try {
			if (Character.isDigit(input.charAt(input.length() - 1))) {
				ArrayList<String> inputArray = new ArrayList<String>();
				StringBuilder currNum = new StringBuilder(String.valueOf(input.charAt(0)));
				for (int i = 1; i < input.length(); i++) {
					if (Character.isLetter(input.charAt(i)) && input.charAt(i) != 'X') {
						throw new IllegalArgumentException();
					} else if ((input.charAt(i) >= '0' && input.charAt(i) <= '9') || input.charAt(i) == '.') {
						currNum.append(input.charAt(i));
					} else {
						inputArray.add(currNum.toString());
						inputArray.add(String.valueOf(input.charAt(i)));
						currNum.setLength(0);
						if (input.charAt(i + 1) == '+' || input.charAt(i + 1) == '-') {
							currNum.append(String.valueOf(input.charAt(i + 1)));
							i++;
						}
					}
				}
				inputArray.add(currNum.toString());

				return calculate(inputArray);
			} else {
				System.out.println("Incomplete expression");
				return input;
			}
		} catch (Exception e) {
			System.out.println("Invalid Expression");
			isOpValid = false;
			isDotValid = true;
			isSigned = false;
			return "";
		}
	}

	private static String calculate(ArrayList<String> a) {
		for (int i = 0; i < a.size(); i++) {
			String operator = a.get(i);
			if (operator.equals("X")) {
				a.set(i, String.valueOf(Double.parseDouble(a.get(i - 1)) * Double.parseDouble(a.get(i + 1))));
				a.remove(i - 1);
				a.remove(i);
				i--;
			} else if (operator.equals("/")) {
				a.set(i, String.valueOf(Double.parseDouble(a.get(i - 1)) / Double.parseDouble(a.get(i + 1))));
				a.remove(i - 1);
				a.remove(i);
				i--;
			}
		}
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).equals("infinity") || a.get(i).equals("-Infinity")) {
				System.out.println("ERROR");
				return a.get(i);
			} else {
				String operator = a.get(i);
				if (operator.equals("+")) {
					a.set(i, String.valueOf(Double.parseDouble(a.get(i - 1)) + Double.parseDouble(a.get(i + 1))));
					a.remove(i - 1);
					a.remove(i);
					i--;
				} else if (operator.equals("-")) {
					a.set(i, String.valueOf(Double.parseDouble(a.get(i - 1)) - Double.parseDouble(a.get(i + 1))));
					a.remove(i - 1);
					a.remove(i);
					i--;
				}
			}
		}
		isOpValid = true;
		isDotValid = false;
		isSigned = false;
		return a.get(0);
	}

}
