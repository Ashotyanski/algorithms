package leetcode.medium;

import java.util.*;

class _320_Generalized_Abbreviation {
	public static void main(String[] args) {
		List<String> res = new _320_Generalized_Abbreviation().generateAbbreviations("word");
		System.out.println(res);
	}

	public List<String> generateAbbreviations(String word) {
		return new ArrayList<>(generateAbbreviationsSet(word));
	}

	public Set<String> generateAbbreviationsSet(String word) {
		Set<String> res = new HashSet<>();
		int wlen = word.length();
		if (wlen == 0) {
			res.add("");
		} else {
			for (int i = 0; i < wlen; i++) {
				Set<String> subres = generateAbbreviationsSet(word.substring(i + 1, wlen));
				for (String w : subres) {
					String w1 = word.substring(0, i + 1) + w;
					res.add(w1);
					if (w.length() == 0 || !Character.isDigit(w.charAt(0))) {
						String w2 = String.valueOf(i + 1) + w;
						res.add(w2);
					}
				}
			}
		}
		return res;
    }
}