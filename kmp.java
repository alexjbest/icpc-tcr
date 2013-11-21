public class kmp {
	static int[] createTable(char[] w)	{
		int[] t = new int[w.length];
		int i = 2;
		int j = 0;
		t[0] = -1;
		while (i < w.length) {
			if (w[i - 1] == w[j]) t[i++] = j++ + 1;
			else if (j > 0) j = t[j];
			else t[i++] = j = 0;
		}
		return t;
	}

	static int searchKMP(char[] w, char[] s, int[] t) {
		int m = 0;
		int i = 0;
		while ((m + i < s.length) && (i < w.length)) {
			if(s[m+i] == w[i]) i++;
			else {
				m += i - t[i];
				if (i > 0) i = t[i];
			}
		}
		return (i == w.length) ? m : -1;
	}
}
