package service;

public class SyntaxChecker {
  private Set wordsSet;
  
	public boolean isRightSyntax(String command) {
		String[] words = {};
		words = command.split(" ");

		// checking right commannd syntax: a verb + a noun...
		if (!(wordsSet.verbSet.contains(words[0]) || wordsSet.nounsSet.contains(words[1]))) {
			return false;
		}

		return true;
	}

	public boolean isRightName(String n) {
		if (n != "" || n != "\n" || n != "\t") return true;
		return false;
	}
}
