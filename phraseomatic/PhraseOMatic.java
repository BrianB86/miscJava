package phraseomatic;

public class PhraseOMatic {
	public static void main(String[] args) {
		// create some arrays with words to choose from.
		String[] wordList1 = { "24/7", "multi-Tier", "30,000 foot", "B-to-B",
				"win-win", "front-end", "web-scale", "pervasive", "smart",
				"six-sigma", "critical-path", "dynamic" };

		String[] wordList2 = { "empowered", "sticky", "value-added",
				"oriented", "centric", "distributed", "clustard", "branded",
				"outside-the-box", "positioned", "networked", "focused",
				"leveraged", "aligned", "targeted", "shared", "cooperative",
				"accelerated" };

		String[] wordList3 = { "process", "tipping-point", "solution",
				"architecture", "core competency", "strategy", "mindshare",
				"portal", "space", "vision", "paradigm", "mission" };

		// find out how many word are in each set.
		int oneLength = wordList1.length;
		int twoLength = wordList2.length;
		int threeLength = wordList3.length;

		// generate three random numbers
		int rand1 = (int) (Math.random() * oneLength);
		int rand2 = (int) (Math.random() * twoLength);
		int rand3 = (int) (Math.random() * threeLength);

		// build the new phrase
		String phrase = wordList1[rand1] + " " + wordList2[rand2] + " "
				+ wordList3[rand3];

		// Print it
		System.out.println("what we need is a " + phrase);
	}

}
