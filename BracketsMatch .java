import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BracketsMatch {

	public static void main(String[] args) {
		
		matchBrackets("D:\\sarala\\A.java");
		
	}
		public static void matchBrackets(String filepath){
		ArrayList<Bracket> paranthesislist = new ArrayList<Bracket>();

		ArrayList<Bracket> curlybraceslist = new ArrayList<Bracket>();

		ArrayList<Bracket> squarebracketslist = new ArrayList<Bracket>();
		String line = null;

		FileReader filereader;
		try {
			filereader = new FileReader(filepath);

			BufferedReader bufferedreader = new BufferedReader(filereader);
			int lineno = 1;

			while ((line = bufferedreader.readLine()) != null) {

				String linewords[] = line.split("\\s");

				for (int j = 0; j < linewords.length; j++) {

					char[] wordcharacters = linewords[j].toCharArray();

					for (int x = 0; x < wordcharacters.length; x++) {
						if (wordcharacters[x] == '{' || wordcharacters[x] == '}') {
							Bracket bracket = new Bracket();
							bracket.setBracket(wordcharacters[x]);
							bracket.setLineno(lineno);
							curlybraceslist.add(bracket);
						}

						if (wordcharacters[x] == '(' || wordcharacters[x] == ')') {
							Bracket bracket = new Bracket();
							bracket.setBracket(wordcharacters[x]);
							bracket.setLineno(lineno);
							paranthesislist.add(bracket);

						}
						if (wordcharacters[x] == '[' || wordcharacters[x] == ']') {
							Bracket bracket = new Bracket();
							bracket.setBracket(wordcharacters[x]);
							bracket.setLineno(lineno);
							squarebracketslist.add(bracket);

						}

					}
				}
				lineno = lineno + 1;
			}
			bufferedreader.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		// =========================paranthesis
		// match==========================================

		// ====================right paranthesis match=================
		for (int i = paranthesislist.size() - 1; i >= 0; i--) {

			if (paranthesislist.get(i).getBracket().equals(')')) {
				continue;
			}

			if (paranthesislist.get(i).getBracket().equals('(')) {

				paranthesislist.get(i).setRMarked(true);

				for (int j = i + 1; j < paranthesislist.size(); j++) {
					if (paranthesislist.get(j).isRMarked() == false) {
						paranthesislist.get(j).setRMarked(true);
						break;
					}

				}

			}
		}

		for (int j = 0; j < paranthesislist.size(); j++) {
			if (paranthesislist.get(j).isRMarked() == false) {
				System.out.println("Paranthesis at Line no " + paranthesislist.get(j).getLineno()
						+ " is closed without a starting tag");
			}

		}

		// ===============left paranthesis match=========================
		for (int i = 0; i < paranthesislist.size(); i++) {

			if (paranthesislist.get(i).getBracket().equals('(')) {
				continue;
			}

			if (paranthesislist.get(i).getBracket().equals(')')) {

				paranthesislist.get(i).setLMarked(true);

				for (int j = i - 1; j >= 0; j--) {
					if (paranthesislist.get(j).isLMarked() == false) {
						paranthesislist.get(j).setLMarked(true);
						break;
					}

				}

			}
		}

		for (int j = 0; j < paranthesislist.size(); j++) {
			if (paranthesislist.get(j).isLMarked() == false) {
				System.out.println("Paranthesis at Line no " + paranthesislist.get(j).getLineno() + " must be closed");
			}

		}

		// System.out.println(paranthesislist);
		// ===================================curly braces
		// match==============================

		// ==========right curly braces match==============

		for (int i = curlybraceslist.size() - 1; i >= 0; i--) {

			if (curlybraceslist.get(i).getBracket().equals('}')) {
				continue;
			}

			if (curlybraceslist.get(i).getBracket().equals('{')) {

				curlybraceslist.get(i).setRMarked(true);

				for (int j = i + 1; j < curlybraceslist.size(); j++) {
					if (curlybraceslist.get(j).isRMarked() == false) {
						curlybraceslist.get(j).setRMarked(true);
						break;
					}

				}

			}
		}

		for (int j = 0; j < curlybraceslist.size(); j++) {
			if (curlybraceslist.get(j).isRMarked() == false) {
				System.out.println("Curly brace at Line no " + curlybraceslist.get(j).getLineno()
						+ " is closed without a starting tag");
			}

		}

		// ===========================left curly braces
		// match================

		for (int i = 0; i < curlybraceslist.size(); i++) {

			if (curlybraceslist.get(i).getBracket().equals('{')) {
				continue;
			}

			if (curlybraceslist.get(i).getBracket().equals('}')) {

				curlybraceslist.get(i).setLMarked(true);

				for (int j = i - 1; j >= 0; j--) {
					if (curlybraceslist.get(j).isLMarked() == false) {
						curlybraceslist.get(j).setLMarked(true);
						break;
					}

				}

			}
		}

		for (int j = 0; j < curlybraceslist.size(); j++) {
			if (curlybraceslist.get(j).isLMarked() == false) {
				System.out.println("Curly brace at Line no " + curlybraceslist.get(j).getLineno() + " must be closed");
			}

		}
		// System.out.println(curlybraceslist);
		
		//=================square brackets match================
		
		//========right square brackets match===============

		for (int i = squarebracketslist.size() - 1; i >= 0; i--) {

			if (squarebracketslist.get(i).getBracket().equals(']')) {
				continue;
			}

			if (squarebracketslist.get(i).getBracket().equals('[')) {

				squarebracketslist.get(i).setRMarked(true);

				for (int j = i + 1; j < squarebracketslist.size(); j++) {
					if (squarebracketslist.get(j).isRMarked() == false) {
						squarebracketslist.get(j).setRMarked(true);
						break;
					}

				}

			}
		}

		for (int j = 0; j < squarebracketslist.size(); j++) {
			if (squarebracketslist.get(j).isRMarked() == false) {
				System.out.println(" Square bracket at Line no " + squarebracketslist.get(j).getLineno()
						+ " is closed without a starting tag");
			}

		}

		// ===========================left square brackets
		// match================

		for (int i = 0; i < squarebracketslist.size(); i++) {

			if (squarebracketslist.get(i).getBracket().equals('[')) {
				continue;
			}

			if (squarebracketslist.get(i).getBracket().equals(']')) {

				squarebracketslist.get(i).setLMarked(true);

				for (int j = i - 1; j >= 0; j--) {
					if (squarebracketslist.get(j).isLMarked() == false) {
						squarebracketslist.get(j).setLMarked(true);
						break;
					}

				}

			}
		}

		for (int j = 0; j < squarebracketslist.size(); j++) {
			if (squarebracketslist.get(j).isLMarked() == false) {
				System.out.println("Square bracket at Line no " + squarebracketslist.get(j).getLineno() + " must be closed");
			}

		}

	
	}
}
