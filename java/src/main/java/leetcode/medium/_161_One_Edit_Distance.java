package leetcode.medium;

import java.lang.Math;

class _161_One_Edit_Distance {
	public static void main(String[] args) {
		System.out.println(new _161_One_Edit_Distance().oneEdit("ab", "bb"));
	}

	public boolean oneEdit(String s, String t) {
		int slen = s.length(), tlen = t.length();
		int i = 0, j = 0;
		if (Math.abs(slen - tlen) > 1) {
			return false;
		}

		boolean hasEdit = false;
		while (i < slen && j < tlen) {
			if (s.charAt(i) != t.charAt(j)) {
				if (hasEdit) {
					return false;
				} else {
					hasEdit = true;
					if (slen == tlen) {
						i++;
						j++;
					} else if (slen < tlen) {
						j++;
					} else {
						i++;
					}
				}
			} else {
				i++;
				j++;				
			}
		}
		if (i != slen || j != tlen) {
		    hasEdit = true;
		}
		return hasEdit;
	}
}