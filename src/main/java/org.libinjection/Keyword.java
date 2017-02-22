package org.libinjection;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Keyword {
	HashMap<String, Character> keywordMap = new HashMap<String, Character>();

	Keyword(String filename) {
		String word;
		char type;
		Pattern wordpattern, typepattern;
		Matcher matchedword, matchedtype;


			Scanner in = new Scanner(new InputStreamReader( this.getClass().getResourceAsStream(filename)) );
			String line;
			
			while (in.hasNextLine()) {
				line = in.nextLine();
				wordpattern = Pattern.compile("\\{\"(.*)\"");
				typepattern = Pattern.compile("\'(.*)\'");
				matchedword = wordpattern.matcher(line);
				matchedtype = typepattern.matcher(line);

				while (matchedword.find() && matchedtype.find()) {
					word = matchedword.group(1);
					type = matchedtype.group(1).charAt(0);
					keywordMap.put(word, type);
				}
			}
			in.close();

	}

	void printKeywordMap() {
		for (String keyword : keywordMap.keySet()) {
			String keytype = keywordMap.get(keyword).toString();
			System.out.println("word: " + keyword + " type: " + keytype);
		}
		System.out.println("table size: " + keywordMap.size());
	}
}
